package com.spacecraftteam.spacecraft.block;

import com.spacecraftteam.spacecraft.SpaceCraft;
import com.spacecraftteam.spacecraft.block.custom.AluminumLampBlock;
import com.spacecraftteam.spacecraft.block.custom.EnergeticHealerBlock;
import com.spacecraftteam.spacecraft.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

	public static final Block ALUMINUM_BLOCK = registerBlock("aluminum_block",
			new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool().sounds(BlockSoundGroup.METAL)), ModItemGroup.MAIN_GROUP);
	public static final Block ASTRO_STATION = registerBlock("astro_station",
			new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool().sounds(BlockSoundGroup.METAL)), ModItemGroup.MAIN_GROUP);
	public static final Block ALUMINUM_ORE = registerBlock("aluminum_ore",
			new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.STONE),
				UniformIntProvider.create(2, 5)), ModItemGroup.MAIN_GROUP);
	public static final Block DEEPSLATE_ALUMINUM_ORE = registerBlock("deepslate_aluminum_ore",
			new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE),
					UniformIntProvider.create(2, 5)), ModItemGroup.MAIN_GROUP);

	public static final Block ENERGETIC_HEALER = registerBlock("energetic_healer",
			new EnergeticHealerBlock(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool().sounds(BlockSoundGroup.METAL)), ModItemGroup.MAIN_GROUP);
	public static final Block ALUMINUM_LAMP = registerBlock("aluminum_lamp",
			new AluminumLampBlock(FabricBlockSettings.of(Material.REDSTONE_LAMP).strength(2f).sounds(BlockSoundGroup.GLASS).luminance(state -> state.get(AluminumLampBlock.LIT) ? 11 : 0)), ModItemGroup.MAIN_GROUP);

	private static Block registerBlock(String name, Block block, ItemGroup tab) {
		registerBlockItem(name, block, tab);
		return Registry.register(Registries.BLOCK, new Identifier(SpaceCraft.MOD_ID, name), block);
	}
	private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
		ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.add(block));
		return Registry.register(Registries.ITEM, new Identifier(SpaceCraft.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
	}

	public static void registerModBlocks() {
		SpaceCraft.LOGGER.debug("Registering Mod Blocks for " + SpaceCraft.MOD_ID);
	}

}
