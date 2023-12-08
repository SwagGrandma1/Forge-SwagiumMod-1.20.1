package net.swaggrandma.swagium.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.swaggrandma.swagium.Swagium;
import net.swaggrandma.swagium.block.ModBlocks;

public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Swagium.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SWAGIUM_TAB = CREATIVE_MODE_TABS.register("swagium_tab",
            () -> CreativeModeTab.builder().icon( () -> new ItemStack(ModItems.RAW_SWAGIUM.get()))
                    .title(Component.translatable("creativetab.swagium_tab"))
                    .displayItems((pParameters, pOutput) ->
                    {
                        pOutput.accept(ModItems.SWAGIUM_INGOT.get());
                        pOutput.accept(ModItems.RAW_SWAGIUM.get());
                        pOutput.accept(ModItems.METAL_DETECTOR.get());
                        pOutput.accept(ModItems.SWAGBERRY.get());
                        pOutput.accept(ModItems.SWAGIUM_SAPLING.get());
                        pOutput.accept(ModItems.SWAGIUM_PICKAXE.get());

                        pOutput.accept(ModBlocks.BLOCK_OF_SWAGIUM.get());
                        pOutput.accept(ModBlocks.KILL_BLOCK.get());
                        pOutput.accept(ModBlocks.SWAGIUM_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_SWAGIUM_ORE.get());
                    }).build());
    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
