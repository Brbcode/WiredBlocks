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
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;



// The value here should match an entry in the META-INF/mods.toml file
@Mod(ModMain.MOD_ID)
public class ModMain
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "wiredblocks";
    public static final String MOD_NAME = "Wired Blocks";

    public ModMain() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModBlocks::registerAll);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModItems::registerAll);

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

    @Mod.EventBusSubscriber(modid = "wiredblocks")
    public static class Eventlistener{

    	@SubscribeEvent(priority = EventPriority.LOW)
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

    public static ResourceLocation getId(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

}
