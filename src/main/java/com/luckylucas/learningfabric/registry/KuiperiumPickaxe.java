package com.luckylucas.learningfabric.registry;

import com.luckylucas.learningfabric.LearningFabric;
import draylar.magna.api.BlockBreaker;
import draylar.magna.api.BlockProcessor;
import draylar.magna.api.BreakValidator;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class KuiperiumPickaxe extends PickaxeItem {


    public KuiperiumPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        // set up the itemstack for the item, itemstacks are required to actually interact
        // with items in the inventory. In this case, it's a stack of one pickaxe in the player's hand
        ItemStack itemStack = playerEntity.getStackInHand(hand);

        // Check if there is at least 50 durability left, consume 10 durability and do something cool
        if(itemStack.getDamage() < getMaterial().getDurability()-50){
            // consume the 10 durability and play a lightning sound
            itemStack.setDamage(itemStack.getDamage()+50);
            playerEntity.playSound(SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, 0.5F, 2F);

            // add the kuiperium status effect to the player
            playerEntity.addStatusEffect(new StatusEffectInstance(LearningFabric.KUIPERIUM_BOOST, 600,0,true,true));
        }
        else{
            // Play a different sound when the player can't activate the ability
            playerEntity.playSound(SoundEvents.ENTITY_SHULKER_BULLET_HIT, 0.5F, 2F);
        }

        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

    // The Kuiperium Boost effect makes the pickaxe dig about 3 blocks
    // ahead in a straight line. It wasn't intentional but it's rad so it's staying.


    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if(miner instanceof PlayerEntity){
            if(miner.hasStatusEffect(LearningFabric.KUIPERIUM_BOOST)){
                BlockBreaker.breakInRadius(world, (PlayerEntity) miner, 0, new BreakValidator() {
                    @Override
                    // This code was taken from the MagnaTool example file in the Magna library
                    // I realize now that it may have been easier to use the pick as a magna tool rather than as a pickaxe,
                    // and do all this nonsense, but oh well.
                    public boolean canBreak(BlockView blockView, BlockPos blockPos) {
                        BlockState blockState = blockView.getBlockState(blockPos);

                        if (blockState.getHardness(blockView, blockPos) == -1.0) {
                            return false;
                        }

                        if (stack.isEffectiveOn(blockState)) {
                            return true;
                        }

                        if (blockState.isToolRequired()) {
                            return false;
                        }

                        return stack.getMiningSpeedMultiplier(blockState) > 1.0F;
                    }
                }, new BlockProcessor() {
                    @Override
                    public ItemStack process(ItemStack itemStack, ItemStack itemStack1) {
                        return itemStack1;
                    }
                }, true);
            }
        }

        return super.postMine(stack, world, state, pos, miner);
    }
}
