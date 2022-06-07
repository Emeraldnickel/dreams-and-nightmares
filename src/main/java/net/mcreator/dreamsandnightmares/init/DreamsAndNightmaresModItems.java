
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dreamsandnightmares.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.dreamsandnightmares.item.SlumberDimensionItem;
import net.mcreator.dreamsandnightmares.item.NightmareGemSwordItem;
import net.mcreator.dreamsandnightmares.item.NightmareGemShovelItem;
import net.mcreator.dreamsandnightmares.item.NightmareGemPickaxeItem;
import net.mcreator.dreamsandnightmares.item.NightmareGemItem;
import net.mcreator.dreamsandnightmares.item.NightmareGemHoeItem;
import net.mcreator.dreamsandnightmares.item.NightmareGemAxeItem;
import net.mcreator.dreamsandnightmares.item.NightmareGemArmorItem;
import net.mcreator.dreamsandnightmares.item.NightmareDimensionItem;
import net.mcreator.dreamsandnightmares.item.NightcapItem;
import net.mcreator.dreamsandnightmares.item.InnerLightItem;
import net.mcreator.dreamsandnightmares.item.DrowningDreamItem;
import net.mcreator.dreamsandnightmares.item.DreamyWaterItem;
import net.mcreator.dreamsandnightmares.item.DreamCrystalSwordItem;
import net.mcreator.dreamsandnightmares.item.DreamCrystalShovelItem;
import net.mcreator.dreamsandnightmares.item.DreamCrystalPickaxeItem;
import net.mcreator.dreamsandnightmares.item.DreamCrystalItem;
import net.mcreator.dreamsandnightmares.item.DreamCrystalHoeItem;
import net.mcreator.dreamsandnightmares.item.DreamCrystalAxeItem;
import net.mcreator.dreamsandnightmares.item.DreamCrystalArmorItem;
import net.mcreator.dreamsandnightmares.DreamsAndNightmaresMod;

public class DreamsAndNightmaresModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DreamsAndNightmaresMod.MODID);
	public static final RegistryObject<Item> DREAM_WOOD = block(DreamsAndNightmaresModBlocks.DREAM_WOOD, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> DREAMSTONE = block(DreamsAndNightmaresModBlocks.DREAMSTONE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> DREAM_LOG = block(DreamsAndNightmaresModBlocks.DREAM_LOG, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> DREAM_PLANKS = block(DreamsAndNightmaresModBlocks.DREAM_PLANKS, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> DREAM_LEAVES = block(DreamsAndNightmaresModBlocks.DREAM_LEAVES, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> DREAM_STAIRS = block(DreamsAndNightmaresModBlocks.DREAM_STAIRS, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> DREAM_SLAB = block(DreamsAndNightmaresModBlocks.DREAM_SLAB, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> DREAM_FENCE = block(DreamsAndNightmaresModBlocks.DREAM_FENCE, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> DREAM_FENCE_GATE = block(DreamsAndNightmaresModBlocks.DREAM_FENCE_GATE, CreativeModeTab.TAB_REDSTONE);
	public static final RegistryObject<Item> DREAM_PRESSURE_PLATE = block(DreamsAndNightmaresModBlocks.DREAM_PRESSURE_PLATE,
			CreativeModeTab.TAB_REDSTONE);
	public static final RegistryObject<Item> DREAM_BUTTON = block(DreamsAndNightmaresModBlocks.DREAM_BUTTON, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> DREAM_COBBLE = block(DreamsAndNightmaresModBlocks.DREAM_COBBLE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> DREAMY_DIRT = block(DreamsAndNightmaresModBlocks.DREAMY_DIRT, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> DREAMY_GRASS = block(DreamsAndNightmaresModBlocks.DREAMY_GRASS, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> FEAR = block(DreamsAndNightmaresModBlocks.FEAR, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> DREAMY_WATER_BUCKET = REGISTRY.register("dreamy_water_bucket", () -> new DreamyWaterItem());
	public static final RegistryObject<Item> DROWNING_DREAM_BUCKET = REGISTRY.register("drowning_dream_bucket", () -> new DrowningDreamItem());
	public static final RegistryObject<Item> SLUMBER_DIMENSION = REGISTRY.register("slumber_dimension", () -> new SlumberDimensionItem());
	public static final RegistryObject<Item> NIGHTMARE_DIMENSION = REGISTRY.register("nightmare_dimension", () -> new NightmareDimensionItem());
	public static final RegistryObject<Item> DREAM_CRYSTAL = REGISTRY.register("dream_crystal", () -> new DreamCrystalItem());
	public static final RegistryObject<Item> DREAM_CRYSTAL_ORE = block(DreamsAndNightmaresModBlocks.DREAM_CRYSTAL_ORE,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> DREAM_CRYSTAL_BLOCK = block(DreamsAndNightmaresModBlocks.DREAM_CRYSTAL_BLOCK,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> DREAM_CRYSTAL_PICKAXE = REGISTRY.register("dream_crystal_pickaxe", () -> new DreamCrystalPickaxeItem());
	public static final RegistryObject<Item> DREAM_CRYSTAL_AXE = REGISTRY.register("dream_crystal_axe", () -> new DreamCrystalAxeItem());
	public static final RegistryObject<Item> DREAM_CRYSTAL_SWORD = REGISTRY.register("dream_crystal_sword", () -> new DreamCrystalSwordItem());
	public static final RegistryObject<Item> DREAM_CRYSTAL_SHOVEL = REGISTRY.register("dream_crystal_shovel", () -> new DreamCrystalShovelItem());
	public static final RegistryObject<Item> DREAM_CRYSTAL_HOE = REGISTRY.register("dream_crystal_hoe", () -> new DreamCrystalHoeItem());
	public static final RegistryObject<Item> DREAM_CRYSTAL_ARMOR_HELMET = REGISTRY.register("dream_crystal_armor_helmet",
			() -> new DreamCrystalArmorItem.Helmet());
	public static final RegistryObject<Item> DREAM_CRYSTAL_ARMOR_CHESTPLATE = REGISTRY.register("dream_crystal_armor_chestplate",
			() -> new DreamCrystalArmorItem.Chestplate());
	public static final RegistryObject<Item> DREAM_CRYSTAL_ARMOR_LEGGINGS = REGISTRY.register("dream_crystal_armor_leggings",
			() -> new DreamCrystalArmorItem.Leggings());
	public static final RegistryObject<Item> DREAM_CRYSTAL_ARMOR_BOOTS = REGISTRY.register("dream_crystal_armor_boots",
			() -> new DreamCrystalArmorItem.Boots());
	public static final RegistryObject<Item> NIGHTMARE_GEM = REGISTRY.register("nightmare_gem", () -> new NightmareGemItem());
	public static final RegistryObject<Item> NIGHTMARE_GEM_ORE = block(DreamsAndNightmaresModBlocks.NIGHTMARE_GEM_ORE,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> NIGHTMARE_GEM_BLOCK = block(DreamsAndNightmaresModBlocks.NIGHTMARE_GEM_BLOCK,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> NIGHTMARE_GEM_PICKAXE = REGISTRY.register("nightmare_gem_pickaxe", () -> new NightmareGemPickaxeItem());
	public static final RegistryObject<Item> NIGHTMARE_GEM_AXE = REGISTRY.register("nightmare_gem_axe", () -> new NightmareGemAxeItem());
	public static final RegistryObject<Item> NIGHTMARE_GEM_SWORD = REGISTRY.register("nightmare_gem_sword", () -> new NightmareGemSwordItem());
	public static final RegistryObject<Item> NIGHTMARE_GEM_SHOVEL = REGISTRY.register("nightmare_gem_shovel", () -> new NightmareGemShovelItem());
	public static final RegistryObject<Item> NIGHTMARE_GEM_HOE = REGISTRY.register("nightmare_gem_hoe", () -> new NightmareGemHoeItem());
	public static final RegistryObject<Item> NIGHTMARE_GEM_ARMOR_HELMET = REGISTRY.register("nightmare_gem_armor_helmet",
			() -> new NightmareGemArmorItem.Helmet());
	public static final RegistryObject<Item> NIGHTMARE_GEM_ARMOR_CHESTPLATE = REGISTRY.register("nightmare_gem_armor_chestplate",
			() -> new NightmareGemArmorItem.Chestplate());
	public static final RegistryObject<Item> NIGHTMARE_GEM_ARMOR_LEGGINGS = REGISTRY.register("nightmare_gem_armor_leggings",
			() -> new NightmareGemArmorItem.Leggings());
	public static final RegistryObject<Item> NIGHTMARE_GEM_ARMOR_BOOTS = REGISTRY.register("nightmare_gem_armor_boots",
			() -> new NightmareGemArmorItem.Boots());
	public static final RegistryObject<Item> DREAM_DOORWAY_FRAME = block(DreamsAndNightmaresModBlocks.DREAM_DOORWAY_FRAME,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> DREAMBLOSSOM = block(DreamsAndNightmaresModBlocks.DREAMBLOSSOM, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> RESILIENCE = block(DreamsAndNightmaresModBlocks.RESILIENCE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> INNER_LIGHT = REGISTRY.register("inner_light", () -> new InnerLightItem());
	public static final RegistryObject<Item> NIGHTCAP_HELMET = REGISTRY.register("nightcap_helmet", () -> new NightcapItem.Helmet());
	public static final RegistryObject<Item> NIGHTCAP_CHESTPLATE = REGISTRY.register("nightcap_chestplate", () -> new NightcapItem.Chestplate());
	public static final RegistryObject<Item> NIGHTCAP_LEGGINGS = REGISTRY.register("nightcap_leggings", () -> new NightcapItem.Leggings());
	public static final RegistryObject<Item> NIGHTCAP_BOOTS = REGISTRY.register("nightcap_boots", () -> new NightcapItem.Boots());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
