package com.spacecraftteam.spacecraft.world.biome.surface;

import com.spacecraftteam.spacecraft.block.ModBlocks;
import com.spacecraftteam.spacecraft.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
	private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
	private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.DIRT);
	private static final MaterialRules.MaterialRule ALUMINUM = makeStateRule(ModBlocks.ALUMINUM_ORE);
	private static final MaterialRules.MaterialRule RAW_ALUMINUM = makeStateRule(ModBlocks.RAW_ALUMINUM_BLOCK);

	public static MaterialRules.MaterialRule makeRules() {
		MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

		MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

		return MaterialRules.sequence(
				// Default to a grass and dirt surface
				MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
		);
	}

	private static MaterialRules.MaterialRule makeStateRule(Block block) {
		return MaterialRules.block(block.getDefaultState());
	}
}
