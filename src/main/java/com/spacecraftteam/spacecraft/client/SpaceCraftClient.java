package com.spacecraftteam.spacecraft.client;

import com.spacecraftteam.spacecraft.fluid.ModFluids;
import com.spacecraftteam.spacecraft.networking.ModMessages;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class SpaceCraftClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModMessages.registerS2CPackets();

		FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_CRUDE_OIL, ModFluids.FLOWING_CRUDE_OIL,
				new SimpleFluidRenderHandler(
						new Identifier("minecraft:block/water_still"),
						new Identifier("minecraft:block/water_flow"),
						0xF0410E0E
				));

		BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
				ModFluids.STILL_CRUDE_OIL, ModFluids.FLOWING_CRUDE_OIL);
	}
}
