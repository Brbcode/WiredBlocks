package com.brb.wiredblocks.init;

import com.brb.wiredblocks.ModMain;
import com.brb.wiredblocks.models.Blocks.WiredBlock;
import com.brb.wiredblocks.models.Blocks.WiredRepeaterBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;
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

	public static final WiredBlock WIRED_OAK_PLANKS = registerUnrotableWiredBlock("oak_planks", ModInitData.OAK_PLANKS);
	public static final WiredBlock WIRED_SPRUCE_PLANKS = registerUnrotableWiredBlock("spruce_planks", ModInitData.SPRUCE_PLANKS);
	public static final WiredBlock WIRED_BIRCH_PLANKS = registerUnrotableWiredBlock("birch_planks", ModInitData.BIRCH_PLANKS);
	public static final WiredBlock WIRED_JUNGLE_PLANKS = registerUnrotableWiredBlock("jungle_planks", ModInitData.JUNGLE_PLANKS);
	public static final WiredBlock WIRED_ACACIA_PLANKS = registerUnrotableWiredBlock("acacia_planks", ModInitData.ACACIA_PLANKS);
	public static final WiredBlock WIRED_DARK_OAK_PLANKS = registerUnrotableWiredBlock("dark_oak_planks", ModInitData.DARK_OAK_PLANKS);

	public static final WiredBlock WIRED_STONE = registerUnrotableWiredBlock("stone", ModInitData.STONE);
	public static final WiredBlock WIRED_SMOOTH_STONE = registerUnrotableWiredBlock("smooth_stone", ModInitData.SMOOTH_STONE);
	public static final WiredBlock WIRED_COBBLESTONE = registerUnrotableWiredBlock("cobblestone", ModInitData.COBBLESTONE);
	public static final WiredBlock WIRED_MOSSY_COBBLESTONE = registerUnrotableWiredBlock("mossy_cobblestone", ModInitData.MOSSY_COBBLESTONE);
	public static final WiredBlock WIRED_STONE_BRICKS = registerUnrotableWiredBlock("stone_bricks", ModInitData.STONE_BRICKS);
	public static final WiredBlock WIRED_MOSSY_STONE_BRICKS = registerUnrotableWiredBlock("mossy_stone_bricks", ModInitData.MOSSY_STONE_BRICKS);
	public static final WiredBlock WIRED_CHISELED_STONE_BRICKS = registerUnrotableWiredBlock("chiseled_stone_bricks", ModInitData.CHISELED_STONE_BRICKS);

	public static final WiredBlock WIRED_BRICKS = registerUnrotableWiredBlock("bricks", ModInitData.BRICKS);
	public static final WiredBlock WIRED_IRON_BLOCK = registerUnrotableWiredBlock("iron_block", ModInitData.IRON_BLOCK);
	public static final WiredBlock WIRED_DIAMOND_BLOCK = registerUnrotableWiredBlock("diamond_block", ModInitData.DIAMOND_BLOCK);
	public static final WiredBlock WIRED_GOLD_BLOCK = registerUnrotableWiredBlock("gold_block", ModInitData.GOLD_BLOCK);
	public static final WiredBlock WIRED_BOOKSHELF = registerUnrotableWiredBlock("bookshelf", ModInitData.BOOKSHELF);

	public static void registerAll(RegistryEvent.Register<Block> event) {
        // Workaround for Forge event bus bug
        if (!event.getName().equals(ForgeRegistries.BLOCKS.getRegistryName())) return;
    }

 	private static Block register(String name, Block block) {
 		ResourceLocation id = ModMain.getId(name);
 		block.setRegistryName(id);
 		ForgeRegistries.BLOCKS.register(block);
 		return block;
	}

	private static WiredBlock registerRotableWiredBlock(String key,ModInitData.Data data) {
		String wiredBlock_key = "wired_"+key;
		WiredRepeaterBlock repeater = registerRepeater(key,1,false,Direction.UP,data,null);;
		ModInitData.Data otherData = data;

		WiredBlock wiredBlock = registerWiredBlock2(key,data);
		wiredBlock.setRepeater(repeater);
		return wiredBlock;
	}

	private static WiredBlock registerUnrotableWiredBlock(String key,ModInitData.Data data) {
		String wiredBlock_key = "wired_"+key;
		WiredRepeaterBlock repeater = registerRepeater(key,1,false,Direction.UP,data,null);;
		ModInitData.Data otherData = data;

		WiredBlock wiredBlock = registerWiredBlock2(key,data);
		Block.Properties loot_properties = data.getPropertiesClone().lootFrom(wiredBlock);
		wiredBlock.setRepeater(repeater);
		return wiredBlock;
	}

	private static WiredBlock registerWiredBlock2(String key,ModInitData.Data data) {
		return registerWiredBlock2(key,data.materialColor,data.properties);
	}

	private static WiredBlock registerWiredBlock2(String key,MaterialColor color,Block.Properties properties) {
		key = "wired_"+key;
		if(color!=null)
			return (WiredBlock) register(key,new WiredBlock(color,properties));
		else
			return (WiredBlock) register(key,new WiredBlock(properties));
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

}
