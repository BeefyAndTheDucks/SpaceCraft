package com.spacecraftteam.spacecraft.util;

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

import java.util.OptionalLong;

public class PlanetDimension {
    public final RegistryKey<DimensionOptions> KEY;
    public final RegistryKey<World> LEVEL_KEY;
    public final RegistryKey<DimensionType> DIMENSION_TYPE;
    public final Identifier DIMENSION_ID;

    private final int SCALE;

    public PlanetDimension(String id, int scale) {
        DIMENSION_ID = new Identifier(SpaceCraft.MOD_ID, id);
        KEY = RegistryKey.of(RegistryKeys.DIMENSION, DIMENSION_ID);
        LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD, DIMENSION_ID);
        DIMENSION_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, new Identifier(SpaceCraft.MOD_ID, id + "_type"));
        SCALE = scale;
    }

    public void register(Registerable<DimensionType> context) {
        context.register(DIMENSION_TYPE, new DimensionType(
                OptionalLong.of(12000), // fixedTime
                true, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                true, // natural
                SCALE, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                0, // minY
                256, // height
                256, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                DIMENSION_ID, // effectsLocation
                0.8f, // ambientLight
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 0)
        ));
    }
}
