package com.luckylucas.learningfabric;

import com.luckylucas.learningfabric.registry.KuiperiumBoostEffect;
import com.luckylucas.learningfabric.registry.KuiperiumToolMaterial;
import com.luckylucas.learningfabric.registry.ModBlocks;
import com.luckylucas.learningfabric.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LearningFabric implements ModInitializer {

    // creating a MOD_ID final that can be used anywhere else
    public static final String MOD_ID = "learningfabric";

    // Creating instances of custom content to register
    // Tool materials
    public static final KuiperiumToolMaterial KUIPERIUM_TOOL_MATERIAL = new KuiperiumToolMaterial();

    // Status effects
    // for some reason, it made me redo the constructor args here.
    public static final KuiperiumBoostEffect KUIPERIUM_BOOST = new KuiperiumBoostEffect(StatusEffectType.BENEFICIAL, 0x4dff6d);

    // creating a item group and creative tab
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "general"),
            () -> new ItemStack(ModItems.STABILIZED_KUIPERIUM)
    );

    @Override
    public void onInitialize() {
        // Register items and blocks
        ModItems.registerItems();
        ModBlocks.registerBlocks();

        // register status effects
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MOD_ID,"kuiperium_boost"), KUIPERIUM_BOOST);
    }
}
