package com.spacecraftteam.spacecraft.world.dimension;

import com.spacecraftteam.spacecraft.SpaceCraft;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.OptionalLong;

public class ModDimensions {
	public static final RegistryKey<DimensionOptions> MARS_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
			new Identifier(SpaceCraft.MOD_ID, "mars"));
	public static final RegistryKey<World> MARS_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
			new Identifier(SpaceCraft.MOD_ID, "mars"));
	public static final RegistryKey<DimensionType> MARS_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
			new Identifier(SpaceCraft.MOD_ID, "mars_type"));

	public static void bootstrapType(Registerable<DimensionType> context) {
		context.register(MARS_DIM_TYPE, new DimensionType(
				OptionalLong.of(12000), // fixedTime
				true, // hasSkylight
				false, // hasCeiling
				false, // ultraWarm
				true, // natural
				1.0, // coordinateScale
				true, // bedWorks
				false, // respawnAnchorWorks
				0, // minY
				128, // height
				128, // logicalHeight
				BlockTags.INFINIBURN_OVERWORLD, // infiniburn
				DimensionTypes.OVERWORLD_ID, // effectsLocation
				0.8f, // ambientLight
				new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 0)
		));
	}

}
