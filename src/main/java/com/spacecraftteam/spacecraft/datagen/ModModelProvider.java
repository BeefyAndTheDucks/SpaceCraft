package com.spacecraftteam.spacecraft.datagen;

import com.spacecraftteam.spacecraft.block.ModBlocks;
import com.spacecraftteam.spacecraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
	public ModModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
		blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ENERGETIC_HEALER);
		blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ALUMINUM_BLOCK);
		blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ALUMINUM_ORE);
		blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DEEPSLATE_ALUMINUM_ORE);
	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		itemModelGenerator.register(ModItems.ALUMINUM, Models.GENERATED);
		itemModelGenerator.register(ModItems.RAW_ALUMINUM, Models.GENERATED);
		itemModelGenerator.register(ModItems.SPACEPEDIA, Models.GENERATED);
	}
}
