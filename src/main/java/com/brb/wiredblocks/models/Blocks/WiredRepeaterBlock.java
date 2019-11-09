package com.brb.wiredblocks.models.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneDiodeBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.TickPriority;
import net.minecraft.world.World;

public class WiredRepeaterBlock extends RedstoneDiodeBlock{
	private final MaterialColor verticalColor;
	public static final BooleanProperty LOCKED = BlockStateProperties.LOCKED;
	public static final IntegerProperty DELAY = BlockStateProperties.DELAY_1_4;
	public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
	public static final DirectionProperty FACING = BlockStateProperties.FACING;

	public WiredRepeaterBlock(Properties properties) {
		super(properties);
		this.verticalColor = null;
		this.setDefaultState(this.stateContainer.getBaseState()
				.with(FACING, Direction.UP)
				.with(DELAY, Integer.valueOf(1))
				.with(LOCKED, Boolean.valueOf(false))
				.with(POWERED, Boolean.valueOf(false)));
	}

	public WiredRepeaterBlock(MaterialColor verticalColor, Properties properties) {
		super(properties);
		this.verticalColor = verticalColor;
		this.setDefaultState(this.stateContainer.getBaseState()
				.with(FACING, Direction.UP)
				.with(DELAY, Integer.valueOf(1))
				.with(LOCKED, Boolean.valueOf(false))
				.with(POWERED, Boolean.valueOf(false)));
		//net.minecraft.block.Blocks
	}

	/**
	 * @deprecated call via {@link IBlockState#getStrongPower(IBlockAccess,BlockPos,EnumFacing)} whenever possible.
	 * Implementing/overriding is fine.
	 */
	@Deprecated
	@Override
	public int getStrongPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
		return blockState.getWeakPower(blockAccess, pos, side);
	}

	/**
	 * @deprecated call via {@link IBlockState#getWeakPower(IBlockAccess,BlockPos,EnumFacing)} whenever possible.
	 * Implementing/overriding is fine.
	 */
	@Deprecated
	@Override
	public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
		if (!blockState.get(POWERED)) {
			return 0;
		} else {
			return blockState.get(FACING) == side.getOpposite() ? this.getActiveSignal(blockAccess, pos, blockState) : 0;
		}
	}

   @Override
   public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
	   if (!player.abilities.allowEdit) {
         return false;
      } else if(state.get(FACING).equals(hit.getFace())){
         worldIn.setBlockState(pos, state.cycle(DELAY), 3);
         return true;
      }
	  return false;
   }

	@Override
	protected int calculateInputStrength(World worldIn, BlockPos pos, BlockState state) {
		Direction direction = state.get(FACING);
		BlockPos blockpos = pos.offset(direction.getOpposite());
		int i = worldIn.getRedstonePower(blockpos, direction.getOpposite());
		if (i >= 15) {
			return i;
		} else {
			BlockState blockstate = worldIn.getBlockState(blockpos);
			i = Math.max(i, blockstate.has(BlockStateProperties.POWER_0_15) ? blockstate.get(BlockStateProperties.POWER_0_15) : 0);
			return i;
		}
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, DELAY, LOCKED, POWERED);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockState blockstate = getDefaultState().with(FACING, context.getFace());
		return blockstate.with(LOCKED, Boolean.valueOf(this.isLocked(context.getWorld(), context.getPos(), blockstate)));
	}

	/**
	 * Get the MapColor for this Block and the given BlockState
	 * @deprecated call via {@link IBlockState#getMapColor(IBlockAccess,BlockPos)} whenever possible.
	 * Implementing/overriding is fine.
	 */
	@Deprecated
	@Override
	public MaterialColor getMaterialColor(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return (state.get(FACING).getAxis() == Direction.Axis.Y ?
			(this.verticalColor == null ? this.materialColor : this.verticalColor)
			: this.materialColor);
	}

	@Override
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos,
			boolean isMoving) {
		if (!this.isLocked(worldIn, pos, state)) {
			boolean flag = state.get(POWERED);
			boolean flag1 = this.shouldBePowered(worldIn, pos, state);
			if (flag != flag1 && !worldIn.getPendingBlockTicks().isTickPending(pos, this)) {
				TickPriority tickpriority = TickPriority.HIGH;
				if (this.isFacingTowardsRepeater(worldIn, pos, state)) {
					tickpriority = TickPriority.EXTREMELY_HIGH;
				} else if (flag) {
					tickpriority = TickPriority.VERY_HIGH;
	            }

				worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.getDelay(state), tickpriority);
			}
		}
	}

	@Override
	public boolean isLocked(IWorldReader worldIn, BlockPos pos, BlockState state) {
		//return this.getPowerOnSides(worldIn, pos, state) > 0;
		return false;
	}

	@Override
	protected int getDelay(BlockState p_196346_1_) {
		return p_196346_1_.get(DELAY) * 2;
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		return true;
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return VoxelShapes.fullCube();
	}

	@Override
	public boolean isFacingTowardsRepeater(IBlockReader worldIn, BlockPos pos, BlockState state) {
		Direction direction = state.get(FACING);
		BlockState blockstate = worldIn.getBlockState(pos.offset(direction));
		if(blockstate.has(FACING)) {
			//ModMain.LOGGER.info(String.format("(%s,%s) -> %s", direction,direction.getOpposite(),blockstate.get(FACING)));
			return isDiode(blockstate) && blockstate.get(FACING) != direction.getOpposite();
		}else if(blockstate.has(HORIZONTAL_FACING)) {
			//ModMain.LOGGER.info(String.format("(%s,%s) -> %s", direction,direction.getOpposite(),blockstate.get(HORIZONTAL_FACING)));
			return isDiode(blockstate) && blockstate.get(HORIZONTAL_FACING) != direction.getOpposite();
		}else
			return false;
	}

	@Override
	protected void notifyNeighbors(World worldIn, BlockPos pos, BlockState state) {
		Direction direction = state.get(FACING);
		BlockPos blockpos = pos.offset(direction);
		BlockState bs = worldIn.getBlockState(blockpos);
		//boolean powered = worldIn.getBlockState(pos).get(POWERED);
		//ModMain.LOGGER.info(String.format("notifyNeighbors(%s,%s): %s",direction,powered,bs));
		if (net.minecraftforge.event.ForgeEventFactory.onNeighborNotify(worldIn, pos, worldIn.getBlockState(pos), java.util.EnumSet.of(direction.getOpposite()), false).isCanceled())
			return;
		worldIn.neighborChanged(blockpos, this, pos);
		worldIn.notifyNeighborsOfStateExcept(blockpos, this, direction);
	}

}
