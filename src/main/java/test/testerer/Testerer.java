package test.testerer;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;
import org.jetbrains.annotations.NotNull;
import test.testerer.block.ModBlockEntities;
import test.testerer.block.ModBlocks;
import test.testerer.item.ModItems;

public class Testerer implements ModInitializer {
	public static final String MOD_ID = "testerer";

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModLogger.LOGGER.info("Hello Fabric world!");
		ModLogger.LOGGER.warn("Hohonohonhon");

        ModBlockEntities.initialise();
		ModBlocks.initialise();
		ModItems.initialise();
	}

    public static @NotNull Identifier id(@NotNull String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}