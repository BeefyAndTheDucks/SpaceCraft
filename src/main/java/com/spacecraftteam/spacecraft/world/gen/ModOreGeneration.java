package com.spacecraftteam.spacecraft.world.gen;

import com.spacecraftteam.spacecraft.world.feature.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {

	public static void generateOres() {
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
				GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ALUMINUM_ORE_PLACED_KEY);
	}

}
