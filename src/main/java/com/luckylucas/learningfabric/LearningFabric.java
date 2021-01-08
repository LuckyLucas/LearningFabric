package com.luckylucas.learningfabric;

import com.luckylucas.learningfabric.registry.KuiperiumToolMaterial;
import com.luckylucas.learningfabric.registry.ModBlocks;
import com.luckylucas.learningfabric.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class LearningFabric implements ModInitializer {

    // creating a MOD_ID final that can be used anywhere else
    public static final String MOD_ID = "learningfabric";

    // Tool materials
    public static final KuiperiumToolMaterial KUIPERIUM_TOOL_MATERIAL = new KuiperiumToolMaterial();


    // creating a item group and creative tab
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "general"),
            () -> new ItemStack(ModItems.STABILIZED_KUIPERIUM)
    );

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
    }
}
