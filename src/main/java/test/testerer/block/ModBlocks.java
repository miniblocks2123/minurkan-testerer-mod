package test.testerer.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import test.testerer.ModLogger;
import test.testerer.Testerer;
import test.testerer.block.custom.C4Block;

import java.util.function.Function;

// Ok so whats this

public class ModBlocks {
    // now, just do
    public static final Block TESTERER_BLOCK_YAY = register("testerer_block_yay", Block::new, BlockBehaviour.Properties.of().sound(SoundType.AMETHYST), true);
    public static final C4Block C4 = (C4Block) register("c4", C4Block::new, BlockBehaviour.Properties.of().sound(SoundType.CHAIN), true);

    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.setId(blockKey));

        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);
            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Testerer.MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Testerer.MOD_ID, name));
    }

    public static void initialise() {
        ModLogger.devLogger("loading mod blocks");
        // just load the class
        // this function does nothing, it just loads all the variables, so they get registered
        // (its initialised in Testerer.java) (onInitialize)
    }

    // Is there a base model we can inherit
    // nothing, we just need a model too
    // yes, check this for more info https://docs.fabricmc.net/develop/blocks/first-block#models-and-textures
}

