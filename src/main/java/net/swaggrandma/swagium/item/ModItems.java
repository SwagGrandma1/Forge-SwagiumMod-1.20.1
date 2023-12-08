package net.swaggrandma.swagium.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.swaggrandma.swagium.Swagium;
import net.swaggrandma.swagium.item.custom.FuelItem;
import net.swaggrandma.swagium.item.custom.MetalDetectorItem;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Swagium.MOD_ID);

    //items
    public static final RegistryObject<Item> SWAGIUM_INGOT = ITEMS.register("swagium_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SWAGIUM = ITEMS.register("raw_swagium", () -> new Item(new Item.Properties()));
    //fuel items
    public static final RegistryObject<Item> SWAGIUM_SAPLING = ITEMS.register("swagium_sapling", () -> new FuelItem(new Item.Properties(), 20));

    //food items
    public static final RegistryObject<Item> SWAGBERRY = ITEMS.register("swagberry", () -> new Item(new Item.Properties().food(ModFoods.SWAGBERRY)));

    //advanced items
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> SWAGIUM_PICKAXE = ITEMS.register("swagium_pickaxe", () -> new PickaxeItem(ModToolTiers.SWAGIUM,
            4, 5, new Item.Properties()));


    //end
    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
