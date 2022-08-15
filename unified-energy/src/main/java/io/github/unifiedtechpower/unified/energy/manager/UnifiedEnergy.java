package io.github.unifiedtechpower.unified.energy.manager;

import io.github.unifiedtechpower.unified.energy.storage.EnergyStorage;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Manager for different {@link EnergyNetworkManager} implementations.
 */
public class UnifiedEnergy {
    
    private static final UnifiedEnergy INSTANCE = new UnifiedEnergy();
    
    private final HashSet<EnergyNetworkManager> managers = new HashSet<>();
    
    private UnifiedEnergy() {
    }
    
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
     * @return a {@link CompletableFuture} that completes with the {@link EnergyStorage} at the given location or null if none was found
     */
    @NotNull
    public CompletableFuture<@Nullable EnergyStorage> getEnergyStorageAt(@NotNull Location location) {
        var futures = Collections.synchronizedSet(new HashSet<CompletableFuture<@Nullable EnergyStorage>>());
        var mainFuture = new CompletableFuture<@Nullable EnergyStorage>();
        
        for (var manager : managers)
            futures.add(manager.getEnergyStorageAt(location));
        
        for (var future : futures) {
            future.thenAccept(storage -> {
                if (mainFuture.isDone())
                    return;
                
                if (storage != null) {
                    mainFuture.complete(storage);
                } else {
                    futures.remove(future);
                    if (futures.isEmpty())
                        mainFuture.complete(null);
                }
            });
        }
        
        return mainFuture;
    }
    
    /**
     * Gets the {@link EnergyStorage}s in the given chunk.
     *
     * @param chunk the chunk to get the {@link EnergyStorage}s from
     * @return a {@link CompletableFuture} that completes with a list of {@link EnergyStorage}s in the given chunk
     */
    @NotNull
    public CompletableFuture<@NotNull List<@NotNull EnergyStorage>> getEnergyStoragesIn(@NotNull Chunk chunk) {
        var futures = Collections.synchronizedSet(new HashSet<CompletableFuture<@NotNull List<@NotNull EnergyStorage>>>());
        var energyStorages = Collections.synchronizedList(new ArrayList<@NotNull EnergyStorage>());
        var mainFuture = new CompletableFuture<@NotNull List<@NotNull EnergyStorage>>();
        
        for (var manager : managers)
            futures.add(manager.getEnergyStoragesIn(chunk));
        
        for (var future : futures) {
            future.thenAccept(storages -> {
                if (!storages.isEmpty())
                    energyStorages.addAll(storages);
                
                futures.remove(future);
                if (futures.isEmpty())
                    mainFuture.complete(energyStorages);
                
            });
        }
        
        return mainFuture;
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
