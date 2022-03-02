
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.hollowedhell.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.hollowedhell.block.VoidbowlPlantBlock;
import net.mcreator.hollowedhell.block.VoidbowlBlockBlock;
import net.mcreator.hollowedhell.block.VoidEssenceBlock;
import net.mcreator.hollowedhell.block.HollowedHellPortalBlock;
import net.mcreator.hollowedhell.block.HollowBlockBlock;
import net.mcreator.hollowedhell.block.HoleflowerBlock;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HollowedhellModBlocks {
	private static final List<Block> REGISTRY = new ArrayList<>();
	public static final Block HOLLOW_BLOCK = register(new HollowBlockBlock());
	public static final Block VOID_ESSENCE = register(new VoidEssenceBlock());
	public static final Block HOLLOWED_HELL_PORTAL = register(new HollowedHellPortalBlock());
	public static final Block VOIDBOWL_PLANT = register(new VoidbowlPlantBlock());
	public static final Block VOIDBOWL_BLOCK = register(new VoidbowlBlockBlock());
	public static final Block HOLEFLOWER = register(new HoleflowerBlock());

	private static Block register(Block block) {
		REGISTRY.add(block);
		return block;
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Block[0]));
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			VoidbowlPlantBlock.registerRenderLayer();
			HoleflowerBlock.registerRenderLayer();
		}
	}
}
