
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dreamsandnightmares.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.dreamsandnightmares.block.SlumberDimensionPortalBlock;
import net.mcreator.dreamsandnightmares.block.ResilienceBlock;
import net.mcreator.dreamsandnightmares.block.NightmareGemOreBlock;
import net.mcreator.dreamsandnightmares.block.NightmareGemBlockBlock;
import net.mcreator.dreamsandnightmares.block.NightmareDimensionPortalBlock;
import net.mcreator.dreamsandnightmares.block.FearBlock;
import net.mcreator.dreamsandnightmares.block.DrowningDreamBlock;
import net.mcreator.dreamsandnightmares.block.DreamyWaterBlock;
import net.mcreator.dreamsandnightmares.block.DreamyGrassBlock;
import net.mcreator.dreamsandnightmares.block.DreamyDirtBlock;
import net.mcreator.dreamsandnightmares.block.DreamstoneBlock;
import net.mcreator.dreamsandnightmares.block.DreamblossomBlock;
import net.mcreator.dreamsandnightmares.block.DreamWoodBlock;
import net.mcreator.dreamsandnightmares.block.DreamStairsBlock;
import net.mcreator.dreamsandnightmares.block.DreamSlabBlock;
import net.mcreator.dreamsandnightmares.block.DreamPressurePlateBlock;
import net.mcreator.dreamsandnightmares.block.DreamPlanksBlock;
import net.mcreator.dreamsandnightmares.block.DreamLogBlock;
import net.mcreator.dreamsandnightmares.block.DreamLeavesBlock;
import net.mcreator.dreamsandnightmares.block.DreamFenceGateBlock;
import net.mcreator.dreamsandnightmares.block.DreamFenceBlock;
import net.mcreator.dreamsandnightmares.block.DreamDoorwayFrameBlock;
import net.mcreator.dreamsandnightmares.block.DreamCrystalOreBlock;
import net.mcreator.dreamsandnightmares.block.DreamCrystalBlockBlock;
import net.mcreator.dreamsandnightmares.block.DreamCobbleBlock;
import net.mcreator.dreamsandnightmares.block.DreamButtonBlock;
import net.mcreator.dreamsandnightmares.DreamsAndNightmaresMod;

public class DreamsAndNightmaresModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, DreamsAndNightmaresMod.MODID);
	public static final RegistryObject<Block> DREAM_WOOD = REGISTRY.register("dream_wood", () -> new DreamWoodBlock());
	public static final RegistryObject<Block> DREAMSTONE = REGISTRY.register("dreamstone", () -> new DreamstoneBlock());
	public static final RegistryObject<Block> DREAM_LOG = REGISTRY.register("dream_log", () -> new DreamLogBlock());
	public static final RegistryObject<Block> DREAM_PLANKS = REGISTRY.register("dream_planks", () -> new DreamPlanksBlock());
	public static final RegistryObject<Block> DREAM_LEAVES = REGISTRY.register("dream_leaves", () -> new DreamLeavesBlock());
	public static final RegistryObject<Block> DREAM_STAIRS = REGISTRY.register("dream_stairs", () -> new DreamStairsBlock());
	public static final RegistryObject<Block> DREAM_SLAB = REGISTRY.register("dream_slab", () -> new DreamSlabBlock());
	public static final RegistryObject<Block> DREAM_FENCE = REGISTRY.register("dream_fence", () -> new DreamFenceBlock());
	public static final RegistryObject<Block> DREAM_FENCE_GATE = REGISTRY.register("dream_fence_gate", () -> new DreamFenceGateBlock());
	public static final RegistryObject<Block> DREAM_PRESSURE_PLATE = REGISTRY.register("dream_pressure_plate", () -> new DreamPressurePlateBlock());
	public static final RegistryObject<Block> DREAM_BUTTON = REGISTRY.register("dream_button", () -> new DreamButtonBlock());
	public static final RegistryObject<Block> DREAM_COBBLE = REGISTRY.register("dream_cobble", () -> new DreamCobbleBlock());
	public static final RegistryObject<Block> DREAMY_DIRT = REGISTRY.register("dreamy_dirt", () -> new DreamyDirtBlock());
	public static final RegistryObject<Block> DREAMY_GRASS = REGISTRY.register("dreamy_grass", () -> new DreamyGrassBlock());
	public static final RegistryObject<Block> FEAR = REGISTRY.register("fear", () -> new FearBlock());
	public static final RegistryObject<Block> DREAMY_WATER = REGISTRY.register("dreamy_water", () -> new DreamyWaterBlock());
	public static final RegistryObject<Block> DROWNING_DREAM = REGISTRY.register("drowning_dream", () -> new DrowningDreamBlock());
	public static final RegistryObject<Block> SLUMBER_DIMENSION_PORTAL = REGISTRY.register("slumber_dimension_portal",
			() -> new SlumberDimensionPortalBlock());
	public static final RegistryObject<Block> NIGHTMARE_DIMENSION_PORTAL = REGISTRY.register("nightmare_dimension_portal",
			() -> new NightmareDimensionPortalBlock());
	public static final RegistryObject<Block> DREAM_CRYSTAL_ORE = REGISTRY.register("dream_crystal_ore", () -> new DreamCrystalOreBlock());
	public static final RegistryObject<Block> DREAM_CRYSTAL_BLOCK = REGISTRY.register("dream_crystal_block", () -> new DreamCrystalBlockBlock());
	public static final RegistryObject<Block> NIGHTMARE_GEM_ORE = REGISTRY.register("nightmare_gem_ore", () -> new NightmareGemOreBlock());
	public static final RegistryObject<Block> NIGHTMARE_GEM_BLOCK = REGISTRY.register("nightmare_gem_block", () -> new NightmareGemBlockBlock());
	public static final RegistryObject<Block> DREAM_DOORWAY_FRAME = REGISTRY.register("dream_doorway_frame", () -> new DreamDoorwayFrameBlock());
	public static final RegistryObject<Block> DREAMBLOSSOM = REGISTRY.register("dreamblossom", () -> new DreamblossomBlock());
	public static final RegistryObject<Block> RESILIENCE = REGISTRY.register("resilience", () -> new ResilienceBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			DreamLeavesBlock.registerRenderLayer();
			DreamblossomBlock.registerRenderLayer();
			ResilienceBlock.registerRenderLayer();
		}
	}
}
