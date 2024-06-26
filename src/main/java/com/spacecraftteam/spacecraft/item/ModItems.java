package com.spacecraftteam.spacecraft.item;

import com.spacecraftteam.spacecraft.SpaceCraft;
import com.spacecraftteam.spacecraft.item.custom.CreativeTeleporterItem;
import com.spacecraftteam.spacecraft.item.custom.SpacepediaItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

	public static final Item RAW_ALUMINUM = registerItem("raw_aluminum",
			new Item(new FabricItemSettings()), ModItemGroup.MAIN_GROUP);
	public static final Item ALUMINUM = registerItem("aluminum",
			new Item(new FabricItemSettings()), ModItemGroup.MAIN_GROUP);
	public static final Item SPACEPEDIA = registerItem("spacepedia",
			new SpacepediaItem(new FabricItemSettings().maxCount(1)), ModItemGroup.MAIN_GROUP);
	public static final Item CREATIVE_TELEPORTER = registerItem("creative_teleporter",
			new CreativeTeleporterItem(new FabricItemSettings().maxCount(1)), ModItemGroup.MAIN_GROUP);

	private static Item registerItem(String name, Item item, ItemGroup group) {
		ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
		return Registry.register(Registries.ITEM, new Identifier(SpaceCraft.MOD_ID, name), item);
	}

	public static void registerModItems() {
		SpaceCraft.LOGGER.debug("Registering Mod Items for " + SpaceCraft.MOD_ID);
	}

}
