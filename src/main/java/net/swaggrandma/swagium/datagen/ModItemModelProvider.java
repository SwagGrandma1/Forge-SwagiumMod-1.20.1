package net.swaggrandma.swagium.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.swaggrandma.swagium.Swagium;
import net.swaggrandma.swagium.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider
{

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Swagium.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        simpleItem(ModItems.RAW_SWAGIUM);
        simpleItem(ModItems.SWAGIUM_INGOT);
        simpleItem(ModItems.SWAGBERRY);
        simpleItem(ModItems.SWAGIUM_SAPLING);
        simpleItem(ModItems.METAL_DETECTOR);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Swagium.MOD_ID,"item/" + item.getId().getPath()));
    }
}
