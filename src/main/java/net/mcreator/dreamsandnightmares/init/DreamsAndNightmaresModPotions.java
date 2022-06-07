
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dreamsandnightmares.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.dreamsandnightmares.DreamsAndNightmaresMod;

public class DreamsAndNightmaresModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, DreamsAndNightmaresMod.MODID);
	public static final RegistryObject<Potion> DREAM_POTION = REGISTRY.register("dream_potion",
			() -> new Potion(new MobEffectInstance(DreamsAndNightmaresModMobEffects.DREAMING.get(), 3600, 0, false, true)));
	public static final RegistryObject<Potion> NIGHTMARE_POTION = REGISTRY.register("nightmare_potion",
			() -> new Potion(new MobEffectInstance(DreamsAndNightmaresModMobEffects.BAD_DREAMING.get(), 3600, 0, false, true)));
}
