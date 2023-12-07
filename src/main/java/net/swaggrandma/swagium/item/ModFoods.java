package net.swaggrandma.swagium.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods
{
    public static final FoodProperties SWAGBERRY = new FoodProperties.Builder().nutrition(2).fast().saturationMod(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 200), 0.1f).build();
}
