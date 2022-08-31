package io.github.unifiedtechpower.unified.energy.manager;

import io.github.unifiedtechpower.unified.energy.storage.EnergyStorage;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Interface to get {@link EnergyStorage} instances from a location.
 */
public interface EnergyNetworkManager {
    
    /**
     * Gets the {@link EnergyStorage} at the given location by completing a {@link CompletableFuture}.
     *
     * @param location the location to get the {@link EnergyStorage} from
     * @return a {@link CompletableFuture} that completes with the {@link EnergyStorage} at the given location or null if none was found
     */
    @NotNull
    CompletableFuture<@Nullable EnergyStorage> getEnergyStorageAt(@NotNull Location location);
    
    /**
     * Gets the {@link EnergyStorage}s in the given chunk by completing a {@link CompletableFuture}.
     *
     * @param chunk the chunk to get the {@link EnergyStorage}s from
     * @return a {@link CompletableFuture} that completes with the {@link EnergyStorage}s in the given chunk
     */
    @NotNull
    CompletableFuture<@NotNull List<@NotNull EnergyStorage>> getEnergyStoragesIn(@NotNull Chunk chunk);
    
}
