package test.testerer;

import net.fabricmc.api.ModInitializer;

import test.testerer.block.ModBlockEntities;
import test.testerer.block.ModBlocks;

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
	}
}