package com.spacecraftteam.spacecraft.networking;

import com.spacecraftteam.spacecraft.SpaceCraft;
import com.spacecraftteam.spacecraft.networking.packet.OpenSpacepediaS2CPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;

public class ModMessages {

	public static final Identifier OPEN_SPACEPEDIA_ID = new Identifier(SpaceCraft.MOD_ID, "open_spacepedia");

	public static void registerC2SPackets() {

	}

	public static void registerS2CPackets() {
		ClientPlayNetworking.registerGlobalReceiver(OPEN_SPACEPEDIA_ID, OpenSpacepediaS2CPacket::receive);
	}

}
