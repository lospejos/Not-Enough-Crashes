package fudge.notenoughcrashes;

import fudge.notenoughcrashes.platform.NecPlatform;
import fudge.notenoughcrashes.utils.SystemExitBlock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NotEnoughCrashes {

    public static final Path DIRECTORY = NecPlatform.instance().getGameDirectory().resolve("not-enough-crashes");
    public static final String NAME = "Not Enough Crashes";
    public static final String MOD_ID = "notenoughcrashes";

    public static final Logger LOGGER = LogManager.getLogger(NAME);

    public static final boolean LOG_DEBUG = false;

    public static void logDebug(String message) {
        if (LOG_DEBUG) LOGGER.info(message);
    }

    private static final boolean DEBUG_ENTRYPOINT = false;
    public static final boolean FILTER_ENTRYPOINT_CATCHER = true;


    public static final boolean ENABLE_ENTRYPOINT_CATCHING = !NecPlatform.instance().isDevelopmentEnvironment() || DEBUG_ENTRYPOINT;

    public static void ensureDirectoryExists() throws IOException {
        Files.createDirectories(DIRECTORY);
    }

    public static void initialize() {
        if (NecConfig.instance().forceCrashScreen) SystemExitBlock.forbidSystemExitCall();
        NecConfig.instance();

        if (DEBUG_ENTRYPOINT) throw new NullPointerException();
//        TestKeyBinding.init();
    }


}
