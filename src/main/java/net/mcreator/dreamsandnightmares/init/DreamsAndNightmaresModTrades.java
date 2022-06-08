
/*
*    MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.dreamsandnightmares.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerProfession;

import java.util.List;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DreamsAndNightmaresModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
		if (event.getType() == VillagerProfession.WEAPONSMITH) {
			trades.get(4).add(new BasicItemListing(new ItemStack(DreamsAndNightmaresModItems.KO_CRYSTAL.get(), 2), new ItemStack(Items.EMERALD, 8),
					new ItemStack(DreamsAndNightmaresModItems.KNOCKOUT_SWORD.get()), 5, 20, 0.05f));
			trades.get(2)
					.add(new BasicItemListing(new ItemStack(DreamsAndNightmaresModItems.DREAM_CRYSTAL.get(), 2),
							new ItemStack(DreamsAndNightmaresModItems.NIGHTMARE_GEM.get(), 2),
							new ItemStack(DreamsAndNightmaresModItems.KO_CRYSTAL.get(), 2), 10, 10, 0.05f));
		}
	}
}
