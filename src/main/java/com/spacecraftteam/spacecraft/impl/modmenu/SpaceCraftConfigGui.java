package com.spacecraftteam.spacecraft.impl.modmenu;

import com.spacecraftteam.spacecraft.SpaceCraft;
import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.fabricmc.fabric.api.util.TriState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.util.Identifier;

public class SpaceCraftConfigGui extends LightweightGuiDescription {
	public SpaceCraftConfigGui(Screen previous) {
		WGridPanel root = new WGridPanel(20);
		root.setInsets(Insets.ROOT_PANEL);
		setRootPanel(root);

		root.add(new WSprite(new Identifier(SpaceCraft.MOD_ID, "textures/icons/icon.png")), 5, 3);

		WButton doneButton = new WButton(ScreenTexts.DONE);
		doneButton.setOnClick(()->{
			MinecraftClient.getInstance().setScreen(previous);
		});
		root.add(doneButton, 0, 3, 3, 1);

		root.setBackgroundPainter(BackgroundPainter.VANILLA);

		root.validate(this);
	}

	@Override
	public TriState isDarkMode() {
		return TriState.TRUE;
	}
}
