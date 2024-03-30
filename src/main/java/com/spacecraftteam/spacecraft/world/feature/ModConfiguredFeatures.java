package com.spacecraftteam.spacecraft.world.feature;

import com.spacecraftteam.spacecraft.SpaceCraft;
import com.spacecraftteam.spacecraft.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {

	public static final RegistryKey<ConfiguredFeature<?,?>> ALUMINUM_ORE_KEY = registerKey("aluminum_ore");

	public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
		var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

		RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
		RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

		List<OreFeatureConfig.Target> overworldAluminumOres =
				List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.ALUMINUM_ORE.getDefaultState()),
						OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_ALUMINUM_ORE.getDefaultState()));

		register(context, ALUMINUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldAluminumOres, 8));
	}

	public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
		return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(SpaceCraft.MOD_ID, name));
	}

	private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
																				   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
		context.register(key, new ConfiguredFeature<>(feature, configuration));
	}

}
