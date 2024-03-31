package com.spacecraftteam.spacecraft.fluid;

import com.spacecraftteam.spacecraft.SpaceCraft;
import com.spacecraftteam.spacecraft.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
	public static final FlowableFluid STILL_CRUDE_OIL = registerFluid(new CrudeOilFluid.Still(), "crude_oil");
	public static final FlowableFluid FLOWING_CRUDE_OIL = registerFluid(new CrudeOilFluid.Flowing(), "flowing_crude_oil");
	public static final Block CRUDE_OIL_BLOCK = registerFluidBlock(STILL_CRUDE_OIL, "crude_oil_block");
	public static final Item CRUDE_OIL_BUCKET = registerBucketItem(STILL_CRUDE_OIL, "crude_oil_bucket", ModItemGroup.MAIN_GROUP);

	private static FlowableFluid registerFluid(FlowableFluid variant, String name) {
		return Registry.register(Registries.FLUID,
				new Identifier(SpaceCraft.MOD_ID, name), variant);
	}

	private static Block registerFluidBlock(FlowableFluid fluid, String name) {
			return Registry.register(Registries.BLOCK, new Identifier(SpaceCraft.MOD_ID, name),
					new FluidBlock(fluid, FabricBlockSettings.copyOf(Blocks.WATER)){ });
	}

	private static Item registerBucketItem(FlowableFluid fluid, String name, ItemGroup group) {
		BucketItem item = new BucketItem(fluid, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1));
		ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
		return Registry.register(Registries.ITEM, new Identifier(SpaceCraft.MOD_ID, name),
				item);
	}

	public static void register() {
		SpaceCraft.LOGGER.debug("Registering Fluids for " + SpaceCraft.MOD_ID);
	}
}
