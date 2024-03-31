package com.spacecraftteam.spacecraft;

import com.spacecraftteam.spacecraft.block.ModBlocks;
import com.spacecraftteam.spacecraft.item.ModItems;
import com.spacecraftteam.spacecraft.networking.ModMessages;
import com.spacecraftteam.spacecraft.painting.ModPaintings;
import com.spacecraftteam.spacecraft.util.StringUtil;
import com.spacecraftteam.spacecraft.villager.ModVillagers;
import com.spacecraftteam.spacecraft.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpaceCraft implements ModInitializer {
	public static final String MOD_ID = "spacecraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(StringUtil.uppercaseFirstLetter(MOD_ID));

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();

		ModPaintings.registerPaintings();
		ModWorldGen.generateWorldGen();

		ModMessages.registerC2SPackets();
	}
}
