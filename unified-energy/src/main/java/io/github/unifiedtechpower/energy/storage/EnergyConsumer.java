package io.github.unifiedtechpower.energy.storage;

import io.github.unifiedtechpower.energy.unit.EnergyUnit;
import org.jetbrains.annotations.NotNull;

/**
 * An {@link EnergyStorage} that can consume energy.
 */
public interface EnergyConsumer extends EnergyStorage {
    
    /**
     * Inserts energy into this storage and returns the remaining amount of energy that could not be inserted.
     * <p>
     * <b>Assumes that the energy is in the {@link EnergyUnit} of this {@link EnergyStorage}.</b>
     *
     * @param energy the energy to insert
     * @return the remaining amount of energy that wasn't inserted.
     */
    long insertEnergy(long energy);
    
    /**
     * Inserts energy into this storage and returns the remaining amount of energy that could not be inserted.
     *
     * @param energyUnit the {@link EnergyUnit} of the energy that is being inserted
     * @param energy     the energy to insert
     * @return the remaining amount of energy that wasn't inserted.
     */
    default long insertEnergy(@NotNull EnergyUnit energyUnit, long energy) {
        return insertEnergy(energyUnit.convertTo(getEnergyUnit(), energy));
    }
    
    /**
     * Gets the maximum amount of energy that can be inserted into this storage per tick.
     * <p>
     * <b>Returns the energy in the {@link EnergyUnit} of this {@link EnergyStorage}</b>
     *
     * @return the maximum amount of energy that can be inserted per tick.
     */
    long getMaxEnergyInput();
    
    /**
     * Gets the maximum amount of energy that can be inserted into this storage per tick.
     *
     * @param energyUnit the {@link EnergyUnit} the energy should be converted to
     * @return the maximum amount of energy that can be inserted per tick.
     */
    default long getMaxEnergyInput(@NotNull EnergyUnit energyUnit) {
        return energyUnit.convertFrom(getEnergyUnit(), getMaxEnergyInput());
    }
    
}
