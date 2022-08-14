package io.github.unifiedtechpower.unified.energy.manager;

import io.github.unifiedtechpower.unified.energy.storage.EnergyStorage;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Interface to get {@link EnergyStorage} instances from a location.
 */
public interface EnergyNetworkManager {
    
    /**
     * Gets the {@link EnergyStorage} at the given location.
     *
     * @param location the location to get the {@link EnergyStorage} from
     * @return the {@link EnergyStorage} at the given location
     */
    @Nullable
    EnergyStorage getEnergyStorageAt(@NotNull Location location);
    
}
