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
     * @param future   the future to complete when the {@link EnergyStorage}s are retrieved
     */
    void getEnergyStorageAt(@NotNull Location location, @NotNull CompletableFuture<@Nullable EnergyStorage> future);
    
    /**
     * Gets the {@link EnergyStorage}s in the given chunk by completing a {@link CompletableFuture}.
     *
     * @param chunk  the chunk to get the {@link EnergyStorage}s from
     * @param future the future to complete when the {@link EnergyStorage}s are retrieved
     */
    void getEnergyStoragesIn(@NotNull Chunk chunk, @NotNull CompletableFuture<@NotNull List<@NotNull EnergyStorage>> future);
    
}
