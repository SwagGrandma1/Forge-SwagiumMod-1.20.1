package net.swaggrandma.swagium.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.swaggrandma.swagium.Swagium;
import net.swaggrandma.swagium.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider
{
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper)
    {
        super(output, Swagium.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        BlockWithItem(ModBlocks.BLOCK_OF_SWAGIUM);
        BlockWithItem(ModBlocks.SWAGIUM_ORE);
        BlockWithItem(ModBlocks.DEEPSLATE_SWAGIUM_ORE);
        BlockWithItem(ModBlocks.KILL_BLOCK);
    }

    private void BlockWithItem(RegistryObject<Block> blockRegistryObject)
    {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}
