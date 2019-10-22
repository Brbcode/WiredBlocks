package com.brb.wiredblocks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.brb.wiredblocks.init.ModBlocks;
import com.brb.wiredblocks.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
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
    private static final Logger LOGGER = LogManager.getLogger();

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
}
