package com.spacecraftteam.spacecraft.world.dimension;

import com.spacecraftteam.spacecraft.SpaceCraft;
import com.spacecraftteam.spacecraft.util.PlanetDimension;
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

	public static final PlanetDimension MERCURY = new PlanetDimension("mercury", 1);
	public static final PlanetDimension VENUS = new PlanetDimension("venus", 1);
	public static final PlanetDimension MARS = new PlanetDimension("mars", 1);
	public static final PlanetDimension JUPITER = new PlanetDimension("jupiter", 1);
	public static final PlanetDimension SATURN = new PlanetDimension("saturn", 1);
	public static final PlanetDimension URANUS = new PlanetDimension("uranus", 1);
	public static final PlanetDimension NEPTUNE = new PlanetDimension("neptune", 1);

	public static final PlanetDimension[] PLANETS = new PlanetDimension[] {
			MERCURY,
			VENUS,
			MARS,
			JUPITER,
			SATURN,
			URANUS,
			NEPTUNE
	};

	public static void bootstrapType(Registerable<DimensionType> context) {
		for (PlanetDimension planet : PLANETS) {
			planet.register(context);
		}
	}

}
