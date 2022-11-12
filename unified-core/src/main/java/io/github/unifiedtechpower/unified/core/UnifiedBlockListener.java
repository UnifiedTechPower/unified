package io.github.unifiedtechpower.unified.core;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

public interface UnifiedBlockListener {
    
    /**
     * Called when a custom block of a plugin with "unified" integration was placed.
     * @param location The {@link Location} of the block
     */
    void handleBlockPlaced(@NotNull Location location);
    
    /**
     * Called when a custom block of a plugin with "unified" integration was destroyed.
     * @param location The {@link Location} of the block
     */
    void handleBlockDestroyed(@NotNull Location location);
    
}
