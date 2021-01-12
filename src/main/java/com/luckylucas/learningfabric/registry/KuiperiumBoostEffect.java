package com.luckylucas.learningfabric.registry;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvents;

public class KuiperiumBoostEffect extends StatusEffect {
    public KuiperiumBoostEffect(StatusEffectType type, int color) {
        // the super constructor has you pick if the effect is harmful or beneficial
        // it also asks for the color in a hex value. in our case, lime green
        super(StatusEffectType.BENEFICIAL, 0x4dff6d);
    }

    // This method is called every tick to check weather it should apply the status effect or not
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }

    // This method is called when it applies the status effect. We implement custom functionality here.
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            entity.setAbsorptionAmount(4F);
        }
    }

}
