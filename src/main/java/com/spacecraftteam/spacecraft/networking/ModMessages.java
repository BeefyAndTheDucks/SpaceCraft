package com.spacecraftteam.spacecraft.networking;

import com.spacecraftteam.spacecraft.SpaceCraft;
import com.spacecraftteam.spacecraft.networking.packet.C2S.TeleportToPlanetC2SPacket;
import com.spacecraftteam.spacecraft.networking.packet.S2C.OpenCreativeTeleporterS2CPacket;
import com.spacecraftteam.spacecraft.networking.packet.S2C.OpenSpacepediaS2CPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModMessages {

	public static final Identifier OPEN_SPACEPEDIA_ID = new Identifier(SpaceCraft.MOD_ID, "open_spacepedia");
	public static final Identifier OPEN_CREATIVE_TELEPORTER_ID = new Identifier(SpaceCraft.MOD_ID, "open_creative_teleporter");
	public static final Identifier TELEPORT_TO_PLANET_ID = new Identifier(SpaceCraft.MOD_ID, "teleport_to_planet");

	public static void registerC2SPackets() {
		ServerPlayNetworking.registerGlobalReceiver(TELEPORT_TO_PLANET_ID, TeleportToPlanetC2SPacket::receive);
	}

	public static void registerS2CPackets() {
		ClientPlayNetworking.registerGlobalReceiver(OPEN_SPACEPEDIA_ID, OpenSpacepediaS2CPacket::receive);
		ClientPlayNetworking.registerGlobalReceiver(OPEN_CREATIVE_TELEPORTER_ID, OpenCreativeTeleporterS2CPacket::receive);
	}

}
