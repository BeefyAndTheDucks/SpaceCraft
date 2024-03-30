package com.spacecraftteam.spacecraft.painting;

import com.spacecraftteam.spacecraft.SpaceCraft;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPaintings {

	public static final PaintingVariant ROCKET = registerPainting("rocket", new PaintingVariant(16, 32));

	private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
		return Registry.register(Registries.PAINTING_VARIANT, new Identifier(SpaceCraft.MOD_ID, name), paintingVariant);
	}

	public static void registerPaintings() {
		SpaceCraft.LOGGER.debug("Registering Paintings for " + SpaceCraft.MOD_ID);
	}

}
