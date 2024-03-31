package com.spacecraftteam.spacecraft.gui;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;

public class GuiUtil {
	private static Screen previousScreen;

	public static void showClientGui(LightweightGuiDescription guiDescription) {
		previousScreen = MinecraftClient.getInstance().currentScreen;
		MinecraftClient.getInstance().setScreen(new CottonClientScreen(guiDescription));
	}

	public static Screen getPreviousScreen() {
		return previousScreen;
	}
}
