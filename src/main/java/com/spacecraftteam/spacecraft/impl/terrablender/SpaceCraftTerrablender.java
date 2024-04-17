package com.spacecraftteam.spacecraft.impl.terrablender;

import com.spacecraftteam.spacecraft.SpaceCraft;
import com.spacecraftteam.spacecraft.world.biome.ModOverworldRegion;
import com.spacecraftteam.spacecraft.world.biome.surface.ModMaterialRules;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class SpaceCraftTerrablender implements TerraBlenderApi {
	@Override
	public void onTerraBlenderInitialized() {
		Regions.register(new ModOverworldRegion(new Identifier(SpaceCraft.MOD_ID, "overworld"), 4));

		//SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, SpaceCraft.MOD_ID, ModMaterialRules.makeRules());
	}
}
