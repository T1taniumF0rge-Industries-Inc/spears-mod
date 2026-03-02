package com.titan1um.spears.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpearMechanicsTest {

    @Test
    void computesVelocityBonusWithCap() {
        SpearAttackResult result = SpearMechanics.computeAttack(SpearTier.IRON, 20.0, 0.0, LungeLevel.NONE, true);
        assertEquals(8.0, result.velocityBonusDamage(), 1e-9);
        assertEquals(14.5, result.totalDamage(), 1e-9);
    }

    @Test
    void appliesLungeOnJabOnlyAndUsesKnownMultipliers() {
        SpearAttackResult jab = SpearMechanics.computeAttack(SpearTier.WOOD, 0.2, 0.0, LungeLevel.III, true);
        SpearAttackResult swing = SpearMechanics.computeAttack(SpearTier.WOOD, 0.2, 0.0, LungeLevel.III, false);

        assertEquals(2.0, jab.lungeHorizontalVelocityMultiplier(), 1e-9);
        assertEquals(4, jab.hungerCost());
        assertEquals(80, jab.lungeCooldownTicks());

        assertEquals(1.0, swing.lungeHorizontalVelocityMultiplier(), 1e-9);
        assertEquals(0, swing.hungerCost());
        assertEquals(0, swing.lungeCooldownTicks());
    }

    @Test
    void computesRelativeSpeedUsingBackportReferenceFormula() {
        assertEquals(1.0, SpearMechanics.computeRelativeSpeed(0.0, 0.0), 1e-9);
        assertEquals(5.5, SpearMechanics.computeRelativeSpeed(5.0, 0.0), 1e-9);
        assertEquals(12.0, SpearMechanics.computeRelativeSpeed(12.0, 0.0), 1e-9);
    }
}
