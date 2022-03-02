
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.hollowedhell.init;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.hollowedhell.world.biome.VoidbowlWastesBiome;
import net.mcreator.hollowedhell.world.biome.HollowValleyBiome;
import net.mcreator.hollowedhell.HollowedhellMod;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HollowedhellModBiomes {
	private static final List<Biome> REGISTRY = new ArrayList<>();
	public static Biome HOLLOW_VALLEY = register("hollow_valley", HollowValleyBiome.createBiome());
	public static Biome VOIDBOWL_WASTES = register("voidbowl_wastes", VoidbowlWastesBiome.createBiome());

	private static Biome register(String registryname, Biome biome) {
		REGISTRY.add(biome.setRegistryName(new ResourceLocation(HollowedhellMod.MODID, registryname)));
		return biome;
	}

	@SubscribeEvent
	public static void registerBiomes(RegistryEvent.Register<Biome> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Biome[0]));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			HollowValleyBiome.init();
			VoidbowlWastesBiome.init();
		});
	}
}
