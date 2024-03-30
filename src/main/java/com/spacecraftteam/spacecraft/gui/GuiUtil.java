package com.spacecraftteam.spacecraft.gui;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import net.minecraft.client.MinecraftClient;

public class GuiUtil {
	public static void showClientGui(LightweightGuiDescription guiDescription) {
		MinecraftClient.getInstance().setScreen(new CottonClientScreen(guiDescription));
	}
}
