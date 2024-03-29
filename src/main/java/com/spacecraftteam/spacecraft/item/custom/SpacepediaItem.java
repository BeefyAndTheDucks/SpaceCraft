package com.spacecraftteam.spacecraft.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

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

	private void outputSpacepedia(PlayerEntity player) {
		// TODO: Make this show a GUI instead of a chat message

		player.sendMessage(Text.literal(
				"Planets:\n" +
				"   Mercury\n" +
				"   Venus\n" +
				"   Earth\n" +
				"   Mars\n" +
				"   Jupiter\n" +
				"   Saturn\n" +
				"   Uranus\n" +
				"   Neptune"));
	}
}
