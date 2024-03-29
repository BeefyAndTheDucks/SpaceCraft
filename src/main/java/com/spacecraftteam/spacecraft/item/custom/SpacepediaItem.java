package com.spacecraftteam.spacecraft.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SpacepediaItem extends Item {
	public SpacepediaItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		if(!world.isClient() && hand == Hand.MAIN_HAND) {
			// Output the spacepedia
			outputSpacepedia(user);

			// Add cooldown
			user.getItemCooldownManager().set(this, 20);
		}

		return super.use(world, user, hand);
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		if (Screen.hasShiftDown()) {
			tooltip.add(Text.literal("Right Click to open the Spacepedia").formatted(Formatting.AQUA));
		} else {
			tooltip.add(Text.literal("Press Shift for more info!").formatted(Formatting.YELLOW));
		}

		super.appendTooltip(stack, world, tooltip, context);
	}

	private void outputSpacepedia(PlayerEntity player) {
		// TODO: Make this show a GUI instead of a chat message (LibGui)

		player.sendMessage(Text.literal(
				"Planets:\n" +
				"   Mercury\n" +
				"   Venus\n" +
				"-> Earth\n" +
				"   Mars\n" +
				"   Jupiter\n" +
				"   Saturn\n" +
				"   Uranus\n" +
				"   Neptune"));
	}
}
