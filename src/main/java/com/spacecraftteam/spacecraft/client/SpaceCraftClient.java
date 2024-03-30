package com.spacecraftteam.spacecraft.client;

import com.spacecraftteam.spacecraft.networking.ModMessages;
import net.fabricmc.api.ClientModInitializer;

public class SpaceCraftClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModMessages.registerS2CPackets();
	}
}
