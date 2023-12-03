package net.swaggrandma.swagium.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.swaggrandma.swagium.Swagium;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Swagium.MOD_ID);

    public static final RegistryObject<Item> SWAGIUM = ITEMS.register("swagium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SWAGIUM = ITEMS.register("raw_swagium", () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
