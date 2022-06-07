
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dreamsandnightmares.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.dreamsandnightmares.potion.DreamingMobEffect;
import net.mcreator.dreamsandnightmares.potion.BadDreamingMobEffect;
import net.mcreator.dreamsandnightmares.DreamsAndNightmaresMod;

public class DreamsAndNightmaresModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DreamsAndNightmaresMod.MODID);
	public static final RegistryObject<MobEffect> DREAMING = REGISTRY.register("dreaming", () -> new DreamingMobEffect());
	public static final RegistryObject<MobEffect> BAD_DREAMING = REGISTRY.register("bad_dreaming", () -> new BadDreamingMobEffect());
}
