package com.spacecraftteam.spacecraft.gui;

import com.spacecraftteam.spacecraft.SpaceCraft;
import com.spacecraftteam.spacecraft.util.Universe;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.VerticalAlignment;
import net.fabricmc.fabric.api.util.TriState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

public class SpacepediaGui extends LightweightGuiDescription {

	private static final int WINDOW_WIDTH = 256;
	private static final int WINDOW_HEIGHT = 256;

	public SpacepediaGui() {
		WPlainPanel root = new WPlainPanel();
		setRootPanel(root);
		root.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		WLabel label = new WLabel(Text.translatable("gui.spacecraft.spacepedia_title").formatted(Formatting.AQUA), 0xFFFFFF);
		label.setHorizontalAlignment(HorizontalAlignment.CENTER);
		label.setVerticalAlignment(VerticalAlignment.TOP);
		root.add(label, WINDOW_WIDTH / 2, 8, 0, 0);

		double radiansPerPlanet = Math.PI * 2 / Universe.PLANETS.length;

		Universe.PlanetData currentPlanet = Universe.PlanetData.fromWorld(MinecraftClient.getInstance().world);

		for (int i = 0; i < Universe.PLANETS.length; i++) {
			Universe.PlanetData planet = Universe.PLANETS[i];

			int x = (int)((Math.sin(radiansPerPlanet * i) + 1) / 2 * (WINDOW_WIDTH - 96)) + 32;
			int y = (int)((Math.cos(radiansPerPlanet * i) + 1) / 2 * (WINDOW_HEIGHT - 96)) + 32;

			WSprite icon = new WSprite(planet.getImageIdentifier());
			root.add(icon, x, y, 32, 32);

			Formatting textCol = Formatting.YELLOW;

			if (planet == currentPlanet) {
				WSprite circle = new WSprite(new Identifier(SpaceCraft.MOD_ID, "textures/icons/current_planet.png"));
				root.add(circle, x, y, 32, 32);

				textCol = Formatting.GREEN;
			}

			WLabel planetLabel = new WLabel(planet.getUserFriendlyPlanetName().formatted(textCol));
			planetLabel.setVerticalAlignment(VerticalAlignment.TOP);
			planetLabel.setHorizontalAlignment(HorizontalAlignment.CENTER);
			root.add(planetLabel, x + 16, y + 36, 0, 0);
		}

		WSprite sun = new WSprite(new Identifier(SpaceCraft.MOD_ID, "textures/icons/sun.png"));
		root.add(sun, (WINDOW_WIDTH / 2) - 24, (WINDOW_HEIGHT / 2) - 24, 48, 48);

		WButton doneButton = new WButton(ScreenTexts.DONE);
		doneButton.setOnClick(()->{
			MinecraftClient.getInstance().setScreen(GuiUtil.getPreviousScreen());
		});
		root.add(doneButton, WINDOW_WIDTH - 54, WINDOW_HEIGHT - 26, 48, 24);

		root.validate(this);
	}

	@Override
	public TriState isDarkMode() {
		return TriState.TRUE;
	}
}
