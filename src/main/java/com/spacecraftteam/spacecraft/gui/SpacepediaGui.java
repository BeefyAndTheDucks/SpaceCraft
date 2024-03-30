package com.spacecraftteam.spacecraft.gui;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.VerticalAlignment;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

public class SpacepediaGui extends LightweightGuiDescription {

	private static final int WINDOW_WIDTH = 256;
	private static final int WINDOW_HEIGHT = 256;

	private static final String[] PLANETS = {
			"mercury",
			"venus",
			"earth",
			"mars",
			"jupiter",
			"saturn",
			"uranus",
			"neptune"
	};

	public SpacepediaGui() {
		WPlainPanel root = new WPlainPanel();
		setRootPanel(root);
		root.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		WLabel label = new WLabel(Text.translatable("gui.spacecraft.spacepedia_title").formatted(Formatting.AQUA), 0xFFFFFF);
		label.setHorizontalAlignment(HorizontalAlignment.CENTER);
		label.setVerticalAlignment(VerticalAlignment.TOP);
		root.add(label, WINDOW_WIDTH / 2, 8, 0, 0);

		double radiansPerPlanet = Math.PI * 2 / PLANETS.length;

		for (int i = 0; i < PLANETS.length; i++) {
			String planet = PLANETS[i];

			int x = (int)((Math.sin(radiansPerPlanet * i) + 1) / 2 * (WINDOW_WIDTH - 96)) + 32;
			int y = (int)((Math.cos(radiansPerPlanet * i) + 1) / 2 * (WINDOW_HEIGHT - 96)) + 32;

			WSprite icon = new WSprite(new Identifier("spacecraft:textures/icons/" + planet + ".png"));
			root.add(icon, x, y, 32, 32);

			WLabel planetLabel = new WLabel(Text.translatable("planet.spacecraft." + planet).formatted(Formatting.YELLOW));
			planetLabel.setVerticalAlignment(VerticalAlignment.TOP);
			planetLabel.setHorizontalAlignment(HorizontalAlignment.CENTER);
			root.add(planetLabel, x + 16, y + 36, 0, 0);
		}

		WSprite sun = new WSprite(new Identifier("spacecraft:textures/icons/sun.png"));
		root.add(sun, (WINDOW_WIDTH / 2) - 24, (WINDOW_HEIGHT / 2) - 24, 48, 48);

		root.validate(this);
	}

	@Override
	public void addPainters() {
		if (this.rootPanel!=null) {
			this.rootPanel.setBackgroundPainter(BackgroundPainter.createColorful(0x000000));
		}
	}


}
