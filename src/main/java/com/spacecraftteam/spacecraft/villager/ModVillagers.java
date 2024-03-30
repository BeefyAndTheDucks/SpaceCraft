package com.spacecraftteam.spacecraft.villager;

import com.google.common.collect.ImmutableSet;
import com.spacecraftteam.spacecraft.SpaceCraft;
import com.spacecraftteam.spacecraft.block.ModBlocks;
import com.spacecraftteam.spacecraft.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {

	public static final PointOfInterestType ASTRONAUT_POI = registerPOI("astronaut_poi", ModBlocks.ASTRO_STATION);
	public static final VillagerProfession ASTRONAUT = registerProfession("astronaut", RegistryKey.of(Registries.POINT_OF_INTEREST_TYPE.getKey(), new Identifier(SpaceCraft.MOD_ID, "astronaut_poi")));

	public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
		return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(SpaceCraft.MOD_ID, name), VillagerProfessionBuilder.create().id(new Identifier(SpaceCraft.MOD_ID, name)).workstation(type)
						.workSound(SoundEvents.ENTITY_VILLAGER_WORK_TOOLSMITH).build());
	}

	public static PointOfInterestType registerPOI(String name, Block block) {
		return PointOfInterestHelper.register(new Identifier(SpaceCraft.MOD_ID, name),
				1, 1, ImmutableSet.copyOf(block.getStateManager().getStates()));
	}

	public static void registerVillagers() {
		SpaceCraft.LOGGER.debug("Registering Villagers for " + SpaceCraft.MOD_ID);
	}

	public static void registerTrades() {
		TradeOfferHelper.registerVillagerOffers(ASTRONAUT, 1,
				factories -> {
					factories.add((entity, random) -> new TradeOffer(
							new ItemStack(Items.EMERALD, 5),
							new ItemStack(ModItems.ALUMINUM, 1),
							6, 2, 0.02f
					));
				});
	}

}
