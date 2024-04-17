package com.spacecraftteam.spacecraft.util;

import com.spacecraftteam.spacecraft.SpaceCraft;
import com.spacecraftteam.spacecraft.world.dimension.ModDimensions;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Universe {
	public static final PlanetData MERCURY = new PlanetData("mercury", ServerWorld.OVERWORLD);
	public static final PlanetData VENUS = new PlanetData("venus", ServerWorld.OVERWORLD);
	public static final PlanetData EARTH = new PlanetData("earth", ServerWorld.OVERWORLD);
	public static final PlanetData MARS = new PlanetData("mars", ModDimensions.MARS_LEVEL_KEY);
	public static final PlanetData JUPITER = new PlanetData("jupiter", ServerWorld.OVERWORLD);
	public static final PlanetData SATURN = new PlanetData("saturn", ServerWorld.OVERWORLD);
	public static final PlanetData URANUS = new PlanetData("uranus", ServerWorld.OVERWORLD);
	public static final PlanetData NEPTUNE = new PlanetData("neptune", ServerWorld.OVERWORLD);
	public static final PlanetData NETHER = new PlanetData("nether", ServerWorld.NETHER);
	public static final PlanetData END = new PlanetData("end", ServerWorld.END);

	public static final PlanetData[] PLANETS = {
			MERCURY,
			VENUS,
			EARTH,
			MARS,
			JUPITER,
			SATURN,
			URANUS,
			NEPTUNE,
			NETHER,
			END
	};

	public static void teleportEntityToPlanet(PlanetData planet, ServerPlayerEntity target, MinecraftServer server) {
		ServerWorld world = planet.getPlanetDimension(server);
		BlockPos spawnPointPosition = target.getSpawnPointPosition();
		if (spawnPointPosition == null) {
			spawnPointPosition = world.getSpawnPos();
		}

		target.teleport(world, spawnPointPosition.getX(), spawnPointPosition.getY(), spawnPointPosition.getZ(), 0, 0);
	}
	
	public static class PlanetData {
		private final String planetName;
		private final MutableText userFriendlyPlanetName;
		private final Identifier imageIdentifier;
		private final RegistryKey<World> planetDimensionRegistryKey;
		
		public PlanetData(String name, RegistryKey<World> dimension) {
			planetName = name;
			userFriendlyPlanetName = Text.translatable("planet.spacecraft." + name);
			imageIdentifier = new Identifier(SpaceCraft.MOD_ID, "textures/icons/" + name + ".png");
			planetDimensionRegistryKey = dimension;
		}

		public PlanetData(String name, RegistryKey<World> dimension, MutableText userFriendlyPlanetNameOverride) {
			planetName = name;
			userFriendlyPlanetName = userFriendlyPlanetNameOverride;
			imageIdentifier = new Identifier(SpaceCraft.MOD_ID, "textures/icons/" + name + ".png");
			planetDimensionRegistryKey = dimension;
		}
		
		public String getPlanetName() {
			return planetName;
		}
		
		public Identifier getImageIdentifier() {
			return imageIdentifier;
		}

		public MutableText getUserFriendlyPlanetName() {
			return userFriendlyPlanetName;
		}

		public RegistryKey<World> getPlanetDimensionRegistryKey() {
			return planetDimensionRegistryKey;
		}

		public ServerWorld getPlanetDimension(MinecraftServer server) {
			return server.getWorld(planetDimensionRegistryKey);
		}

		public static PlanetData fromString(String str) {
			for (PlanetData data : Universe.PLANETS) {
				if (data.getPlanetName().equalsIgnoreCase(str)) {
					return data;
				}
			}

			throw new NoSuchElementException();
		}

		public static PlanetData fromWorld(World world) {
			Identifier worldIdentifier = world.getRegistryKey().getValue();
			for (PlanetData data : Universe.PLANETS) {
				if (data.getPlanetDimensionRegistryKey().getValue().equals(worldIdentifier)) {
					return data;
				}
			}

			throw new NoSuchElementException();
		}
	}
}
