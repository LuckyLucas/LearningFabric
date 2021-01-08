package com.luckylucas.learningfabric.registry;
import com.luckylucas.learningfabric.LearningFabric;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    // Items
    public static final Item KUIPERIUM = new Item(new Item.Settings().group(LearningFabric.ITEM_GROUP));
    public static final Item STABILIZED_KUIPERIUM = new Item(new Item.Settings().group(LearningFabric.ITEM_GROUP));

    // Tool Items
    public static final ToolItem KUIPERIUM_PICKAXE = new KuiperiumPickaxe(LearningFabric.KUIPERIUM_TOOL_MATERIAL, -1,-2.8f, new Item.Settings().group(LearningFabric.ITEM_GROUP));

    // Block Items
    public static final BlockItem KUIPERIUM_BLOCK = new BlockItem(ModBlocks.KUIPERIUM_BLOCK, new Item.Settings().group(LearningFabric.ITEM_GROUP));
    public static final BlockItem KUIPERIUM_ORE = new BlockItem(ModBlocks.KUIPERIUM_ORE, new Item.Settings().group(LearningFabric.ITEM_GROUP));

    public static void registerItems(){
        // Items
        Registry.register(Registry.ITEM, new Identifier(LearningFabric.MOD_ID, "kuiperium"), KUIPERIUM);
        Registry.register(Registry.ITEM, new Identifier(LearningFabric.MOD_ID, "stabilized_kuiperium"), STABILIZED_KUIPERIUM);

        // Tool Items
        Registry.register(Registry.ITEM, new Identifier(LearningFabric.MOD_ID, "kuiperium_pickaxe"), KUIPERIUM_PICKAXE);

        // Block Items
        Registry.register(Registry.ITEM, new Identifier(LearningFabric.MOD_ID, "kuiperium_block"), KUIPERIUM_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(LearningFabric.MOD_ID, "kuiperium_ore"), KUIPERIUM_ORE);
    }
}
