package com.brb.wiredblocks.models.Blocks;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.datafixers.util.Pair;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ObserverBlock;
import net.minecraft.block.RepeaterBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WiredBlock extends Block{

	private final MaterialColor verticalColor;
	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
	public static final IntegerProperty POWER = BlockStateProperties.POWER_0_15;
	private boolean canProvidePower = true;
	private final Set<BlockPos> blocksNeedingUpdate = Sets.newHashSet();
	private final Map<Direction.Axis,Pair<Direction,Direction>> axisMap =
			new HashMap<Direction.Axis,Pair<Direction,Direction>>() {
				private static final long serialVersionUID = 1L;

			{
				put(Direction.Axis.X,new Pair<Direction,Direction>(Direction.WEST,Direction.EAST));
				put(Direction.Axis.Y,new Pair<Direction,Direction>(Direction.DOWN,Direction.UP));
				put(Direction.Axis.Z,new Pair<Direction,Direction>(Direction.SOUTH,Direction.NORTH));
			}};

	public WiredBlock(Properties properties) {
		super(properties);
		this.verticalColor = null;
		this.setDefaultState(this.getDefaultState().with(AXIS, Direction.Axis.Y).with(POWER, 0));
	}

	public WiredBlock(MaterialColor verticalColor, Properties properties) {
		super(properties);
		this.verticalColor = verticalColor;
		this.setDefaultState(this.getDefaultState().with(AXIS, Direction.Axis.Y).with(POWER, 0));
	}

	/**
	    * Get the MapColor for this Block and the given BlockState
	    * @deprecated call via {@link IBlockState#getMapColor(IBlockAccess,BlockPos)} whenever possible.
	    * Implementing/overriding is fine.
	    */
	   @Deprecated
		@Override
	public MaterialColor getMaterialColor(BlockState state, IBlockReader worldIn, BlockPos pos) {
	      return (state.get(AXIS) == Direction.Axis.Y ?
	    		  	(this.verticalColor == null ? this.materialColor : this.verticalColor)
	    		  		: this.materialColor);
	   }


	@Override
	public void fillStateContainer(StateContainer.Builder<Block,BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(AXIS,POWER);

	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
	      return this.getDefaultState().with(AXIS, context.getFace().getAxis());
	}

	@Override
	public boolean canProvidePower(BlockState state) {
		return this.canProvidePower;
	}

	@Override
	public int getStrongPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
		return !this.canProvidePower ? 0 : blockState.getWeakPower(blockAccess, pos, side);
	}

	@Override
	public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
		if (!this.canProvidePower) {
	         return 0;
		} else {
			int i = blockState.get(POWER);
			BlockState state_ops = blockAccess.getBlockState(pos.offset(side.getOpposite()));

			if(state_ops.has(POWER))
				return Math.max(0, i-1);
			else
				return i;
	    }
	}


	private int maxSignal(int existingSignal, BlockState neighbor) {
		if (neighbor.getBlock() != this) {
			return existingSignal;
		} else {
			int i = neighbor.get(POWER);
			return i > existingSignal ? i : existingSignal;
		}
	}


	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (oldState.getBlock() != state.getBlock() && !worldIn.isRemote) {
			this.updateSurroundingRedstone(worldIn, pos, state);

			for(Direction direction : Direction.Plane.VERTICAL) {
				worldIn.notifyNeighborsOfStateChange(pos.offset(direction), this);
			}

			for(Direction direction1 : Direction.Plane.HORIZONTAL) {
				this.notifyWireNeighborsOfStateChange(worldIn, pos.offset(direction1));
			}

			for(Direction direction2 : Direction.Plane.HORIZONTAL) {
				BlockPos blockpos = pos.offset(direction2);
				if (worldIn.getBlockState(blockpos).isNormalCube(worldIn, blockpos)) {
					this.notifyWireNeighborsOfStateChange(worldIn, blockpos.up());
				} else {
					this.notifyWireNeighborsOfStateChange(worldIn, blockpos.down());
				}
			}

		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (!isMoving && state.getBlock() != newState.getBlock()) {
			super.onReplaced(state, worldIn, pos, newState, isMoving);

			if (!worldIn.isRemote) {
				for(Direction direction : Direction.values()) {
					worldIn.notifyNeighborsOfStateChange(pos.offset(direction), this);
				}

				this.updateSurroundingRedstone(worldIn, pos, state);

				for(Direction direction1 : Direction.Plane.HORIZONTAL) {
					this.notifyWireNeighborsOfStateChange(worldIn, pos.offset(direction1));
				}

				for(Direction direction2 : Direction.Plane.HORIZONTAL) {
					BlockPos blockpos = pos.offset(direction2);
					if (worldIn.getBlockState(blockpos).isNormalCube(worldIn, blockpos)) {
						this.notifyWireNeighborsOfStateChange(worldIn, blockpos.up());
					} else {
						this.notifyWireNeighborsOfStateChange(worldIn, blockpos.down());
					}
				}

			}
		}
	}

	@Override
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos,
		boolean isMoving) {
		if (!worldIn.isRemote) {
			if (state.isValidPosition(worldIn, pos)) {
				this.updateSurroundingRedstone(worldIn, pos, state);
			} else {
				spawnDrops(state, worldIn, pos);
				worldIn.removeBlock(pos, false);
			}
		}
	}

	private BlockState updateSurroundingRedstone(World worldIn, BlockPos pos, BlockState state)
	{
		state = this.func_212568_b(worldIn, pos, state);
		List<BlockPos> list = Lists.newArrayList(this.blocksNeedingUpdate);
		this.blocksNeedingUpdate.clear();

		for(BlockPos blockpos : list) {
			worldIn.notifyNeighborsOfStateChange(blockpos, this);
		}

		return state;
	}

	private BlockState func_212568_b(World world, BlockPos pos, BlockState state) {
	      BlockState blockstate = state;
	      int i = state.get(POWER);
	      this.canProvidePower = false;
	      int j = world.getRedstonePowerFromNeighbors(pos);
	      this.canProvidePower = true;
	      int k = 0;
	      if (j < 15) {

	         for(Direction direction : Direction.Plane.HORIZONTAL) {
	            BlockPos blockpos = pos.offset(direction);
	            BlockState blockstate1 = world.getBlockState(blockpos);
	            if(blockstate1.getBlock() instanceof WiredBlock)
	            {
	            	Direction.Axis axis,axis1;
	            	axis = state.get(AXIS);
	            	axis1 = blockstate1.get(AXIS);
	            	if( axis.test(direction) || axis1.test(direction) )
	            		 k = this.maxSignal(k, blockstate1);

	            }
	            else
	            	k = this.maxSignal(k, blockstate1);

	            BlockPos blockpos1 = pos.up();

	            if (blockstate1.isNormalCube(world, blockpos) && !world.getBlockState(blockpos1).isNormalCube(world, blockpos1)) {
	            	BlockState blockpos_up = world.getBlockState(blockpos.up());
	            	if( !(blockpos_up.getBlock() instanceof WiredBlock))
	            		k = this.maxSignal(k, blockpos_up);
	            } else if (!blockstate1.isNormalCube(world, blockpos)) {
	            	BlockState blockpos_down = world.getBlockState(blockpos.down());
	            	if( !(blockpos_down.getBlock() instanceof WiredBlock))
	            		k = this.maxSignal(k, blockpos_down);
	            }
	         }

	         for(Direction direction : Direction.Plane.VERTICAL)
	         {
	        	 BlockPos blockpos = pos.offset(direction);
	        	 BlockState blockstate1 = world.getBlockState(blockpos);
	        	 if(blockstate1.getBlock() instanceof WiredBlock)
	        	 {
	        		 Direction.Axis axis,axis1;
	            	axis = state.get(AXIS);
	            	axis1 = blockstate1.get(AXIS);
	            	if( axis.test(direction) || axis1.test(direction) )
	        			 k = this.maxSignal(k, blockstate1);
	        	 }
	         }
	      }

	      int l = k - 1;
	      if (j > l) {
	         l = j;
	      }

	      if (i != l) {
	         state = state.with(POWER, Integer.valueOf(l));
	         if (world.getBlockState(pos) == blockstate) {
	            world.setBlockState(pos, state, 2);
	         }

	         this.blocksNeedingUpdate.add(pos);

	         for(Direction direction1 : Direction.values()) {
	            this.blocksNeedingUpdate.add(pos.offset(direction1));
	         }
	      }

	      return state;
	   }

	protected static boolean canConnectTo(BlockState blockState, IBlockReader world, BlockPos pos, @Nullable Direction side) {
		Block block = blockState.getBlock();
		if (block == Blocks.REDSTONE_WIRE) {
			return true;
		} else if (blockState.getBlock() == Blocks.REPEATER) {
			Direction direction = blockState.get(RepeaterBlock.HORIZONTAL_FACING);
			return direction == side || direction.getOpposite() == side;
		} else if (Blocks.OBSERVER == blockState.getBlock()) {
			return side == blockState.get(ObserverBlock.FACING);
		} else {
			return blockState.canConnectRedstone(world, pos, side) && side != null;
		}
	}

	/**
	    * Calls World.notifyNeighborsOfStateChange() for all neighboring blocks, but only if the given block is a redstone
	    * wire.
	    */
	private void notifyWireNeighborsOfStateChange(World worldIn, BlockPos pos) {
		if (worldIn.getBlockState(pos).getBlock() == this) {
			worldIn.notifyNeighborsOfStateChange(pos, this);

			for(Direction direction : Direction.values()) {
				worldIn.notifyNeighborsOfStateChange(pos.offset(direction), this);
			}

		}
	}

	/* Called periodically clientside on blocks near the player to show effects (like furnace fire particles). Note that
	* this method is unrelated to {@link randomTick} and {@link #needsRandomTick}, and will always be called regardless
	* of whether the block can receive random update ticks
	*/
	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		int i = stateIn.get(POWER);
		Direction.Axis axis = stateIn.get(AXIS);
		if (i != 0) {
			float f = i / 15.0F;
			float f1 = f * 0.6F + 0.4F;
			float f2 = Math.max(0.0F, f * f * 0.7F - 0.5F);
			float f3 = Math.max(0.0F, f * f * 0.6F - 0.7F);


			Direction dir_0 = axisMap.get(axis).getFirst();
			Direction dir_1 = axisMap.get(axis).getSecond();
			Vec3d v_pos = new Vec3d(pos.getX(),pos.getY(),pos.getZ());
			Vec3d vec_0 = new Vec3d(dir_0.getXOffset(),dir_0.getYOffset(),dir_0.getZOffset());
			Vec3d vec_1 = new Vec3d(dir_1.getXOffset(),dir_1.getYOffset(),dir_1.getZOffset());
			//First
			switch (dir_0) {
			case DOWN:
			case WEST:
			case NORTH:
				vec_0 = vec_0.scale(0.0625F);
				break;
			default:
				vec_0 = vec_0.scale(1.0625F);
				break;
			}
			switch (dir_1) {
			case DOWN:
			case WEST:
			case NORTH:
				vec_1 = vec_1.scale(0.0625F);
				break;
			default:
				vec_1 = vec_1.scale(1.0625F);
				break;
			}


			if(worldIn.isAirBlock(pos.offset(dir_0)))
			{
				double offset = + 0.5D + (rand.nextFloat() - 0.5D) * 0.2D;
				switch (axis) {
				case X:
					vec_0 = vec_0.add(new Vec3d(0,offset,0));
					offset = + 0.5D + (rand.nextFloat() - 0.5D) * 0.2D;
					vec_0 = vec_0.add(new Vec3d(0,0,offset));
					break;
				case Y:
					vec_0 = vec_0.add(new Vec3d(offset,0,0));
					offset = + 0.5D + (rand.nextFloat() - 0.5D) * 0.2D;
					vec_0 = vec_0.add(new Vec3d(0,0,offset));
					break;
				case Z:
					vec_0 = vec_0.add(new Vec3d(0,offset,0));
					offset = + 0.5D + (rand.nextFloat() - 0.5D) * 0.2D;
					vec_0 = vec_0.add(new Vec3d(offset,0,0));
					break;
				}

				Vec3d f_pos = v_pos.add(vec_0);
				double d0 = f_pos.getX();
				double d1 = f_pos.getY();
				double d2 = f_pos.getZ();

				worldIn.addParticle(new RedstoneParticleData(f1, f2, f3, 1.0F), d0, d1, d2, 0.0D, 0.0D, 0.0D);
			}


			//Second
			if(worldIn.isAirBlock(pos.offset(dir_1)))
			{
				double offset = + 0.5D + (rand.nextFloat() - 0.5D) * 0.2D;
				switch (axis) {
				case X:
					vec_1 = vec_1.add(new Vec3d(0,offset,0));
					offset = + 0.5D + (rand.nextFloat() - 0.5D) * 0.2D;
					vec_1 = vec_1.add(new Vec3d(0,0,offset));
					break;
				case Y:
					vec_1 = vec_1.add(new Vec3d(offset,0,0));
					offset = + 0.5D + (rand.nextFloat() - 0.5D) * 0.2D;
					vec_1 = vec_1.add(new Vec3d(0,0,offset));
					break;
				case Z:
					vec_1 = vec_1.add(new Vec3d(0,offset,0));
					offset = + 0.5D + (rand.nextFloat() - 0.5D) * 0.2D;
					vec_1 = vec_1.add(new Vec3d(offset,0,0));
					break;
				}

				Vec3d f_pos = v_pos.add(vec_1);
				double d0 = f_pos.getX();
				double d1 = f_pos.getY();
				double d2 = f_pos.getZ();

				worldIn.addParticle(new RedstoneParticleData(f1, f2, f3, 1.0F), d0, d1, d2, 0.0D, 0.0D, 0.0D);
			}
		}
	}



}

