package fudge.notenoughcrashes.platform;

import org.jetbrains.annotations.Nullable;

import java.nio.file.Path;
import java.util.List;

public interface NecPlatform {
    static NecPlatform instance() {
        return NecPlatformStorage.INSTANCE_SET_ONLY_BY_SPECIFIC_PLATFORMS_VERY_EARLY;
    }


    ModsByLocation getModsAtLocationsInDisk();

    Path getGameDirectory();

    Path getConfigDirectory();

    boolean isDevelopmentEnvironment();

    /**
     * Returns null if no such resource exists at resources/relativePath
     */
    @Nullable
    Path getResource(Path relativePath);

    /**
     * Get be multiple metadatas because forge supports having multiple mods under one jar
     */
    List<CommonModMetadata> getModMetadatas(String modId);

}
