package net.swaggrandma.swagium.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.swaggrandma.swagium.block.ModBlocks;
import net.swaggrandma.swagium.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider
{

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate()
    {
        this.dropSelf(ModBlocks.KILL_BLOCK.get());
        this.dropSelf(ModBlocks.BLOCK_OF_SWAGIUM.get());
        this.dropSelf(ModBlocks.KILL_BLOCK.get());

        this.add(ModBlocks.SWAGIUM_ORE.get(), block -> createOreDrop(ModBlocks.SWAGIUM_ORE.get(), ModItems.RAW_SWAGIUM.get()));
        this.add(ModBlocks.DEEPSLATE_SWAGIUM_ORE.get(), block -> createOreDrop(ModBlocks.DEEPSLATE_SWAGIUM_ORE.get(), ModItems.RAW_SWAGIUM.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
