package net.swaggrandma.swagium.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.swaggrandma.swagium.Swagium;
import net.swaggrandma.swagium.block.ModBlocks;
import net.swaggrandma.swagium.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider
{

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, Swagium.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider)
    {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.SWAGIUM_ORE.get()).addTag(Tags.Blocks.ORES)
                .add(ModBlocks.DEEPSLATE_SWAGIUM_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.KILL_BLOCK.get())
                .add(ModBlocks.BLOCK_OF_SWAGIUM.get())
                .add(ModBlocks.SWAGIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_SWAGIUM_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE);

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL);

        this.tag(BlockTags.MINEABLE_WITH_HOE);

        this.tag(BlockTags.NEEDS_STONE_TOOL);

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BLOCK_OF_SWAGIUM.get())
                .add(ModBlocks.SWAGIUM_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DEEPSLATE_SWAGIUM_ORE.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);

        this.tag(ModTags.Blocks.NEEDS_SWAGIUM_TOOL)
                .add(ModBlocks.KILL_BLOCK.get());
    }
}
