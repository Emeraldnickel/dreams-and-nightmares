
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dreamsandnightmares.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.dreamsandnightmares.fluid.DrowningDreamFluid;
import net.mcreator.dreamsandnightmares.fluid.DreamyWaterFluid;
import net.mcreator.dreamsandnightmares.DreamsAndNightmaresMod;

public class DreamsAndNightmaresModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, DreamsAndNightmaresMod.MODID);
	public static final RegistryObject<Fluid> DREAMY_WATER = REGISTRY.register("dreamy_water", () -> new DreamyWaterFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_DREAMY_WATER = REGISTRY.register("flowing_dreamy_water", () -> new DreamyWaterFluid.Flowing());
	public static final RegistryObject<Fluid> DROWNING_DREAM = REGISTRY.register("drowning_dream", () -> new DrowningDreamFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_DROWNING_DREAM = REGISTRY.register("flowing_drowning_dream",
			() -> new DrowningDreamFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(DREAMY_WATER.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_DREAMY_WATER.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(DROWNING_DREAM.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_DROWNING_DREAM.get(), renderType -> renderType == RenderType.translucent());
		}
	}
}
