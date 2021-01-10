package com.luckylucas.learningfabric.registry;

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

            playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 600,3,true,true));
        }
        else{
            playerEntity.playSound(SoundEvents.ENTITY_SHULKER_BULLET_HIT, 0.5F, 2F);
        }

        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
