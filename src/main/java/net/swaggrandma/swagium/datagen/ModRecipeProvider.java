package net.swaggrandma.swagium.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.swaggrandma.swagium.Swagium;
import net.swaggrandma.swagium.block.ModBlocks;
import net.swaggrandma.swagium.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    private static final List<ItemLike> SWAGIUM_SMELTABLES = List.of(ModItems.RAW_SWAGIUM.get(),
            ModBlocks.SWAGIUM_ORE.get(),
            ModBlocks.DEEPSLATE_SWAGIUM_ORE.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter)
    {
        oreBlasting(pWriter, SWAGIUM_SMELTABLES, RecipeCategory.MISC, ModItems.SWAGIUM_INGOT.get(), 0.25f, 100, "swagium");
        oreSmelting(pWriter, SWAGIUM_SMELTABLES, RecipeCategory.MISC, ModItems.SWAGIUM_INGOT.get(), 0.25f, 200, "swagium");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOCK_OF_SWAGIUM.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SWAGIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.SWAGIUM_INGOT.get()), has(ModItems.SWAGIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.METAL_DETECTOR.get())
                .pattern("  I")
                .pattern(" SC")
                .pattern("S  ")
                .define('S', Items.STICK)
                .define('I', Items.IRON_INGOT)
                .define('C', Items.COMPASS)
                .unlockedBy(getHasName(Items.COMPASS), has(Items.COMPASS))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.KILL_BLOCK.get())
                .pattern("SDS")
                .pattern("DRD")
                .pattern("SDS")
                .define('S', ModBlocks.BLOCK_OF_SWAGIUM.get())
                .define('D', Items.DIAMOND_SWORD)
                .define('R', Items.REDSTONE_BLOCK)
                .unlockedBy(getHasName(ModBlocks.BLOCK_OF_SWAGIUM.get()), has(ModBlocks.BLOCK_OF_SWAGIUM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SWAGIUM_PICKAXE.get())
                .pattern("SSS")
                .pattern(" s ")
                .pattern(" s ")
                .define('S', ModItems.SWAGIUM_INGOT.get())
                .define('s', Items.STICK)
                .unlockedBy(getHasName(ModItems.SWAGIUM_INGOT.get()), has(ModItems.SWAGIUM_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SWAGIUM_INGOT.get(), 9)
                .requires(ModBlocks.BLOCK_OF_SWAGIUM.get())
                .unlockedBy(getHasName(ModBlocks.BLOCK_OF_SWAGIUM.get()), has(ModBlocks.BLOCK_OF_SWAGIUM.get()))
                .save(pWriter);

    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, Swagium.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
