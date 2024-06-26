package com.spacecraftteam.spacecraft.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EnergeticHealerBlock extends Block {
	public EnergeticHealerBlock(Settings settings) {
		super(settings);
	}

	@Override
	public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
		// TODO: Consume energy

		if (entity instanceof LivingEntity livingEntity) {
			livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100));
		}

		super.onSteppedOn(world, pos, state, entity);
	}
}
