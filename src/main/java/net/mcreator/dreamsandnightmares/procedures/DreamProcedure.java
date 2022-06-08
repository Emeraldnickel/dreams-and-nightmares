package net.mcreator.dreamsandnightmares.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.dreamsandnightmares.network.DreamsAndNightmaresModVariables;
import net.mcreator.dreamsandnightmares.init.DreamsAndNightmaresModMobEffects;
import net.mcreator.dreamsandnightmares.init.DreamsAndNightmaresModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DreamProcedure {
	@SubscribeEvent
	public static void onPlayerInBed(PlayerSleepInBedEvent event) {
		execute(event, event.getPlayer().level, event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity playerBody = null;
		if (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
				? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("none"))).isDone()
				: false) {
			if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == (Level.OVERWORLD)) {
				{
					double _setval = x;
					entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.RealPlayerX = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = y;
					entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.RealPlayerY = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = z;
					entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.RealPlayerZ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				LeaveBodyProcedure.execute(world, x, y, z, entity);
				if (!(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(DreamsAndNightmaresModMobEffects.DREAMING.get()) : false)
						&& ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
								.getItem() == DreamsAndNightmaresModItems.NIGHTMARE_GEM_ARMOR_HELMET.get()
								|| (entity instanceof LivingEntity _livEnt
										? _livEnt.hasEffect(DreamsAndNightmaresModMobEffects.BAD_DREAMING.get())
										: false)
								|| Math.random() > 0.9)) {
					if (entity instanceof ServerPlayer _player && !_player.level.isClientSide()) {
						ResourceKey<Level> destinationType = ResourceKey.create(Registry.DIMENSION_REGISTRY,
								new ResourceLocation("dreams_and_nightmares:nightmare_dimension"));
						if (_player.level.dimension() == destinationType)
							return;
						ServerLevel nextLevel = _player.server.getLevel(destinationType);
						if (nextLevel != null) {
							_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
							_player.teleportTo(nextLevel, nextLevel.getSharedSpawnPos().getX(), nextLevel.getSharedSpawnPos().getY() + 1,
									nextLevel.getSharedSpawnPos().getZ(), _player.getYRot(), _player.getXRot());
							_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
							for (MobEffectInstance _effectinstance : _player.getActiveEffects())
								_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
							_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
						}
					}
				} else {
					if ((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).DreamPlayerY == 0) {
						if (entity instanceof ServerPlayer _player && !_player.level.isClientSide()) {
							ResourceKey<Level> destinationType = ResourceKey.create(Registry.DIMENSION_REGISTRY,
									new ResourceLocation("dreams_and_nightmares:slumber_dimension"));
							if (_player.level.dimension() == destinationType)
								return;
							ServerLevel nextLevel = _player.server.getLevel(destinationType);
							if (nextLevel != null) {
								_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
								_player.teleportTo(nextLevel, nextLevel.getSharedSpawnPos().getX(), nextLevel.getSharedSpawnPos().getY() + 1,
										nextLevel.getSharedSpawnPos().getZ(), _player.getYRot(), _player.getXRot());
								_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
								for (MobEffectInstance _effectinstance : _player.getActiveEffects())
									_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
								_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
						{
							Entity _ent = entity;
							_ent.teleportTo(
									((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).DreamPlayerX),
									(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)),
									((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).DreamPlayerZ));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(
										((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).DreamPlayerX),
										(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)),
										((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).DreamPlayerZ),
										_ent.getYRot(), _ent.getXRot());
						}
					} else {
						if (entity instanceof ServerPlayer _player && !_player.level.isClientSide()) {
							ResourceKey<Level> destinationType = ResourceKey.create(Registry.DIMENSION_REGISTRY,
									new ResourceLocation("dreams_and_nightmares:slumber_dimension"));
							if (_player.level.dimension() == destinationType)
								return;
							ServerLevel nextLevel = _player.server.getLevel(destinationType);
							if (nextLevel != null) {
								_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
								_player.teleportTo(nextLevel, nextLevel.getSharedSpawnPos().getX(), nextLevel.getSharedSpawnPos().getY() + 1,
										nextLevel.getSharedSpawnPos().getZ(), _player.getYRot(), _player.getXRot());
								_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
								for (MobEffectInstance _effectinstance : _player.getActiveEffects())
									_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
								_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
						{
							Entity _ent = entity;
							_ent.teleportTo(
									((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).DreamPlayerX),
									((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).DreamPlayerY),
									((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).DreamPlayerZ));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(
										((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).DreamPlayerX),
										((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).DreamPlayerY),
										((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).DreamPlayerZ),
										_ent.getYRot(), _ent.getXRot());
						}
					}
				}
			} else if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == (ResourceKey.create(Registry.DIMENSION_REGISTRY,
					new ResourceLocation("dreams_and_nightmares:slumber_dimension")))) {
				{
					double _setval = x;
					entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DreamPlayerX = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = y;
					entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DreamPlayerY = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = z;
					entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DreamPlayerZ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(DreamsAndNightmaresModMobEffects.DREAMING.get()) : false) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(DreamsAndNightmaresModMobEffects.DREAMING.get());
				}
				if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(DreamsAndNightmaresModMobEffects.BAD_DREAMING.get()) : false) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(DreamsAndNightmaresModMobEffects.BAD_DREAMING.get());
				}
				if ((world.isClientSide()
						? Minecraft.getInstance().getConnection().getOnlinePlayers().size()
						: ServerLifecycleHooks.getCurrentServer().getPlayerCount()) == world.players().size() && world.dayTime() > 12000) {
					if (world instanceof ServerLevel _level)
						_level.setDayTime(0);
				}
				if (entity instanceof ServerPlayer _player && !_player.level.isClientSide()) {
					ResourceKey<Level> destinationType = Level.OVERWORLD;
					if (_player.level.dimension() == destinationType)
						return;
					ServerLevel nextLevel = _player.server.getLevel(destinationType);
					if (nextLevel != null) {
						_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
						_player.teleportTo(nextLevel, nextLevel.getSharedSpawnPos().getX(), nextLevel.getSharedSpawnPos().getY() + 1,
								nextLevel.getSharedSpawnPos().getZ(), _player.getYRot(), _player.getXRot());
						_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
						for (MobEffectInstance _effectinstance : _player.getActiveEffects())
							_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
						_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
					}
				}
				{
					Entity _ent = entity;
					_ent.teleportTo(
							((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).RealPlayerX),
							((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).RealPlayerY),
							((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).RealPlayerZ));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(
								((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).RealPlayerX),
								((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).RealPlayerY),
								((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).RealPlayerZ),
								_ent.getYRot(), _ent.getXRot());
				}
			} else if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == (ResourceKey.create(Registry.DIMENSION_REGISTRY,
					new ResourceLocation("dreams_and_nightmares:nightmare_dimension")))) {
				if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(DreamsAndNightmaresModMobEffects.DREAMING.get()) : false) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(DreamsAndNightmaresModMobEffects.DREAMING.get());
				}
				if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(DreamsAndNightmaresModMobEffects.BAD_DREAMING.get()) : false) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(DreamsAndNightmaresModMobEffects.BAD_DREAMING.get());
				}
				if (entity instanceof ServerPlayer _player && !_player.level.isClientSide()) {
					ResourceKey<Level> destinationType = Level.OVERWORLD;
					if (_player.level.dimension() == destinationType)
						return;
					ServerLevel nextLevel = _player.server.getLevel(destinationType);
					if (nextLevel != null) {
						_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
						_player.teleportTo(nextLevel, nextLevel.getSharedSpawnPos().getX(), nextLevel.getSharedSpawnPos().getY() + 1,
								nextLevel.getSharedSpawnPos().getZ(), _player.getYRot(), _player.getXRot());
						_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
						for (MobEffectInstance _effectinstance : _player.getActiveEffects())
							_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
						_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
					}
				}
				{
					Entity _ent = entity;
					_ent.teleportTo(
							((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).RealPlayerX),
							((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).RealPlayerY),
							((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).RealPlayerZ));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(
								((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).RealPlayerX),
								((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).RealPlayerY),
								((entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DreamsAndNightmaresModVariables.PlayerVariables())).RealPlayerZ),
								_ent.getYRot(), _ent.getXRot());
				}
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 1));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 1));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 60, 1));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.scream")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.scream")),
								SoundSource.HOSTILE, 1, 1, false);
					}
				}
			}
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 2));
		}
	}
}
