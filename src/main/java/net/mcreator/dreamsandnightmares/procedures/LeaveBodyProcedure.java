package net.mcreator.dreamsandnightmares.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;

import net.mcreator.dreamsandnightmares.network.DreamsAndNightmaresModVariables;
import net.mcreator.dreamsandnightmares.init.DreamsAndNightmaresModItems;

import java.util.Comparator;

public class LeaveBodyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity PlayerBody = null;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = new Zombie(EntityType.ZOMBIE, _level);
			entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
			if (entityToSpawn instanceof Mob _mobToSpawn)
				_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
			world.addFreshEntity(entityToSpawn);
		}
		PlayerBody = (Entity) world.getEntitiesOfClass(Zombie.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream()
				.sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null);
		PlayerBody.setCustomName(new TextComponent((entity.getDisplayName().getString())));
		if (PlayerBody instanceof LivingEntity _entity)
			_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
		{
			Entity _entity = PlayerBody;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(0,
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.FEET,
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
			}
		}
		{
			Entity _entity = PlayerBody;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(1,
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.LEGS,
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
			}
		}
		{
			Entity _entity = PlayerBody;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(2,
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.CHEST,
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
				.getItem() == (ItemStack.EMPTY).getItem()) {
			{
				Entity _entity = PlayerBody;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, new ItemStack(DreamsAndNightmaresModItems.NIGHTCAP_HELMET.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(DreamsAndNightmaresModItems.NIGHTCAP_HELMET.get()));
				}
			}
		} else {
			{
				Entity _entity = PlayerBody;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3,
							(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD,
							(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
				}
			}
		}
		if (PlayerBody instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION,
					entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.REGENERATION)
							? _livEnt.getEffect(MobEffects.REGENERATION).getDuration()
							: 0,
					entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.REGENERATION)
							? _livEnt.getEffect(MobEffects.REGENERATION).getAmplifier()
							: 0));
		if (PlayerBody instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 999999, 255));
		if (PlayerBody instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 999999, 255));
		while ((entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY,
				new ResourceLocation("dreams_and_nightmares:slumber_dimension")))
				|| (entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY,
						new ResourceLocation("dreams_and_nightmares:nightmare_dimension")))) {
			{
				double _setval = PlayerBody.getX();
				entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.RealPlayerX = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = PlayerBody.getY();
				entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.RealPlayerY = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = PlayerBody.getZ();
				entity.getCapability(DreamsAndNightmaresModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.RealPlayerZ = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (!PlayerBody.isAlive()) {
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
				if (entity instanceof LivingEntity _entity)
					_entity.hurt(new DamageSource("dream").bypassArmor(), 9999);
			}
			if (DreamsAndNightmaresModVariables.MapVariables.get(world).TestVarBool == true) {
				PlayerBody.hurt(DamageSource.GENERIC, 99999);
			}
		}
		if (!PlayerBody.level.isClientSide())
			PlayerBody.discard();
	}
}
