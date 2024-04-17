package com.spacecraftteam.spacecraft.world.biome;

import com.spacecraftteam.spacecraft.SpaceCraft;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class ModBiomes {

	public static final RegistryKey<Biome> SOFT_PLAINS = RegistryKey.of(RegistryKeys.BIOME, new Identifier(SpaceCraft.MOD_ID, "soft_plains"));

	public static void bootstrap(Registerable<Biome> context) {
		context.register(SOFT_PLAINS, softPlains(context));
	}

	public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
		DefaultBiomeFeatures.addLandCarvers(builder);
		DefaultBiomeFeatures.addAmethystGeodes(builder);
		DefaultBiomeFeatures.addDungeons(builder);
		DefaultBiomeFeatures.addMineables(builder);
		DefaultBiomeFeatures.addSprings(builder);
		DefaultBiomeFeatures.addFrozenTopLayer(builder);
	}

	public static Biome softPlains(Registerable<Biome> context) {
		SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
		GenerationSettings.LookupBackedBuilder biomeBuilder =
				new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
						context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));
		globalOverworldGeneration(biomeBuilder);

		DefaultBiomeFeatures.addPlainsMobs(spawnBuilder);
		DefaultBiomeFeatures.addPlainsTallGrass(biomeBuilder);

		DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
		DefaultBiomeFeatures.addDefaultDisks(biomeBuilder);

		DefaultBiomeFeatures.addPlainsFeatures(biomeBuilder);

		DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);

		DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

		return new Biome.Builder()
				.precipitation(true)
				.downfall(0.4f)
				.temperature(0.8f)
				.generationSettings(biomeBuilder.build())
				.spawnSettings(spawnBuilder.build())
				.effects((new BiomeEffects.Builder())
						.waterColor(4159204)
						.waterFogColor(329011)
						.skyColor(7907327)
						.fogColor(12638463)
						.moodSound(BiomeMoodSound.CAVE)
						.build())
				.build();
	}

}
