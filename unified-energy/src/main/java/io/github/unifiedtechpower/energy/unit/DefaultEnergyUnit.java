package io.github.unifiedtechpower.energy.unit;

import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

/**
 * The default {@link EnergyUnit}.
 */
public class DefaultEnergyUnit implements EnergyUnit {
    
    private DefaultEnergyUnit() {
    }
    
    private static final String NAME = "UF";
    
    private static final NamespacedKey KEY = NamespacedKey.fromString("unified:default_energy");
    
    static final EnergyUnit INSTANCE = new DefaultEnergyUnit();
    
    /**
     * Gets the name of this energy unit.
     *
     * @return The name of this energy unit.
     */
    @Override
    public @NotNull String getName() {
        return NAME;
    }
    
    /**
     * Converts the energy from this unit to the default unit.
     *
     * @param value the energy in this unit
     * @return the energy in the default unit
     */
    @Override
    public long convertToDefault(long value) {
        return value;
    }
    
    /**
     * Converts the energy from the default unit to this unit.
     *
     * @param value the energy in the default unit
     * @return the energy in this unit
     */
    @Override
    public long convertFromDefault(long value) {
        return value;
    }
    
    /**
     * Converts this energy unit to the specified energy unit.
     *
     * @param energyUnit the energy unit to convert to
     * @param value      the energy in this unit
     * @return the energy in the specified unit
     */
    @Override
    public long convertTo(@NotNull EnergyUnit energyUnit, long value) {
        return energyUnit.convertFromDefault(value);
    }
    
    /**
     * Converts the specified energy unit to this energy unit.
     *
     * @param energyUnit the energy unit to convert from
     * @param value      the energy in the specified unit
     * @return the energy in this unit
     */
    @Override
    public long convertFrom(@NotNull EnergyUnit energyUnit, long value) {
        return energyUnit.convertToDefault(value);
    }
    
    /**
     * Return the namespaced identifier for this object.
     *
     * @return this object's key
     */
    @NotNull
    @Override
    public NamespacedKey getKey() {
        assert KEY != null;
        return KEY;
    }
}
