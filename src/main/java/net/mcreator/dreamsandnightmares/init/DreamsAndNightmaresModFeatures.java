
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dreamsandnightmares.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Holder;

import net.mcreator.dreamsandnightmares.world.features.plants.DreamblossomFeature;
import net.mcreator.dreamsandnightmares.world.features.ores.NightmareGemOreFeature;
import net.mcreator.dreamsandnightmares.world.features.ores.DreamCrystalOreFeature;
import net.mcreator.dreamsandnightmares.DreamsAndNightmaresMod;

import java.util.function.Supplier;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class DreamsAndNightmaresModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, DreamsAndNightmaresMod.MODID);
	private static final List<FeatureRegistration> FEATURE_REGISTRATIONS = new ArrayList<>();
	public static final RegistryObject<Feature<?>> DREAM_CRYSTAL_ORE = register("dream_crystal_ore", DreamCrystalOreFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, DreamCrystalOreFeature.GENERATE_BIOMES,
					DreamCrystalOreFeature::placedFeature));
	public static final RegistryObject<Feature<?>> NIGHTMARE_GEM_ORE = register("nightmare_gem_ore", NightmareGemOreFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, NightmareGemOreFeature.GENERATE_BIOMES,
					NightmareGemOreFeature::placedFeature));
	public static final RegistryObject<Feature<?>> DREAMBLOSSOM = register("dreamblossom", DreamblossomFeature::feature, new FeatureRegistration(
			GenerationStep.Decoration.VEGETAL_DECORATION, DreamblossomFeature.GENERATE_BIOMES, DreamblossomFeature::placedFeature));

	private static RegistryObject<Feature<?>> register(String registryname, Supplier<Feature<?>> feature, FeatureRegistration featureRegistration) {
		FEATURE_REGISTRATIONS.add(featureRegistration);
		return REGISTRY.register(registryname, feature);
	}

	@SubscribeEvent
	public static void addFeaturesToBiomes(BiomeLoadingEvent event) {
		for (FeatureRegistration registration : FEATURE_REGISTRATIONS) {
			if (registration.biomes() == null || registration.biomes().contains(event.getName()))
				event.getGeneration().getFeatures(registration.stage()).add(registration.placedFeature().get());
		}
	}

	private static record FeatureRegistration(GenerationStep.Decoration stage, Set<ResourceLocation> biomes,
			Supplier<Holder<PlacedFeature>> placedFeature) {
	}
}
