package com.brb.wiredblocks.init;

import com.brb.wiredblocks.models.Blocks.WiredBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.ObjectHolder;

@SuppressWarnings("unused")
@ObjectHolder("wiredblocks")
public class ModBlocks {
	 public static final Block WIRED_OAK_LOG = register("wired_oak_log", new WiredBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
	 public static final Block WIRED_SPRUCE_LOG = register("wired_spruce_log", new WiredBlock(MaterialColor.OBSIDIAN, Block.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
	 public static final Block WIRED_BIRCH_LOG = register("wired_birch_log", new WiredBlock(MaterialColor.SAND, Block.Properties.create(Material.WOOD, MaterialColor.QUARTZ).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
	 public static final Block WIRED_JUNGLE_LOG = register("wired_jungle_log", new WiredBlock(MaterialColor.DIRT, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
	 public static final Block WIRED_ACACIA_LOG = register("wired_acacia_log", new WiredBlock(MaterialColor.ADOBE, Block.Properties.create(Material.WOOD, MaterialColor.STONE).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
	 public static final Block WIRED_DARK_OAK_LOG = register("wired_dark_oak_log", new WiredBlock(MaterialColor.BROWN, Block.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

	 public static final Block WIRED_STRIPPED_OAK_LOG = register("wired_stripped_oak_log", new WiredBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
	 public static final Block WIRED_STRIPPED_SPRUCE_LOG = register("wired_stripped_spruce_log", new WiredBlock(MaterialColor.OBSIDIAN, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
 	 public static final Block WIRED_STRIPPED_BIRCH_LOG = register("wired_stripped_birch_log", new WiredBlock(MaterialColor.SAND, Block.Properties.create(Material.WOOD, MaterialColor.SAND).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
	 public static final Block WIRED_STRIPPED_JUNGLE_LOG = register("wired_stripped_jungle_log", new WiredBlock(MaterialColor.DIRT, Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
	 public static final Block WIRED_STRIPPED_ACACIA_LOG = register("wired_stripped_acacia_log", new WiredBlock(MaterialColor.ADOBE, Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
	 public static final Block WIRED_STRIPPED_DARK_OAK_LOG = register("wired_stripped_dark_oak_log", new WiredBlock(MaterialColor.BROWN, Block.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

	 public static final Block WIRED_OAK_PLANKS = register("wired_oak_planks", new WiredBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	 private static final Block WIRED_OAK_PLANKS_X = register("wired_oak_planks_x", new WiredBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).lootFrom(WIRED_OAK_PLANKS)));
	 private static final Block WIRED_OAK_PLANKS_Z = register("wired_oak_planks_z", new WiredBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).lootFrom(WIRED_OAK_PLANKS)));
	 public static final Block WIRED_SPRUCE_PLANKS = register("wired_spruce_planks", new WiredBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	 private static final Block WIRED_SPRUCE_PLANKS_X = register("wired_spruce_planks_x", new WiredBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).lootFrom(WIRED_SPRUCE_PLANKS)));
	 private static final Block WIRED_SPRUCE_PLANKS_Z = register("wired_spruce_planks_z", new WiredBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).lootFrom(WIRED_SPRUCE_PLANKS)));
	 public static final Block WIRED_BIRCH_PLANKS = register("wired_birch_planks", new WiredBlock(Block.Properties.create(Material.WOOD, MaterialColor.SAND).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	 private static final Block WIRED_BIRCH_PLANKS_X = register("wired_birch_planks_x", new WiredBlock(Block.Properties.create(Material.WOOD, MaterialColor.SAND).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).lootFrom(WIRED_BIRCH_PLANKS)));
	 private static final Block WIRED_BIRCH_PLANKS_Z = register("wired_birch_planks_z", new WiredBlock(Block.Properties.create(Material.WOOD, MaterialColor.SAND).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).lootFrom(WIRED_BIRCH_PLANKS)));
	 public static final Block WIRED_JUNGLE_PLANKS = register("wired_jungle_planks", new WiredBlock(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	 private static final Block WIRED_JUNGLE_PLANKS_X = register("wired_jungle_planks_x", new WiredBlock(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).lootFrom(WIRED_JUNGLE_PLANKS)));
	 private static final Block WIRED_JUNGLE_PLANKS_Z = register("wired_jungle_planks_z", new WiredBlock(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).lootFrom(WIRED_JUNGLE_PLANKS)));
	 public static final Block WIRED_ACACIA_PLANKS = register("wired_acacia_planks", new WiredBlock(Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	 private static final Block WIRED_ACACIA_PLANKS_X = register("wired_acacia_planks_x", new WiredBlock(Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).lootFrom(WIRED_ACACIA_PLANKS)));
	 private static final Block WIRED_ACACIA_PLANKS_Z = register("wired_acacia_planks_z", new WiredBlock(Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).lootFrom(WIRED_ACACIA_PLANKS)));
	 public static final Block WIRED_DARK_OAK_PLANKS = register("wired_dark_oak_planks", new WiredBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	 private static final Block WIRED_DARK_OAK_PLANKS_X = register("wired_dark_oak_planks_x", new WiredBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).lootFrom(WIRED_DARK_OAK_PLANKS)));
	 private static final Block WIRED_DARK_OAK_PLANKS_Z = register("wired_dark_oak_planks_z", new WiredBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).lootFrom(WIRED_DARK_OAK_PLANKS)));

	 public static final Block WIRED_STONE = register("wired_stone", new WiredBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F)));
	 private static final Block WIRED_STONE_X = register("wired_stone_x", new WiredBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).lootFrom(WIRED_STONE)));
	 private static final Block WIRED_STONE_Z = register("wired_stone_z", new WiredBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).lootFrom(WIRED_STONE)));
	 public static final Block WIRED_SMOOTH_STONE = register("wired_smooth_stone", new WiredBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F)));
	 private static final Block WIRED_SMOOTH_STONE_X = register("wired_smooth_stone_x", new WiredBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).lootFrom(WIRED_SMOOTH_STONE)));
	 private static final Block WIRED_SMOOTH_STONE_Y = register("wired_smooth_stone_z", new WiredBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).lootFrom(WIRED_SMOOTH_STONE)));
	 public static final Block WIRED_COBBLESTONE = register("wired_cobblestone", new WiredBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 6.0F)));
	 private static final Block WIRED_COBBLESTONE_X = register("wired_cobblestone_x", new WiredBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 6.0F).lootFrom(WIRED_COBBLESTONE)));
	 private static final Block WIRED_COBBLESTONE_Z = register("wired_cobblestone_z", new WiredBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 6.0F).lootFrom(WIRED_COBBLESTONE)));
	 public static final Block WIRED_MOSSY_COBBLESTONE = register("wired_mossy_cobblestone", new WiredBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 6.0F)));
	 private static final Block WIRED_MOSSY_COBBLESTONE_X = register("wired_mossy_cobblestone_x", new WiredBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 6.0F).lootFrom(WIRED_MOSSY_COBBLESTONE)));
	 private static final Block WIRED_MOSSY_COBBLESTONE_Z = register("wired_mossy_cobblestone_z", new WiredBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 6.0F).lootFrom(WIRED_MOSSY_COBBLESTONE)));
	 public static final Block WIRED_STONE_BRICKS = register("wired_stone_bricks", new WiredBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)));
	 private static final Block WIRED_STONE_BRICKS_X = register("wired_stone_bricks_x", new WiredBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).lootFrom(WIRED_STONE_BRICKS)));
	 private static final Block WIRED_STONE_BRICKS_Y = register("wired_stone_bricks_z", new WiredBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).lootFrom(WIRED_STONE_BRICKS)));
	 public static final Block WIRED_MOSSY_STONE_BRICKS = register("wired_mossy_stone_bricks", new WiredBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)));
	 private static final Block WIRED_MOSSY_STONE_BRICKS_X = register("wired_mossy_stone_bricks_x", new WiredBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).lootFrom(WIRED_MOSSY_STONE_BRICKS)));
	 private static final Block WIRED_MOSSY_STONE_BRICKS_Y = register("wired_mossy_stone_bricks_z", new WiredBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).lootFrom(WIRED_MOSSY_STONE_BRICKS)));
	 public static final Block WIRED_CHISELED_STONE_BRICKS = register("wired_chiseled_stone_bricks", new WiredBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)));
	 private static final Block WIRED_CHISELED_STONE_BRICKS_X = register("wired_chiseled_stone_bricks_x", new WiredBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).lootFrom(WIRED_CHISELED_STONE_BRICKS)));
	 private static final Block WIRED_CHISELED_STONE_BRICKS_Z = register("wired_chiseled_stone_bricks_z", new WiredBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).lootFrom(WIRED_CHISELED_STONE_BRICKS)));

	 public static final Block WIRED_BRICKS = register("wired_bricks", new WiredBlock(Block.Properties.create(Material.ROCK, MaterialColor.RED).hardnessAndResistance(2.0F, 6.0F)));
	 private static final Block WIRED_BRICKS_X = register("wired_bricks_x", new WiredBlock(Block.Properties.create(Material.ROCK, MaterialColor.RED).hardnessAndResistance(2.0F, 6.0F).lootFrom(WIRED_BRICKS)));
	 private static final Block WIRED_BRICKS_Y = register("wired_bricks_z", new WiredBlock(Block.Properties.create(Material.ROCK, MaterialColor.RED).hardnessAndResistance(2.0F, 6.0F).lootFrom(WIRED_BRICKS)));
	 public static final Block WIRED_IRON_BLOCK = register("wired_iron_block", new WiredBlock(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	 private static final Block WIRED_IRON_BLOCK_X = register("wired_iron_block_x", new WiredBlock(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL).lootFrom(WIRED_IRON_BLOCK)));
	 private static final Block WIRED_IRON_BLOCK_Y = register("wired_iron_block_z", new WiredBlock(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL).lootFrom(WIRED_IRON_BLOCK)));
	 public static final Block WIRED_DIAMOND_BLOCK = register("wired_diamond_block", new WiredBlock(Block.Properties.create(Material.IRON, MaterialColor.DIAMOND).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	 private static final Block WIRED_DIAMOND_BLOCK_X = register("wired_diamond_block_x", new WiredBlock(Block.Properties.create(Material.IRON, MaterialColor.DIAMOND).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
	 private static final Block WIRED_DIAMOND_BLOCK_Y = register("wired_diamond_block_z", new WiredBlock(Block.Properties.create(Material.IRON, MaterialColor.DIAMOND).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL).lootFrom(WIRED_DIAMOND_BLOCK)));
	 public static final Block WIRED_GOLD_BLOCK = register("wired_gold_block", new WiredBlock(Block.Properties.create(Material.IRON, MaterialColor.GOLD).hardnessAndResistance(3.0F, 6.0F).sound(SoundType.METAL)));
	 private static final Block WIRED_GOLD_BLOCK_X = register("wired_gold_block_x", new WiredBlock(Block.Properties.create(Material.IRON, MaterialColor.GOLD).hardnessAndResistance(3.0F, 6.0F).sound(SoundType.METAL).lootFrom(WIRED_GOLD_BLOCK)));
	 private static final Block WIRED_GOLD_BLOCK_Y = register("wired_gold_block_z", new WiredBlock(Block.Properties.create(Material.IRON, MaterialColor.GOLD).hardnessAndResistance(3.0F, 6.0F).sound(SoundType.METAL).lootFrom(WIRED_GOLD_BLOCK)));
	 public static final Block WIRED_BOOKSHELF = register("wired_bookshelf", new WiredBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.5F).sound(SoundType.WOOD)));
	 private static final Block WIRED_BOOKSHELF_X = register("wired_bookshelf_x", new WiredBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.5F).sound(SoundType.WOOD).lootFrom(WIRED_BOOKSHELF)));
	 private static final Block WIRED_BOOKSHELF_Y = register("wired_bookshelf_z", new WiredBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.5F).sound(SoundType.WOOD).lootFrom(WIRED_BOOKSHELF)));

	@SuppressWarnings("deprecation")
	private static Block register(String key, Block p_222382_1_) {
	      return Registry.register(Registry.BLOCK, "wiredblocks:"+key, p_222382_1_);
	   }
}
