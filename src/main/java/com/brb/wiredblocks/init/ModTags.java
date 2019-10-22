package com.brb.wiredblocks.init;



import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

@SuppressWarnings("unused")
public class ModTags {
    public static final class Blocks {
        // This will be "forge:ores/example"
        //public static final Tag<Block> EXAMPLE = tag("forge", "ores/example");
        // Default namespace is mod ID, so this one will be "tensionwires:example_block"
        public static final Tag<Block> WIRED_OAK_LOG = tag("wired_oak_log");
        public static final Tag<Block> WIRED_SPRUCE_LOG = tag("wired_spruce_log");
        public static final Tag<Block> WIRED_BIRCH_LOG = tag("wired_birch_log");
        public static final Tag<Block> WIRED_JUNGLE_LOG = tag("wired_jungle_log");
        public static final Tag<Block> WIRED_ACACIA_LOG = tag("wired_acacia_log");
        public static final Tag<Block> WIRED_DARK_OAK_LOG = tag("wired_dark_oak_log");

        public static final Tag<Block> WIRED_STRIPPED_OAK_LOG = tag("wired_stripped_oak_log");
        public static final Tag<Block> WIRED_STRIPPED_SPRUCE_LOG = tag("wired_stripped_spruce_log");
        public static final Tag<Block> WIRED_STRIPPED_BIRCH_LOG = tag("wired_stripped_birch_log");
        public static final Tag<Block> WIRED_STRIPPED_JUNGLE_LOG = tag("wired_stripped_jungle_log");
        public static final Tag<Block> WIRED_STRIPPED_ACACIA_LOG = tag("wired_stripped_acacia_log");
        public static final Tag<Block> WIRED_STRIPPED_DARK_OAK_LOG = tag("wired_stripped_dark_oak_log");

        public static final Tag<Block> WIRED_OAK_PLANKS = tag("wired_oak_planks");
        public static final Tag<Block> WIRED_SPRUCE_PLANKS = tag("wired_spruce_planks");
        public static final Tag<Block> WIRED_BIRCH_PLANKS = tag("wired_birch_planks");
        public static final Tag<Block> WIRED_JUNGLE_PLANKS = tag("wired_jungle_planks");
        public static final Tag<Block> WIRED_ACACIA_PLANKS = tag("wired_acacia_planks");
        public static final Tag<Block> WIRED_DARK_OAK_PLANKS = tag("wired_dark_oak_planks");

        public static final Tag<Block> WIRED_STONE = tag("wired_stone");
        public static final Tag<Block> WIRED_SMOOTH_STONE = tag("wired_smooth_stone");
        public static final Tag<Block> WIRED_COBBLESTONE = tag("wired_cobblestone");
        public static final Tag<Block> WIRED_MOSSY_COBBLESTONE = tag("wired_mossy_cobblestone");
        public static final Tag<Block> WIRED_STONE_BRICKS = tag("wired_stone_bricks");
        public static final Tag<Block> WIRED_MOSSY_STONE_BRICKS = tag("wired_mossy_stone_bricks");
        public static final Tag<Block> WIRED_CHISELED_STONE_BRICKS = tag("wired_chiseled_stone_bricks");

        public static final Tag<Block> WIRED_BRICKS = tag("wired_bricks");
        public static final Tag<Block> WIRED_IRON_BLOCK = tag("wired_iron_block");
        public static final Tag<Block> WIRED_DIAMOND_BLOCK = tag("wired_diamond_block");
        public static final Tag<Block> WIRED_GOLD_BLOCK = tag("wired_gold_block");
        public static final Tag<Block> WIRED_BOOKSHELF = tag("wired_bookshelf");



        private Blocks() {}

        private static Tag<Block> tag(String name) {
            return new BlockTags.Wrapper(new ResourceLocation("wiredblocks:"+name));
        }

        private static Tag<Block> tag(String namespace, String name) {
            return new BlockTags.Wrapper(new ResourceLocation(namespace, name));
        }
    }


    public static final class Items {
        // Item tags work the same way as block tags, so this is "tensionwires:example_item"
        //public static final Tag<Item> EXAMPLE = tag("example_item");

        private Items() {}

		private static Tag<Item> tag(String name) {
            return new ItemTags.Wrapper(new ResourceLocation("wiredblocks:"+name));
        }

		private static Tag<Item> tag(String namespace, String name) {
            return new ItemTags.Wrapper(new ResourceLocation(namespace, name));
        }
    }
}
