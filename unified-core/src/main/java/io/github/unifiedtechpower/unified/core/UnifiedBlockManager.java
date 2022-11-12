package io.github.unifiedtechpower.unified.core;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class UnifiedBlockManager {
    
    private static final UnifiedBlockManager INSTANCE = new UnifiedBlockManager();
    
    private final List<UnifiedBlockListener> listeners = new ArrayList<>();
    
    private UnifiedBlockManager() {
    }
    
    /**
     * Retrieves the {@link UnifiedBlockManager} instance.
     * @return The {@link UnifiedBlockManager} instance.
     */
    public static UnifiedBlockManager getInstance() {
        return INSTANCE;
    }
    
    /**
     * Registers a new {@link UnifiedBlockListener}
     * @param listener The {@link UnifiedBlockListener} to register
     */
    public void registerBlockListener(UnifiedBlockListener listener) {
        listeners.add(listener);
    }
    
    /**
     * Invokes {@link UnifiedBlockListener#handleBlockPlaced(Location)} for all registered {@link UnifiedBlockListener listeners}.
     * @param location The {@link Location} of the placed block
     * @param ignored A {@link UnifiedBlockListener} that should not be called. Can be null.
     */
    public void callBlockPlaced(@NotNull Location location, @Nullable UnifiedBlockListener ignored) {
        for (var listener : listeners) {
            if (listener == ignored)
                continue;
            
            listener.handleBlockPlaced(location);
        }
    }
    
    /**
     * Invokes {@link UnifiedBlockListener#handleBlockDestroyed(Location)} for all registered {@link UnifiedBlockListener listeners}.
     * @param location The {@link Location} of the destroyed block
     * @param ignored A {@link UnifiedBlockListener} that should not be called. Can be null.
     */
    public void callBlockDestroyed(@NotNull Location location, @Nullable UnifiedBlockListener ignored) {
        for (var listener : listeners) {
            if (listener == ignored)
                continue;
            
            listener.handleBlockDestroyed(location);
        }
    }
    
}
