
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.hollowedhell.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.core.Registry;

import net.mcreator.hollowedhell.world.features.plants.HoleflowerFeature;
import net.mcreator.hollowedhell.world.features.ores.VoidbowlPlantFeature;
import net.mcreator.hollowedhell.world.features.ores.VoidbowlBlockFeature;
import net.mcreator.hollowedhell.world.features.ores.HollowBlockFeature;
import net.mcreator.hollowedhell.world.features.VoidbowlStructureFeature;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HollowedhellModFeatures {
	private static final Map<Feature<?>, FeatureRegistration> REGISTRY = new HashMap<>();
	static {
		REGISTRY.put(HollowBlockFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES,
				HollowBlockFeature.GENERATE_BIOMES, HollowBlockFeature.CONFIGURED_FEATURE));
		REGISTRY.put(VoidbowlPlantFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES,
				VoidbowlPlantFeature.GENERATE_BIOMES, VoidbowlPlantFeature.CONFIGURED_FEATURE));
		REGISTRY.put(VoidbowlBlockFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES,
				VoidbowlBlockFeature.GENERATE_BIOMES, VoidbowlBlockFeature.CONFIGURED_FEATURE));
		REGISTRY.put(VoidbowlStructureFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES,
				VoidbowlStructureFeature.GENERATE_BIOMES, VoidbowlStructureFeature.CONFIGURED_FEATURE));
		REGISTRY.put(HoleflowerFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.VEGETAL_DECORATION,
				HoleflowerFeature.GENERATE_BIOMES, HoleflowerFeature.CONFIGURED_FEATURE));
	}

	@SubscribeEvent
	public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
		event.getRegistry().registerAll(REGISTRY.keySet().toArray(new Feature[0]));
		REGISTRY.forEach((feature, registration) -> Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, feature.getRegistryName(),
				registration.configuredFeature()));
	}

	@Mod.EventBusSubscriber
	private static class BiomeFeatureLoader {
		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			for (FeatureRegistration registration : REGISTRY.values()) {
				if (registration.biomes() == null || registration.biomes().contains(event.getName())) {
					event.getGeneration().getFeatures(registration.stage()).add(() -> registration.configuredFeature());
				}
			}
		}
	}

	private static record FeatureRegistration(GenerationStep.Decoration stage, Set<ResourceLocation> biomes,
			ConfiguredFeature<?, ?> configuredFeature) {
	}
}
