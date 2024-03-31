package com.spacecraftteam.spacecraft.impl.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import net.minecraft.text.Text;

public class SpaceCraftModMenu implements ModMenuApi {
	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return screen -> new CottonClientScreen(Text.translatable("options.spacecraft.spacecraft_settings"), new SpaceCraftConfigGui(screen)) {
			@Override
			public void close() {
				this.client.setScreen(screen);
			}
		};
	}
}
