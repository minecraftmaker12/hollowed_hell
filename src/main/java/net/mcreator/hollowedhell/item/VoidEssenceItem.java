
package net.mcreator.hollowedhell.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BucketItem;

import net.mcreator.hollowedhell.init.HollowedhellModFluids;

public class VoidEssenceItem extends BucketItem {
	public VoidEssenceItem() {
		super(() -> HollowedhellModFluids.VOID_ESSENCE,
				new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(CreativeModeTab.TAB_MISC));
		setRegistryName("void_essence_bucket");
	}
}
