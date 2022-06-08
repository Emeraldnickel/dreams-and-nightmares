package net.mcreator.dreamsandnightmares.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;

import net.mcreator.dreamsandnightmares.init.DreamsAndNightmaresModBlocks;

import java.util.Map;

public class FearFacingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double blockX = 0;
		double blockY = 0;
		double blockZ = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double count = 0;
		if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == (ResourceKey.create(Registry.DIMENSION_REGISTRY,
				new ResourceLocation("dreams_and_nightmares:nightmare_dimension")))) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("You faced your fears with a clear mind."), (false));
			sx = -5;
			found = false;
			count = 0;
			for (int index0 = 0; index0 < (int) (10); index0++) {
				sy = -5;
				for (int index1 = 0; index1 < (int) (10); index1++) {
					sz = -5;
					for (int index2 = 0; index2 < (int) (10); index2++) {
						if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == DreamsAndNightmaresModBlocks.FEAR.get()) {
							found = true;
							{
								BlockPos _bp = new BlockPos(x + sx, y + sy, z + sz);
								BlockState _bs = DreamsAndNightmaresModBlocks.RESILIENCE.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
									Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
									if (_property != null && _bs.getValue(_property) != null)
										try {
											_bs = _bs.setValue(_property, (Comparable) entry.getValue());
										} catch (Exception e) {
										}
								}
								world.setBlock(_bp, _bs, 3);
							}
							count = count + 1;
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
			if (found == true) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent(("Successfully replaced " + Math.round(count) + " blocks!")), (false));
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent("But you had no fears to face."), (false));
			}
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("But you weren't having a nightmare..."), (false));
		}
	}
}
