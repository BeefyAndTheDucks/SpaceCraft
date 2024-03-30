package com.spacecraftteam.spacecraft.datagen;

import com.spacecraftteam.spacecraft.block.ModBlocks;
import com.spacecraftteam.spacecraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {

	protected ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generate() {
		addDrop(ModBlocks.ALUMINUM_BLOCK);
		addDrop(ModBlocks.ASTRO_STATION);
		addDrop(ModBlocks.ENERGETIC_HEALER);

		addDrop(ModBlocks.ALUMINUM_ORE, multipleOreDrops(ModBlocks.ALUMINUM_ORE, ModItems.RAW_ALUMINUM, 1, 3));
		addDrop(ModBlocks.DEEPSLATE_ALUMINUM_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_ALUMINUM_ORE, ModItems.RAW_ALUMINUM, 1, 3));
	}

	private LootTable.Builder multipleOreDrops(Block drop, Item item, float minimumDropAmount, float maximumDropAmount) {
		return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
				((LeafEntry.Builder)
						ItemEntry.builder(item)
								.apply(SetCountLootFunction
										.builder(UniformLootNumberProvider
												.create(minimumDropAmount, maximumDropAmount))))
						.apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
	}
}
