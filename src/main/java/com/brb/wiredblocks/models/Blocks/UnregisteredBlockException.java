package com.brb.wiredblocks.models.Blocks;

import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;

public class UnregisteredBlockException extends Exception{

	public UnregisteredBlockException(BlockState key) {
		super(String.format("Repeater to WiredBlock \"%s\" doesn't exist.", getName(key)));
	}

	private static String getName(BlockState key) {
		ResourceLocation rl = key.getBlock().getRegistryName();
		String namespace = rl.getNamespace();
		return rl.toString().substring(namespace.length()+1);
	}
}
