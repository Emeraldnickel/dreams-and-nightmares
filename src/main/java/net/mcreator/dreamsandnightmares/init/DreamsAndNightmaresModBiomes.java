
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dreamsandnightmares.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.biome.Biome;

import net.mcreator.dreamsandnightmares.world.biome.NightmareRealmBiome;
import net.mcreator.dreamsandnightmares.world.biome.DreamlandBiome;
import net.mcreator.dreamsandnightmares.DreamsAndNightmaresMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DreamsAndNightmaresModBiomes {
	public static final DeferredRegister<Biome> REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, DreamsAndNightmaresMod.MODID);
	public static final RegistryObject<Biome> DREAMLAND = REGISTRY.register("dreamland", () -> DreamlandBiome.createBiome());
	public static final RegistryObject<Biome> NIGHTMARE_REALM = REGISTRY.register("nightmare_realm", () -> NightmareRealmBiome.createBiome());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			DreamlandBiome.init();
			NightmareRealmBiome.init();
		});
	}
}
