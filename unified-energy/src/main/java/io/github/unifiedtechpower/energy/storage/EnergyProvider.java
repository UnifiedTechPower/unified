package io.github.unifiedtechpower.energy.storage;

import io.github.unifiedtechpower.energy.unit.EnergyUnit;
import org.jetbrains.annotations.NotNull;

/**
 * An {@link EnergyStorage} that can provide energy.
 */
public interface EnergyProvider extends EnergyStorage {
    
    /**
     * Extracts energy from this storage and returns the actual amount of energy that was extracted.
     * <p>
     * <b>Assumes that the energy is in the {@link EnergyUnit} of this {@link EnergyStorage}.</b>
     *
     * @param energy the amount of energy that is being extracted
     * @return the actual amount of energy that was extracted
     */
    long extractEnergy(long energy);
    
    /**
     * Extracts energy from this storage and returns the actual amount of energy that was extracted.
     *
     * @param energyUnit the {@link EnergyUnit} of the energy that is being extracted
     * @param energy     the amount of energy to extract
     * @return the amount of energy that was actually extracted
     */
    default long extractEnergy(@NotNull EnergyUnit energyUnit, long energy) {
        return extractEnergy(energyUnit.convertTo(getEnergyUnit(), energy));
    }
    
    /**
     * Gets the maximum amount of energy that can be extracted from this storage per tick.
     * <p>
     * <b>Returns the energy in the {@link EnergyUnit} of this {@link EnergyStorage}</b>
     *
     * @return the maximum amount of energy that can be extracted per tick.
     */
    long getMaxEnergyOutput();
    
    /**
     * Gets the maximum amount of energy that can be extracted from this storage per tick.
     *
     * @param energyUnit the {@link EnergyUnit} the energy should be converted to
     * @return the maximum amount of energy that can be extracted per tick.
     */
    default long getMaxEnergyOutput(@NotNull EnergyUnit energyUnit) {
        return energyUnit.convertFrom(getEnergyUnit(), getMaxEnergyOutput());
    }
    
}
