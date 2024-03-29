package com.spacecraftteam.spacecraft.item;

import com.spacecraftteam.spacecraft.SpaceCraft;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

	public static final Item RAW_ALUMINUM = registerItem("raw_aluminum",
			new Item(new FabricItemSettings()), ModItemGroup.SPACE_CRAFT_ITEM_GROUP);
	public static final Item ALUMINUM = registerItem("aluminum",
			new Item(new FabricItemSettings()), ModItemGroup.SPACE_CRAFT_ITEM_GROUP);

	private static Item registerItem(String name, Item item, ItemGroup group) {
		ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
		return Registry.register(Registries.ITEM, new Identifier(SpaceCraft.MOD_ID, name), item);
	}

	public static void registerModItems() {
		SpaceCraft.LOGGER.debug("Registering Mod Items for " + SpaceCraft.MOD_ID);
	}

}
