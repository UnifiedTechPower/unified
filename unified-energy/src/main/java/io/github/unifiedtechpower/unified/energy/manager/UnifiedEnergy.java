package io.github.unifiedtechpower.unified.energy.manager;

import io.github.unifiedtechpower.unified.energy.storage.EnergyStorage;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;

/**
 * Manager for different {@link EnergyNetworkManager} implementations.
 */
public class UnifiedEnergy {
    
    private static final UnifiedEnergy INSTANCE = new UnifiedEnergy();
    
    private UnifiedEnergy() {
    }
    
    private final HashSet<EnergyNetworkManager> managers = new HashSet<>();
    
    /**
     * Adds a {@link EnergyNetworkManager} to the set of managers.
     *
     * @param manager the {@link EnergyNetworkManager} to add
     * @return true if the manager was added, false if it was already in the set
     */
    public boolean addManager(@NotNull EnergyNetworkManager manager) {
        return managers.add(manager);
    }
    
    /**
     * Gets the {@link EnergyStorage} at the given location.
     *
     * @param location the location to get the {@link EnergyStorage} from
     * @return the {@link EnergyStorage} at the given location or null if none is found
     */
    @Nullable
    public EnergyStorage getEnergyStorageAt(@NotNull Location location) {
        for (EnergyNetworkManager manager : managers) {
            EnergyStorage storage = manager.getEnergyStorageAt(location);
            if (storage != null)
                return storage;
        }
        return null;
    }
    
    /**
     * Gets the {@link UnifiedEnergy} instance.
     *
     * @return the {@link UnifiedEnergy} instance
     */
    @NotNull
    private static UnifiedEnergy getInstance() {
        return INSTANCE;
    }
    
}
