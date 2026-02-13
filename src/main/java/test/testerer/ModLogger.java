package test.testerer;

import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModLogger {
    public static final Logger LOGGER = LoggerFactory.getLogger(Testerer.MOD_ID);

    /**
     * this only does an info, if you need to warn or error, use the regular {@link ModLogger#LOGGER}
     * @param loggerInput what to log
     */
    public static void devLogger(String loggerInput) {
        if (!FabricLoader.getInstance().isDevelopmentEnvironment()) {
            return;
        }

        LOGGER.info("DEV - [ {} ]", loggerInput);
    }
}
