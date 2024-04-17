package com.spacecraftteam.spacecraft.datagen;

import com.spacecraftteam.spacecraft.block.ModBlocks;
import com.spacecraftteam.spacecraft.fluid.ModFluids;
import com.spacecraftteam.spacecraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
	public ModModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
		blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ENERGETIC_HEALER);
		blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ALUMINUM_BLOCK);
		blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RAW_ALUMINUM_BLOCK);
		blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ASTRO_STATION);
		blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ALUMINUM_ORE);
		blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DEEPSLATE_ALUMINUM_ORE);

		registerHasLit(blockStateModelGenerator, ModBlocks.ALUMINUM_LAMP);
	}

	private void registerHasLit(BlockStateModelGenerator blockStateModelGenerator, Block block) {
		Identifier identifier = TexturedModel.CUBE_ALL.upload(block, blockStateModelGenerator.modelCollector);
		Identifier identifier2 = blockStateModelGenerator.createSubModel(block, "_on", Models.CUBE_ALL, TextureMap::all);
		blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(BlockStateModelGenerator.createBooleanModelMap(Properties.LIT, identifier2, identifier)));
	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		itemModelGenerator.register(ModItems.ALUMINUM, Models.GENERATED);
		itemModelGenerator.register(ModItems.RAW_ALUMINUM, Models.GENERATED);
		itemModelGenerator.register(ModItems.SPACEPEDIA, Models.GENERATED);
		itemModelGenerator.register(ModItems.CREATIVE_TELEPORTER, Models.GENERATED);
		itemModelGenerator.register(ModFluids.CRUDE_OIL_BUCKET, Models.GENERATED);
	}
}
