
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.hollowedhell.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.hollowedhell.item.VoidEssenceItem;
import net.mcreator.hollowedhell.item.HollowedHellItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HollowedhellModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item HOLLOW_BLOCK = register(HollowedhellModBlocks.HOLLOW_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item VOID_ESSENCE_BUCKET = register(new VoidEssenceItem());
	public static final Item HOLLOWED_HELL = register(new HollowedHellItem());
	public static final Item VOIDBOWL_PLANT = register(HollowedhellModBlocks.VOIDBOWL_PLANT, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item VOIDBOWL_BLOCK = register(HollowedhellModBlocks.VOIDBOWL_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item HOLEFLOWER = register(HollowedhellModBlocks.HOLEFLOWER, CreativeModeTab.TAB_DECORATIONS);

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	private static Item register(Block block, CreativeModeTab tab) {
		return register(new BlockItem(block, new Item.Properties().tab(tab)).setRegistryName(block.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
