package com.brb.wiredblocks.init;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
@net.minecraftforge.registries.ObjectHolder("wiredblocks")
public class ModItems {

	public static ItemGroup WIRED_ITEM_GROUP = new ItemGroup("Wired Blocks") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModBlocks.WIRED_OAK_LOG);
		}
	};

	public static final Item WIRED_OAK_LOG = register(ModBlocks.WIRED_OAK_LOG, WIRED_ITEM_GROUP);
	public static final Item WIRED_SPRUCE_LOG = register(ModBlocks.WIRED_SPRUCE_LOG, WIRED_ITEM_GROUP);
	public static final Item WIRED_BIRCH_LOG = register(ModBlocks.WIRED_BIRCH_LOG, WIRED_ITEM_GROUP);
	public static final Item WIRED_JUNGLE_LOG = register(ModBlocks.WIRED_JUNGLE_LOG, WIRED_ITEM_GROUP);
	public static final Item WIRED_ACACIA_LOG = register(ModBlocks.WIRED_ACACIA_LOG, WIRED_ITEM_GROUP);
	public static final Item WIRED_DARK_OAK_LOG = register(ModBlocks.WIRED_DARK_OAK_LOG, WIRED_ITEM_GROUP);

	public static final Item WIRED_STRIPPED_OAK_LOG = register(ModBlocks.WIRED_STRIPPED_OAK_LOG, WIRED_ITEM_GROUP);
	public static final Item WIRED_STRIPPED_SPRUCE_LOG = register(ModBlocks.WIRED_STRIPPED_SPRUCE_LOG, WIRED_ITEM_GROUP);
 	public static final Item WIRED_STRIPPED_BIRCH_LOG = register(ModBlocks.WIRED_STRIPPED_BIRCH_LOG, WIRED_ITEM_GROUP);
	public static final Item WIRED_STRIPPED_JUNGLE_LOG = register(ModBlocks.WIRED_STRIPPED_JUNGLE_LOG, WIRED_ITEM_GROUP);
	public static final Item WIRED_STRIPPED_ACACIA_LOG = register(ModBlocks.WIRED_STRIPPED_ACACIA_LOG, WIRED_ITEM_GROUP);
	public static final Item WIRED_STRIPPED_DARK_OAK_LOG = register(ModBlocks.WIRED_STRIPPED_DARK_OAK_LOG, WIRED_ITEM_GROUP);

	public static final Item WIRED_OAK_PLANKS = register(ModBlocks.WIRED_OAK_PLANKS, WIRED_ITEM_GROUP);
	public static final Item WIRED_SPRUCE_PLANKS = register(ModBlocks.WIRED_SPRUCE_PLANKS, WIRED_ITEM_GROUP);
	public static final Item WIRED_BIRCH_PLANKS = register(ModBlocks.WIRED_BIRCH_PLANKS, WIRED_ITEM_GROUP);
	public static final Item WIRED_JUNGLE_PLANKS = register(ModBlocks.WIRED_JUNGLE_PLANKS, WIRED_ITEM_GROUP);
	public static final Item WIRED_ACACIA_PLANKS = register(ModBlocks.WIRED_ACACIA_PLANKS, WIRED_ITEM_GROUP);
	public static final Item WIRED_DARK_OAK_PLANKS = register(ModBlocks.WIRED_DARK_OAK_PLANKS, WIRED_ITEM_GROUP);

	public static final Item WIRED_STONE = register(ModBlocks.WIRED_STONE, WIRED_ITEM_GROUP);
	public static final Item WIRED_SMOOTH_STONE = register(ModBlocks.WIRED_SMOOTH_STONE, WIRED_ITEM_GROUP);
	public static final Item WIRED_COBBLESTONE = register(ModBlocks.WIRED_COBBLESTONE, WIRED_ITEM_GROUP);
	public static final Item WIRED_MOSSY_COBBLESTONE = register(ModBlocks.WIRED_MOSSY_COBBLESTONE, WIRED_ITEM_GROUP);
	public static final Item WIRED_STONE_BRICKS = register(ModBlocks.WIRED_STONE_BRICKS, WIRED_ITEM_GROUP);
	public static final Item WIRED_MOSSY_STONE_BRICKS = register(ModBlocks.WIRED_MOSSY_STONE_BRICKS, WIRED_ITEM_GROUP);
	public static final Item WIRED_CHISELED_STONE_BRICKS = register(ModBlocks.WIRED_CHISELED_STONE_BRICKS, WIRED_ITEM_GROUP);
	public static final Item WIRED_BRICKS = register(ModBlocks.WIRED_BRICKS, WIRED_ITEM_GROUP);
	public static final Item WIRED_IRON_BLOCK = register(ModBlocks.WIRED_IRON_BLOCK, WIRED_ITEM_GROUP);
	public static final Item WIRED_DIAMOND_BLOCK = register(ModBlocks.WIRED_DIAMOND_BLOCK, WIRED_ITEM_GROUP);
	public static final Item WIRED_GOLD_BLOCK = register(ModBlocks.WIRED_GOLD_BLOCK, WIRED_ITEM_GROUP);
	public static final Item WIRED_BOOKSHELF = register(ModBlocks.WIRED_BOOKSHELF, WIRED_ITEM_GROUP);


	private static Item register(Block p_221545_0_) {
		return register(new BlockItem(p_221545_0_, new Item.Properties()));
	}

	private static Item register(Block p_221542_0_, ItemGroup p_221542_1_) {
		return register(new BlockItem(p_221542_0_, (new Item.Properties()).group(p_221542_1_)));
	}

	private static Item register(BlockItem p_221543_0_) {
		return register(p_221543_0_.getBlock(), p_221543_0_);
	}

	@SuppressWarnings("deprecation")
	protected static Item register(Block p_221546_0_, Item p_221546_1_) {
		return register(Registry.BLOCK.getKey(p_221546_0_), p_221546_1_);
	}

	private static Item register(String key, Item p_221547_1_) {
		return register(new ResourceLocation(key), p_221547_1_);
	}

	@SuppressWarnings("deprecation")
	private static Item register(ResourceLocation key, Item p_221544_1_) {
		if (p_221544_1_ instanceof BlockItem) {
			((BlockItem)p_221544_1_).addToBlockToItemMap(Item.BLOCK_TO_ITEM, p_221544_1_);
		}

		return Registry.register(Registry.ITEM, key, p_221544_1_);
	}

}
