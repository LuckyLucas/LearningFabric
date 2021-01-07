package com.luckylucas.learningfabric.registry;
import com.luckylucas.learningfabric.LearningFabric;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    // Actual Items
    public static final Item KUIPERIUM = new Item(new Item.Settings().group(LearningFabric.ITEM_GROUP));

    // Block Items
    public static final BlockItem KUIPERIUM_BLOCK = new BlockItem(ModBlocks.KUIPERIUM_BLOCK, new Item.Settings().group(LearningFabric.ITEM_GROUP));
    public static final BlockItem KUIPERIUM_ORE = new BlockItem(ModBlocks.KUIPERIUM_ORE, new Item.Settings().group(LearningFabric.ITEM_GROUP));

    public static void registerItems(){
        // Items
        Registry.register(Registry.ITEM, new Identifier(LearningFabric.MOD_ID, "kuiperium"), KUIPERIUM);

        // Block Items
        Registry.register(Registry.ITEM, new Identifier(LearningFabric.MOD_ID, "kuiperium_block"), KUIPERIUM_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(LearningFabric.MOD_ID, "kuiperium_ore"), KUIPERIUM_ORE);
    }
}
