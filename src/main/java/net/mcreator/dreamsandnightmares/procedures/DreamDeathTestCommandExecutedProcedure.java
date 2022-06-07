package net.mcreator.dreamsandnightmares.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

public class DreamDeathTestCommandExecutedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.hurt(new DamageSource("dream").bypassArmor(), 999);
		entity.hurt(DamageSource.MAGIC, 1);
	}
}
