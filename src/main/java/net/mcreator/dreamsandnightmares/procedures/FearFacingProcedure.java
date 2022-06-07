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
		double blockX = 0;
		double blockY = 0;
		double blockZ = 0;
		if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == (ResourceKey.create(Registry.DIMENSION_REGISTRY,
				new ResourceLocation("dreams_and_nightmares:nightmare_dimension")))) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("You faced your fears with a clear mind."), (false));
			blockX = x;
			blockY = y;
			blockZ = z;
			for (int index0 = 0; index0 < (int) (10); index0++) {
				for (int index1 = 0; index1 < (int) (10); index1++) {
					for (int index2 = 0; index2 < (int) (10); index2++) {
						if ((world.getBlockState(new BlockPos(blockX, blockY, blockZ))).getBlock() == DreamsAndNightmaresModBlocks.FEAR.get()) {
							{
								BlockPos _bp = new BlockPos(blockX, blockY, blockZ);
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
							blockX = blockX + 1;
						}
					}
					blockX = blockX - 10;
					blockZ = blockZ + 1;
				}
				blockZ = blockZ - 10;
				blockY = blockY + 1;
			}
			blockY = blockY - 10;
			for (int index3 = 0; index3 < (int) (10); index3++) {
				for (int index4 = 0; index4 < (int) (10); index4++) {
					for (int index5 = 0; index5 < (int) (10); index5++) {
						if ((world.getBlockState(new BlockPos(blockX, blockY, blockZ))).getBlock() == DreamsAndNightmaresModBlocks.FEAR.get()) {
							{
								BlockPos _bp = new BlockPos(blockX, blockY, blockZ);
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
							blockX = blockX + 1;
						}
					}
					blockX = blockX - 10;
					blockZ = blockZ + 1;
				}
				blockZ = blockZ - 10;
				blockY = blockY - 1;
			}
			blockY = blockY + 10;
			for (int index6 = 0; index6 < (int) (10); index6++) {
				for (int index7 = 0; index7 < (int) (10); index7++) {
					for (int index8 = 0; index8 < (int) (10); index8++) {
						if ((world.getBlockState(new BlockPos(blockX, blockY, blockZ))).getBlock() == DreamsAndNightmaresModBlocks.FEAR.get()) {
							{
								BlockPos _bp = new BlockPos(blockX, blockY, blockZ);
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
							blockX = blockX + 1;
						}
					}
					blockX = blockX - 10;
					blockZ = blockZ - 1;
				}
				blockZ = blockZ + 10;
				blockY = blockY - 1;
			}
			blockY = blockY + 10;
			for (int index9 = 0; index9 < (int) (10); index9++) {
				for (int index10 = 0; index10 < (int) (10); index10++) {
					for (int index11 = 0; index11 < (int) (10); index11++) {
						if ((world.getBlockState(new BlockPos(blockX, blockY, blockZ))).getBlock() == DreamsAndNightmaresModBlocks.FEAR.get()) {
							{
								BlockPos _bp = new BlockPos(blockX, blockY, blockZ);
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
							blockX = blockX - 1;
						}
					}
					blockX = blockX + 10;
					blockZ = blockZ - 1;
				}
				blockZ = blockZ + 10;
				blockY = blockY - 1;
			}
			blockY = blockY + 10;
			for (int index12 = 0; index12 < (int) (10); index12++) {
				for (int index13 = 0; index13 < (int) (10); index13++) {
					for (int index14 = 0; index14 < (int) (10); index14++) {
						if ((world.getBlockState(new BlockPos(blockX, blockY, blockZ))).getBlock() == DreamsAndNightmaresModBlocks.FEAR.get()) {
							{
								BlockPos _bp = new BlockPos(blockX, blockY, blockZ);
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
							blockX = blockX - 1;
						}
					}
					blockX = blockX + 10;
					blockZ = blockZ + 1;
				}
				blockZ = blockZ - 10;
				blockY = blockY - 1;
			}
			blockY = blockY + 10;
			for (int index15 = 0; index15 < (int) (10); index15++) {
				for (int index16 = 0; index16 < (int) (10); index16++) {
					for (int index17 = 0; index17 < (int) (10); index17++) {
						if ((world.getBlockState(new BlockPos(blockX, blockY, blockZ))).getBlock() == DreamsAndNightmaresModBlocks.FEAR.get()) {
							{
								BlockPos _bp = new BlockPos(blockX, blockY, blockZ);
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
							blockX = blockX + 1;
						}
					}
					blockX = blockX - 10;
					blockZ = blockZ + 1;
				}
				blockZ = blockZ - 10;
				blockY = blockY + 1;
			}
			blockY = blockY - 10;
			for (int index18 = 0; index18 < (int) (10); index18++) {
				for (int index19 = 0; index19 < (int) (10); index19++) {
					for (int index20 = 0; index20 < (int) (10); index20++) {
						if ((world.getBlockState(new BlockPos(blockX, blockY, blockZ))).getBlock() == DreamsAndNightmaresModBlocks.FEAR.get()) {
							{
								BlockPos _bp = new BlockPos(blockX, blockY, blockZ);
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
							blockX = blockX - 1;
						}
					}
					blockX = blockX + 10;
					blockZ = blockZ - 1;
				}
				blockZ = blockZ + 10;
				blockY = blockY + 1;
			}
			blockY = blockY - 10;
			for (int index21 = 0; index21 < (int) (10); index21++) {
				for (int index22 = 0; index22 < (int) (10); index22++) {
					for (int index23 = 0; index23 < (int) (10); index23++) {
						if ((world.getBlockState(new BlockPos(blockX, blockY, blockZ))).getBlock() == DreamsAndNightmaresModBlocks.FEAR.get()) {
							{
								BlockPos _bp = new BlockPos(blockX, blockY, blockZ);
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
							blockX = blockX - 1;
						}
					}
					blockX = blockX + 10;
					blockZ = blockZ + 1;
				}
				blockZ = blockZ - 10;
				blockY = blockY + 1;
			}
		}
	}
}
