package com.spacecraftteam.spacecraft.networking.packet.S2C;

import com.spacecraftteam.spacecraft.gui.CreativeTeleporterGui;
import com.spacecraftteam.spacecraft.gui.GuiUtil;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

public class OpenCreativeTeleporterS2CPacket {
	public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
							   PacketByteBuf buf, PacketSender responseSender) {
		client.execute(() -> {
			// Everything here happens only on the client
			GuiUtil.showClientGui(new CreativeTeleporterGui());
		});
	}
}
