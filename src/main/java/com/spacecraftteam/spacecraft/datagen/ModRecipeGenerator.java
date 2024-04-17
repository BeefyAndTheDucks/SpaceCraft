package com.spacecraftteam.spacecraft.datagen;

import com.spacecraftteam.spacecraft.block.ModBlocks;
import com.spacecraftteam.spacecraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
	public ModRecipeGenerator(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generate(Consumer<RecipeJsonProvider> exporter) {
		// Smelting
		offerBlastingAndSmelting(exporter, List.of(ModBlocks.ALUMINUM_ORE), RecipeCategory.MISC, ModItems.RAW_ALUMINUM,
				3f, 150, "aluminum");
		offerBlastingAndSmelting(exporter, List.of(ModBlocks.DEEPSLATE_ALUMINUM_ORE), RecipeCategory.MISC, ModItems.RAW_ALUMINUM,
				3f, 150, "aluminum");
		offerBlastingAndSmelting(exporter, List.of(ModItems.RAW_ALUMINUM), RecipeCategory.MISC, ModItems.ALUMINUM,
				3f, 100, "aluminum");

		// Crafting
		offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ALUMINUM, RecipeCategory.MISC, ModBlocks.ALUMINUM_BLOCK);
		offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_ALUMINUM, RecipeCategory.MISC, ModBlocks.RAW_ALUMINUM_BLOCK);

		// Custom Shaped
		ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENERGETIC_HEALER)
				.pattern("RAR")
				.pattern("AGA")
				.pattern("RAR")
				.input('A', ModItems.ALUMINUM)
				.input('G', Items.GOLDEN_APPLE)
				.input('R', Items.REDSTONE)
				.criterion(FabricRecipeProvider.hasItem(Items.GOLDEN_APPLE),
						FabricRecipeProvider.conditionsFromItem(Items.GOLDEN_APPLE))
				.criterion(FabricRecipeProvider.hasItem(Items.REDSTONE),
						FabricRecipeProvider.conditionsFromItem(Items.REDSTONE))
				.criterion(FabricRecipeProvider.hasItem(ModItems.ALUMINUM),
						FabricRecipeProvider.conditionsFromItem(ModItems.ALUMINUM))
				.offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.ENERGETIC_HEALER)));

		ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ASTRO_STATION)
				.pattern(" A ")
				.pattern("ABA")
				.pattern(" A ")
				.input('A', ModItems.ALUMINUM)
				.input('B', Items.BOOK)
				.criterion(FabricRecipeProvider.hasItem(Items.BOOK),
						FabricRecipeProvider.conditionsFromItem(Items.BOOK))
				.criterion(FabricRecipeProvider.hasItem(ModItems.ALUMINUM),
						FabricRecipeProvider.conditionsFromItem(ModItems.ALUMINUM))
				.offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.ASTRO_STATION)));

		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SPACEPEDIA)
				.pattern("RAR")
				.pattern("ARA")
				.pattern("RAR")
				.input('A', ModItems.ALUMINUM)
				.input('R', Items.REDSTONE)
				.criterion(FabricRecipeProvider.hasItem(Items.REDSTONE),
						FabricRecipeProvider.conditionsFromItem(Items.REDSTONE))
				.criterion(FabricRecipeProvider.hasItem(ModItems.ALUMINUM),
						FabricRecipeProvider.conditionsFromItem(ModItems.ALUMINUM))
				.offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.SPACEPEDIA)));
	}

	private void offerBlastingAndSmelting(Consumer<RecipeJsonProvider> exporter, List<ItemConvertible> inputs, RecipeCategory category, ItemConvertible output, float experience, int blastCookTime, String group) {
		offerBlasting(exporter, inputs, category, output, experience, blastCookTime, group);
		offerSmelting(exporter, inputs, category, output, experience, blastCookTime * 2, group);
	}
}
