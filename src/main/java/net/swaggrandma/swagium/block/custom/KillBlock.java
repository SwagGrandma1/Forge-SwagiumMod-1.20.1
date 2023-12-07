package net.swaggrandma.swagium.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class KillBlock extends Block
{

    public KillBlock(Properties playerProperties) 
    {
        super(playerProperties);
    }
    //plevel means client or server, ppos is block position,
    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity)
    {
        pEntity.hurt(pLevel.damageSources().magic(), 10.0F);
        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
