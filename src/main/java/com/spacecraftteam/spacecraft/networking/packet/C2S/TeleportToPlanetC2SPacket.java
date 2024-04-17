package com.spacecraftteam.spacecraft.networking.packet.C2S;

import com.spacecraftteam.spacecraft.util.Universe;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class TeleportToPlanetC2SPacket {

	public static void receive(MinecraftServer server, ServerPlayerEntity player,
							   ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {

		String planetName = buf.readString();
		Universe.PlanetData planet = Universe.PlanetData.fromString(planetName);
		Universe.teleportEntityToPlanet(planet, player, server);
	}

}
