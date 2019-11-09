package com.brb.wiredblocks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.brb.wiredblocks.init.ModBlocks;
import com.brb.wiredblocks.init.ModItems;
import com.brb.wiredblocks.models.Blocks.InvalidFaceException;
import com.brb.wiredblocks.models.Blocks.UnregisteredBlockException;
import com.brb.wiredblocks.models.Blocks.WiredBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;



// The value here should match an entry in the META-INF/mods.toml file
@Mod("wiredblocks")
public class ModMain
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public ModMain() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
        	blockRegistryEvent.getRegistry().register(ModBlocks.WIRED_OAK_LOG);				 //1
        	blockRegistryEvent.getRegistry().register(ModBlocks.WIRED_SPRUCE_LOG);			 //2
        	blockRegistryEvent.getRegistry().register(ModBlocks.WIRED_BIRCH_LOG);		 	 //3
        	blockRegistryEvent.getRegistry().register(ModBlocks.WIRED_JUNGLE_LOG);			 //4
        	blockRegistryEvent.getRegistry().register(ModBlocks.WIRED_ACACIA_LOG);			 //5
        	blockRegistryEvent.getRegistry().register(ModBlocks.WIRED_DARK_OAK_LOG);		 //6

        	blockRegistryEvent.getRegistry().register(ModBlocks.WIRED_STRIPPED_OAK_LOG);	 //7
        	blockRegistryEvent.getRegistry().register(ModBlocks.WIRED_STRIPPED_SPRUCE_LOG);	 //8
        	blockRegistryEvent.getRegistry().register(ModBlocks.WIRED_STRIPPED_BIRCH_LOG);	 //9
        	blockRegistryEvent.getRegistry().register(ModBlocks.WIRED_STRIPPED_JUNGLE_LOG);	 //10
        	blockRegistryEvent.getRegistry().register(ModBlocks.WIRED_STRIPPED_ACACIA_LOG);	 //11
        	blockRegistryEvent.getRegistry().register(ModBlocks.WIRED_STRIPPED_DARK_OAK_LOG);//12

        	blockRegistryEvent.getRegistry().register(ModBlocks.WIRED_STONE);
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {

        	itemRegistryEvent.getRegistry().register(ModItems.WIRED_OAK_LOG);				//1
        	itemRegistryEvent.getRegistry().register(ModItems.WIRED_SPRUCE_LOG);			//2
        	itemRegistryEvent.getRegistry().register(ModItems.WIRED_BIRCH_LOG);				//3
        	itemRegistryEvent.getRegistry().register(ModItems.WIRED_JUNGLE_LOG);			//4
        	itemRegistryEvent.getRegistry().register(ModItems.WIRED_ACACIA_LOG);			//5
        	itemRegistryEvent.getRegistry().register(ModItems.WIRED_DARK_OAK_LOG);			//6

        	itemRegistryEvent.getRegistry().register(ModItems.WIRED_STRIPPED_OAK_LOG);		//7
        	itemRegistryEvent.getRegistry().register(ModItems.WIRED_STRIPPED_SPRUCE_LOG);	//8
        	itemRegistryEvent.getRegistry().register(ModItems.WIRED_STRIPPED_BIRCH_LOG);	//9
        	itemRegistryEvent.getRegistry().register(ModItems.WIRED_STRIPPED_JUNGLE_LOG);	//10
        	itemRegistryEvent.getRegistry().register(ModItems.WIRED_STRIPPED_ACACIA_LOG);	//11
        	itemRegistryEvent.getRegistry().register(ModItems.WIRED_STRIPPED_DARK_OAK_LOG);	//12

        	itemRegistryEvent.getRegistry().register(ModItems.WIRED_STONE);
        }
    }

    @Mod.EventBusSubscriber(modid = "wiredblocks")
    public static class Eventlistener﻿ {

    	@SubscribeEvent
        public static void onRightClicked(PlayerInteractEvent.RightClickBlock event) {
    		ItemStack hand = event.getItemStack();
    		Item handItem = hand.getItem();
    		World world = event.getWorld();
    		BlockState block_state =  world.getBlockState(event.getPos());
            Block block = block_state.getBlock();
            if(handItem.getRegistryName().equals(net.minecraft.item.Items.REPEATER.getRegistryName())
            		&& block instanceof WiredBlock)
            {
            	WiredBlock wiredblock = (WiredBlock) block;
            	Direction face = event.getFace();
            	try {
					BlockState repeaterState = wiredblock.getRepeater(block_state, face);
					event.setCanceled(true);
	            	world.setBlockState(event.getPos(), repeaterState);
	            	if(!event.getPlayer().isCreative())
	            		hand.setCount(hand.getCount()-1);
	            	event.setCancellationResult(ActionResultType.SUCCESS);
				} catch (InvalidFaceException e) {
					LOGGER.info("not valid face.");
				} catch (UnregisteredBlockException e) {
					LOGGER.error(e.getMessage());
					event.setCanceled(true);
					event.setCancellationResult(ActionResultType.SUCCESS);
				}

            }

        }
    }
}
