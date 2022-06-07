
package net.mcreator.dreamsandnightmares.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BucketItem;

import net.mcreator.dreamsandnightmares.init.DreamsAndNightmaresModFluids;

public class DrowningDreamItem extends BucketItem {
	public DrowningDreamItem() {
		super(DreamsAndNightmaresModFluids.DROWNING_DREAM,
				new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(CreativeModeTab.TAB_MISC));
	}
}
