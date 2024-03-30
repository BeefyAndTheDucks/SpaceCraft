package com.spacecraftteam.spacecraft.item;

import com.spacecraftteam.spacecraft.SpaceCraft;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
	public static final ItemGroup MAIN_GROUP = FabricItemGroup.builder(new Identifier(SpaceCraft.MOD_ID, "space_craft_group"))
			.icon(() -> new ItemStack(ModItems.ALUMINUM))
			.build();
}
