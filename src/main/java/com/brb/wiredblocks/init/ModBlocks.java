package com.brb.wiredblocks.init;

import java.util.HashMap;

import com.brb.wiredblocks.models.Blocks.WiredBlock;
import com.brb.wiredblocks.models.Blocks.WiredRepeaterBlock;

import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.ObjectHolder;

@SuppressWarnings("unused")
@ObjectHolder("wiredblocks")
public class ModBlocks {

	public static final WiredBlock WIRED_OAK_LOG = registerRotableWiredBlock("oak_log",ModInitData.OAK_LOG);
	public static final WiredBlock WIRED_SPRUCE_LOG = registerRotableWiredBlock("spruce_log", ModInitData.SPRUCE_LOG);
	public static final WiredBlock WIRED_BIRCH_LOG = registerRotableWiredBlock("birch_log", ModInitData.BIRCH_LOG);
	public static final WiredBlock WIRED_JUNGLE_LOG = registerRotableWiredBlock("jungle_log", ModInitData.JUNGLE_LOG);
	public static final WiredBlock WIRED_ACACIA_LOG = registerRotableWiredBlock("acacia_log", ModInitData.ACACIA_LOG);
	public static final WiredBlock WIRED_DARK_OAK_LOG = registerRotableWiredBlock("dark_oak_log", ModInitData.DARK_OAK_LOG);

	public static final WiredBlock WIRED_STRIPPED_OAK_LOG = registerRotableWiredBlock("stripped_oak_log", ModInitData.STRIPPED_OAK_LOG);
	public static final WiredBlock WIRED_STRIPPED_SPRUCE_LOG = registerRotableWiredBlock("stripped_spruce_log", ModInitData.STRIPPED_SPRUCE_LOG);
 	public static final WiredBlock WIRED_STRIPPED_BIRCH_LOG = registerRotableWiredBlock("stripped_birch_log", ModInitData.STRIPPED_BIRCH_LOG);
	public static final WiredBlock WIRED_STRIPPED_JUNGLE_LOG = registerRotableWiredBlock("stripped_jungle_log", ModInitData.STRIPPED_JUNGLE_LOG);
	public static final WiredBlock WIRED_STRIPPED_ACACIA_LOG = registerRotableWiredBlock("stripped_acacia_log", ModInitData.STRIPPED_ACACIA_LOG);
	public static final WiredBlock WIRED_STRIPPED_DARK_OAK_LOG = registerRotableWiredBlock("stripped_dark_oak_log", ModInitData.STRIPPED_DARK_OAK_LOG);

	public static final WiredBlock WIRED_OAK_PLANKS = registerWiredBlock("wired_oak_planks", ModInitData.OAK_PLANKS);
	 private static final WiredBlock WIRED_OAK_PLANKS_X = registerWiredBlock("wired_oak_planks_x", ModInitData.OAK_PLANKS);
	 private static final WiredBlock WIRED_OAK_PLANKS_Z = registerWiredBlock("wired_oak_planks_z", ModInitData.OAK_PLANKS);
	public static final WiredBlock WIRED_SPRUCE_PLANKS = registerWiredBlock("wired_spruce_planks", ModInitData.SPRUCE_PLANKS);
	 private static final WiredBlock WIRED_SPRUCE_PLANKS_X = registerWiredBlock("wired_spruce_planks_x", ModInitData.SPRUCE_PLANKS);
	 private static final WiredBlock WIRED_SPRUCE_PLANKS_Z = registerWiredBlock("wired_spruce_planks_z", ModInitData.SPRUCE_PLANKS);
	public static final WiredBlock WIRED_BIRCH_PLANKS = registerWiredBlock("wired_birch_planks", ModInitData.BIRCH_PLANKS);
	 private static final WiredBlock WIRED_BIRCH_PLANKS_X = registerWiredBlock("wired_birch_planks_x", ModInitData.BIRCH_PLANKS);
	 private static final WiredBlock WIRED_BIRCH_PLANKS_Z = registerWiredBlock("wired_birch_planks_z", ModInitData.BIRCH_PLANKS);
	public static final WiredBlock WIRED_JUNGLE_PLANKS = registerWiredBlock("wired_jungle_planks", ModInitData.JUNGLE_PLANKS);
	 private static final WiredBlock WIRED_JUNGLE_PLANKS_X = registerWiredBlock("wired_jungle_planks_x", ModInitData.JUNGLE_PLANKS);
	 private static final WiredBlock WIRED_JUNGLE_PLANKS_Z = registerWiredBlock("wired_jungle_planks_z", ModInitData.JUNGLE_PLANKS);
	public static final WiredBlock WIRED_ACACIA_PLANKS = registerWiredBlock("wired_acacia_planks", ModInitData.ACACIA_PLANKS);
	 private static final WiredBlock WIRED_ACACIA_PLANKS_X = registerWiredBlock("wired_acacia_planks_x", ModInitData.ACACIA_PLANKS);
	 private static final WiredBlock WIRED_ACACIA_PLANKS_Z = registerWiredBlock("wired_acacia_planks_z", ModInitData.ACACIA_PLANKS);
	public static final WiredBlock WIRED_DARK_OAK_PLANKS = registerWiredBlock("wired_dark_oak_planks", ModInitData.DARK_OAK_PLANKS);
	 private static final WiredBlock WIRED_DARK_OAK_PLANKS_X = registerWiredBlock("wired_dark_oak_planks_x", ModInitData.DARK_OAK_PLANKS);
	 private static final WiredBlock WIRED_DARK_OAK_PLANKS_Z = registerWiredBlock("wired_dark_oak_planks_z", ModInitData.DARK_OAK_PLANKS);

	public static final WiredBlock WIRED_STONE = registerWiredBlock("wired_stone", ModInitData.STONE);
	 private static final WiredBlock WIRED_STONE_X = registerWiredBlock("wired_stone_x", ModInitData.STONE);
	 private static final WiredBlock WIRED_STONE_Z = registerWiredBlock("wired_stone_z", ModInitData.STONE);
	public static final WiredBlock WIRED_SMOOTH_STONE = registerWiredBlock("wired_smooth_stone", ModInitData.SMOOTH_STONE);
	 private static final WiredBlock WIRED_SMOOTH_STONE_X = registerWiredBlock("wired_smooth_stone_x", ModInitData.SMOOTH_STONE);
	 private static final WiredBlock WIRED_SMOOTH_STONE_Y = registerWiredBlock("wired_smooth_stone_z", ModInitData.SMOOTH_STONE);
	public static final WiredBlock WIRED_COBBLESTONE = registerWiredBlock("wired_cobblestone", ModInitData.COBBLESTONE);
	 private static final WiredBlock WIRED_COBBLESTONE_X = registerWiredBlock("wired_cobblestone_x", ModInitData.COBBLESTONE);
	 private static final WiredBlock WIRED_COBBLESTONE_Z = registerWiredBlock("wired_cobblestone_z", ModInitData.COBBLESTONE);
	public static final WiredBlock WIRED_MOSSY_COBBLESTONE = registerWiredBlock("wired_mossy_cobblestone", ModInitData.MOSSY_COBBLESTONE);
	 private static final WiredBlock WIRED_MOSSY_COBBLESTONE_X = registerWiredBlock("wired_mossy_cobblestone_x", ModInitData.MOSSY_COBBLESTONE);
	 private static final WiredBlock WIRED_MOSSY_COBBLESTONE_Z = registerWiredBlock("wired_mossy_cobblestone_z", ModInitData.MOSSY_COBBLESTONE);
	public static final WiredBlock WIRED_STONE_BRICKS = registerWiredBlock("wired_stone_bricks", ModInitData.STONE_BRICKS);
	 private static final WiredBlock WIRED_STONE_BRICKS_X = registerWiredBlock("wired_stone_bricks_x", ModInitData.STONE_BRICKS);
	 private static final WiredBlock WIRED_STONE_BRICKS_Y = registerWiredBlock("wired_stone_bricks_z", ModInitData.STONE_BRICKS);
	public static final WiredBlock WIRED_MOSSY_STONE_BRICKS = registerWiredBlock("wired_mossy_stone_bricks", ModInitData.MOSSY_STONE_BRICKS);
	 private static final WiredBlock WIRED_MOSSY_STONE_BRICKS_X = registerWiredBlock("wired_mossy_stone_bricks_x", ModInitData.MOSSY_STONE_BRICKS);
	 private static final WiredBlock WIRED_MOSSY_STONE_BRICKS_Y = registerWiredBlock("wired_mossy_stone_bricks_z", ModInitData.MOSSY_STONE_BRICKS);
	public static final WiredBlock WIRED_CHISELED_STONE_BRICKS = registerWiredBlock("wired_chiseled_stone_bricks", ModInitData.CHISELED_STONE_BRICKS);
	 private static final WiredBlock WIRED_CHISELED_STONE_BRICKS_X = registerWiredBlock("wired_chiseled_stone_bricks_x", ModInitData.CHISELED_STONE_BRICKS);
	 private static final WiredBlock WIRED_CHISELED_STONE_BRICKS_Z = registerWiredBlock("wired_chiseled_stone_bricks_z", ModInitData.CHISELED_STONE_BRICKS);

	public static final WiredBlock WIRED_BRICKS = registerWiredBlock("wired_bricks", ModInitData.BRICKS);
	 private static final WiredBlock WIRED_BRICKS_X = registerWiredBlock("wired_bricks_x", ModInitData.BRICKS);
	 private static final WiredBlock WIRED_BRICKS_Y = registerWiredBlock("wired_bricks_z", ModInitData.BRICKS);
	public static final WiredBlock WIRED_IRON_BLOCK = registerWiredBlock("wired_iron_block", ModInitData.IRON_BLOCK);
	 private static final WiredBlock WIRED_IRON_BLOCK_X = registerWiredBlock("wired_iron_block_x", ModInitData.IRON_BLOCK);
	 private static final WiredBlock WIRED_IRON_BLOCK_Y = registerWiredBlock("wired_iron_block_z", ModInitData.IRON_BLOCK);
	public static final WiredBlock WIRED_DIAMOND_BLOCK = registerWiredBlock("wired_diamond_block", ModInitData.DIAMOND_BLOCK);
	 private static final WiredBlock WIRED_DIAMOND_BLOCK_X = registerWiredBlock("wired_diamond_block_x", ModInitData.DIAMOND_BLOCK);
	 private static final WiredBlock WIRED_DIAMOND_BLOCK_Y = registerWiredBlock("wired_diamond_block_z", ModInitData.DIAMOND_BLOCK);
	public static final WiredBlock WIRED_GOLD_BLOCK = registerWiredBlock("wired_gold_block", ModInitData.GOLD_BLOCK);
	 private static final WiredBlock WIRED_GOLD_BLOCK_X = registerWiredBlock("wired_gold_block_x", ModInitData.GOLD_BLOCK);
	 private static final WiredBlock WIRED_GOLD_BLOCK_Y = registerWiredBlock("wired_gold_block_z", ModInitData.GOLD_BLOCK);
	public static final WiredBlock WIRED_BOOKSHELF = registerWiredBlock("wired_bookshelf", ModInitData.BOOKSHELF);
	 private static final WiredBlock WIRED_BOOKSHELF_X = registerWiredBlock("wired_bookshelf_x", ModInitData.BOOKSHELF);
	 private static final WiredBlock WIRED_BOOKSHELF_Y = registerWiredBlock("wired_bookshelf_z", ModInitData.BOOKSHELF);


	private static HashMap<ResourceLocation,Block> repeaterMatch = new HashMap<>();

	@SuppressWarnings("deprecation")
	private static Block register(String key, Block p_222382_1_) {
		return Registry.register(Registry.BLOCK, "wiredblocks:"+key, p_222382_1_);
	}

	private static WiredBlock registerRotableWiredBlock(String key,ModInitData.Data data) {
		String wiredBlock_key = "wired_"+key;
		WiredRepeaterBlock repeater = registerRepeater(key,1,false,Direction.UP,data,null);;
		ModInitData.Data otherData = data;
		for(int tick = 1; tick <=4 ;tick++)
		{
			if(tick!=1)
				registerRepeater(key,tick,false,Direction.UP,data,repeater);
			registerRepeater(key,tick,true,Direction.UP,data,repeater);
			registerRepeater(key,tick,false,Direction.DOWN,data,repeater);
			registerRepeater(key,tick,true,Direction.DOWN,data,repeater);
		}

		WiredBlock wiredBlock = registerWiredBlock2(key,data);
		wiredBlock.setRepeater(repeater);
		return wiredBlock;
	}

	private static WiredBlock registerWiredBlock2(String key,ModInitData.Data data) {
		key = "wired_"+key;
		if(data.materialColor!=null)
			return (WiredBlock) register(key,new WiredBlock(data.materialColor,data.properties));
		else
			return (WiredBlock) register(key,new WiredBlock(data.properties));
	}

	private static WiredBlock registerWiredBlock(String key,ModInitData.Data data) {
		if(data.materialColor!=null)
			return (WiredBlock) register(key,new WiredBlock(data.materialColor,data.properties));
		else
			return (WiredBlock) register(key,new WiredBlock(data.properties));
	}

	private static WiredRepeaterBlock registerRepeater(String key,int tick,boolean lock,Direction face,ModInitData.Data data,Block loot) {
		if(tick == 1 && !lock && face==Direction.UP)
			key = "wired_repeater_"+key;
		else
			key = String.format("wired_repeater_tick%s_%s%s_%s", tick,((lock)?"locked_":""),face,key);
		Block.Properties properties = data.getPropertiesClone();
		if(loot!=null)
			properties = properties.lootFrom(loot);
		if(data.materialColor!=null)
			return (WiredRepeaterBlock) register(key,new WiredRepeaterBlock(data.materialColor,properties));
		else
			return (WiredRepeaterBlock) register(key,new WiredRepeaterBlock(properties));
	}

	public static Block GetRepeaterByRegistryName(ResourceLocation key) {
		if(repeaterMatch.containsKey(key))
			return repeaterMatch.get(key);
		return null;
	}
}
