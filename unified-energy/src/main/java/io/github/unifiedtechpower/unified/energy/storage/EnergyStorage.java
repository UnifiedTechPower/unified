package io.github.unifiedtechpower.unified.energy.storage;

import io.github.unifiedtechpower.unified.energy.unit.EnergyUnit;
import org.jetbrains.annotations.NotNull;

/**
 * An interface to provide methods to give or receive energy to/from a block.
 */
public interface EnergyStorage {
    
    /**
     * Gets the {@link EnergyUnit} of this {@link EnergyStorage}.
     *
     * @return The {@link EnergyUnit} of this {@link EnergyStorage}.
     */
    @NotNull
    EnergyUnit getEnergyUnit();
    
    /**
     * Gets the maximum amount of energy that can be stored in this storage.
     * <p>
     * <b>Returns the energy in the {@link EnergyUnit} of this {@link EnergyStorage}</b>
     *
     * @return the maximum amount of energy that can be stored.
     */
    long getMaxEnergy();
    
    /**
     * Gets the maximum amount of energy that can be stored in this storage.
     *
     * @param energyUnit the {@link EnergyUnit} the energy should be converted to
     * @return the maximum amount of energy that can be stored.
     */
    default long getMaxEnergy(@NotNull EnergyUnit energyUnit) {
        return energyUnit.convertFrom(getEnergyUnit(), getMaxEnergy());
    }
    
    /**
     * Gets the amount of energy currently stored in this storage.
     * <p>
     * <b>Returns the energy in the {@link EnergyUnit} of this {@link EnergyStorage}</b>
     *
     * @return the amount of energy currently stored.
     */
    long getEnergy();
    
    /**
     * Gets the amount of energy currently stored in this storage.
     *
     * @param energyUnit the {@link EnergyUnit} the energy should be converted to
     * @return the amount of energy currently stored.
     */
    default long getEnergy(@NotNull EnergyUnit energyUnit) {
        return energyUnit.convertFrom(getEnergyUnit(), getEnergy());
    }
    
    /**
     * Sets the amount of energy currently stored in this storage.
     * <p>
     * <b>Assumes that the energy is in the {@link EnergyUnit} of this {@link EnergyStorage}.</b>
     *
     * @param energy the amount of energy to set.
     * @throws IllegalArgumentException if the energy is greater than the maximum amount of energy that can be stored or
     *                                  less than 0.
     */
    void setEnergy(long energy);
    
    /**
     * Sets the amount of energy currently stored in this storage.
     *
     * @param energyUnit the {@link EnergyUnit} of the energy to set
     * @param energy     the amount of energy to set.
     * @throws IllegalArgumentException if the energy is greater than the maximum amount of energy that can be stored or
     *                                  less than 0.
     */
    default void setEnergy(@NotNull EnergyUnit energyUnit, long energy) {
        setEnergy(energyUnit.convertTo(getEnergyUnit(), energy));
    }
    
    /**
     * Gets the remaining free space in this storage.
     * <p>
     * <b>Returns the energy in the {@link EnergyUnit} of this {@link EnergyStorage}</b>
     *
     * @return the remaining free space.
     */
    default long getFreeSpace() {
        return getMaxEnergy() - getEnergy();
    }
    
    /**
     * Gets the remaining free space in this storage.
     *
     * @param energyUnit the {@link EnergyUnit} the energy should be converted to
     * @return the remaining free space.
     */
    default long getFreeSpace(@NotNull EnergyUnit energyUnit) {
        return getMaxEnergy(energyUnit) - getEnergy(energyUnit);
    }
    
}
