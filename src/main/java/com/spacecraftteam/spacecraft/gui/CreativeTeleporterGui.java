package com.spacecraftteam.spacecraft.gui;

import com.spacecraftteam.spacecraft.SpaceCraft;
import com.spacecraftteam.spacecraft.networking.ModMessages;
import com.spacecraftteam.spacecraft.util.Universe;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import io.github.cottonmc.cotton.gui.widget.data.VerticalAlignment;
import io.github.cottonmc.cotton.gui.widget.icon.TextureIcon;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class CreativeTeleporterGui extends LightweightGuiDescription {
	public CreativeTeleporterGui() {
		WGridPanel root = new WGridPanel();
		root.setInsets(Insets.ROOT_PANEL);
		this.setRootPanel(root);
		int currY = 0;

		WLabel label = new WLabel(Text.translatable("gui.spacecraft.creative_teleporter_title").formatted(Formatting.AQUA), 0xFFFFFF);
		label.setHorizontalAlignment(HorizontalAlignment.CENTER);
		label.setVerticalAlignment(VerticalAlignment.TOP);
		root.add(label, 0, currY, 7, 1);

		Universe.PlanetData currentPlanet = Universe.PlanetData.fromWorld(MinecraftClient.getInstance().world);

		for (Universe.PlanetData planet : Universe.PLANETS) {
			WButton planetButton = new WButton(new TextureIcon(planet.getImageIdentifier()), planet.getUserFriendlyPlanetName());
			if (planet != currentPlanet) {
				planetButton.setOnClick(() -> {
					PacketByteBuf packetByteBuf = PacketByteBufs.create();
					packetByteBuf.writeString(planet.getPlanetName());
					ClientPlayNetworking.send(ModMessages.TELEPORT_TO_PLANET_ID, packetByteBuf);
				});
			}
			root.add(planetButton, 0, currY += 2, 5, 1);
		}

		currY++;

		WButton doneButton = new WButton(ScreenTexts.DONE);
		doneButton.setOnClick(() -> MinecraftClient.getInstance().setScreen(GuiUtil.getPreviousScreen()));
		root.add(doneButton, 0, currY += 2, 3, 1);

		root.validate(this);
	}
}
