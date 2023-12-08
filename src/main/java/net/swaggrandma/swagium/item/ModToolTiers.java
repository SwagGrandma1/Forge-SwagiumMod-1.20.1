package net.swaggrandma.swagium.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.swaggrandma.swagium.Swagium;
import net.swaggrandma.swagium.util.ModTags;

import java.util.List;

public class ModToolTiers
{
    public static final Tier SWAGIUM = TierSortingRegistry.registerTier(
                    new ForgeTier(5, 1500, 5f, 4f, 25, ModTags.Blocks.NEEDS_SWAGIUM_TOOL,
                            () -> Ingredient.of(ModItems.SWAGIUM_INGOT.get())),
                    new ResourceLocation(Swagium.MOD_ID, "swagium_ingot"), List.of(Tiers.NETHERITE), List.of());

}
