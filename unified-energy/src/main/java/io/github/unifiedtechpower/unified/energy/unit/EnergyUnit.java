package io.github.unifiedtechpower.unified.energy.unit;

import org.bukkit.Keyed;
import org.jetbrains.annotations.NotNull;

/**
 * An interface to provide methods to convert between different energy units.
 */
public interface EnergyUnit extends Keyed {
    
    /**
     * Gets the name of this energy unit.
     *
     * @return The name of this energy unit.
     */
    @NotNull
    String getName();
    
    /**
     * Formats a number of energy units to a string.
     *
     * @param value The energy to format.
     * @return The formatted energy.
     */
    @NotNull
    default String format(long value) {
        return value + getName();
    }
    
    /**
     * Converts the energy from this unit to the default unit.
     *
     * @param value the energy in this unit
     * @return the energy in the default unit
     */
    long convertToDefault(long value);
    
    /**
     * Converts the energy from the default unit to this unit.
     *
     * @param value the energy in the default unit
     * @return the energy in this unit
     */
    long convertFromDefault(long value);
    
    /**
     * Converts this energy unit to the specified energy unit.
     *
     * @param energyUnit the energy unit to convert to
     * @param value      the energy in this unit
     * @return the energy in the specified unit
     */
    default long convertTo(@NotNull EnergyUnit energyUnit, long value) {
        return energyUnit.convertFromDefault(this.convertToDefault(value));
    }
    
    /**
     * Converts the specified energy unit to this energy unit.
     *
     * @param energyUnit the energy unit to convert from
     * @param value      the energy in the specified unit
     * @return the energy in this unit
     */
    default long convertFrom(@NotNull EnergyUnit energyUnit, long value) {
        return this.convertFromDefault(energyUnit.convertToDefault(value));
    }
    
    @NotNull
    static EnergyUnit getDefault() {
        return DefaultEnergyUnit.getInstance();
    }
    
}
