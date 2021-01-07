package com.luckylucas.learningfabric.registry;

import com.luckylucas.learningfabric.LearningFabric;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block KUIPERIUM_BLOCK = new Block(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .requiresTool()
            .strength(5.0f, 45.0f)
            .sounds(BlockSoundGroup.METAL)
            .luminance(1)
    );

    public static void registerBlocks(){
        Registry.register(Registry.BLOCK, new Identifier(LearningFabric.MOD_ID, "kuiperium_block"), KUIPERIUM_BLOCK);
    }
}
