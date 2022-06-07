package net.mcreator.dreamsandnightmares.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.dreamsandnightmares.network.DreamsAndNightmaresModVariables;

public class Test1TrueProcedure {
	public static void execute(LevelAccessor world) {
		DreamsAndNightmaresModVariables.MapVariables.get(world).TestVarBool = true;
		DreamsAndNightmaresModVariables.MapVariables.get(world).syncData(world);
	}
}
