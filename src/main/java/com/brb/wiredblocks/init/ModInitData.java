package com.brb.wiredblocks.init;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.MaterialColor;

public class ModInitData {
	public static class Data{
		public final MaterialColor materialColor;
		public final Block.Properties properties;
		private final Block block;

		Data(Block blockIn){
			this.materialColor = null;
			this.properties = Block.Properties.from(blockIn);
			this.block = blockIn;
		}
		Data(MaterialColor materialColor, Block blockIn){
			this.materialColor = materialColor;
			this.properties = Block.Properties.from(blockIn);
			this.block = blockIn;
		}

		public Block.Properties getPropertiesClone() {
			return Block.Properties.from(block);
		}
	}

	public static final Data OAK_LOG = new Data(MaterialColor.WOOD, Blocks.OAK_LOG);
	public static final Data SPRUCE_LOG = new Data(MaterialColor.OBSIDIAN, Blocks.SPRUCE_LOG);
	public static final Data BIRCH_LOG = new Data(MaterialColor.SAND, Blocks.BIRCH_LOG);
	public static final Data JUNGLE_LOG = new Data(MaterialColor.DIRT, Blocks.JUNGLE_LOG);
	public static final Data ACACIA_LOG = new Data(MaterialColor.ADOBE, Blocks.ACACIA_LOG);
	public static final Data DARK_OAK_LOG = new Data(MaterialColor.BROWN, Blocks.DARK_OAK_LOG);

	public static final Data STRIPPED_OAK_LOG = new Data(MaterialColor.WOOD, Blocks.STRIPPED_OAK_LOG);
	public static final Data STRIPPED_SPRUCE_LOG = new Data(MaterialColor.OBSIDIAN, Blocks.STRIPPED_SPRUCE_LOG);
 	public static final Data STRIPPED_BIRCH_LOG = new Data(MaterialColor.SAND, Blocks.STRIPPED_BIRCH_LOG);
	public static final Data STRIPPED_JUNGLE_LOG = new Data(MaterialColor.DIRT, Blocks.STRIPPED_JUNGLE_LOG);
	public static final Data STRIPPED_ACACIA_LOG = new Data(MaterialColor.ADOBE, Blocks.STRIPPED_ACACIA_LOG);
	public static final Data STRIPPED_DARK_OAK_LOG = new Data(MaterialColor.BROWN, Blocks.STRIPPED_DARK_OAK_LOG);

	public static final Data OAK_PLANKS = new Data(Blocks.OAK_PLANKS);
	public static final Data SPRUCE_PLANKS = new Data(Blocks.SPRUCE_PLANKS);
	public static final Data BIRCH_PLANKS = new Data(Blocks.BIRCH_PLANKS);
	public static final Data JUNGLE_PLANKS = new Data(Blocks.JUNGLE_PLANKS);
	public static final Data ACACIA_PLANKS = new Data(Blocks.ACACIA_PLANKS);
	public static final Data DARK_OAK_PLANKS = new Data(Blocks.DARK_OAK_PLANKS);

	public static final Data STONE = new Data(Blocks.STONE);
	public static final Data SMOOTH_STONE = new Data(Blocks.SMOOTH_STONE);
	public static final Data COBBLESTONE = new Data(Blocks.COBBLESTONE);
	public static final Data MOSSY_COBBLESTONE = new Data(Blocks.MOSSY_COBBLESTONE);
	public static final Data STONE_BRICKS = new Data(Blocks.STONE_BRICKS);
	public static final Data MOSSY_STONE_BRICKS = new Data(Blocks.MOSSY_STONE_BRICKS);
	public static final Data CHISELED_STONE_BRICKS = new Data(Blocks.CHISELED_STONE_BRICKS);

	public static final Data BRICKS = new Data(Blocks.BRICKS);
	public static final Data IRON_BLOCK = new Data(Blocks.IRON_BLOCK);
	public static final Data DIAMOND_BLOCK = new Data(Blocks.DIAMOND_BLOCK);
	public static final Data GOLD_BLOCK = new Data(Blocks.GOLD_BLOCK);
	public static final Data BOOKSHELF = new Data(Blocks.BOOKSHELF);

}
