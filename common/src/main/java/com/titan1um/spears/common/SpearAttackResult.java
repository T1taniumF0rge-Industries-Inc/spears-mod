package com.titan1um.spears.common;

public record SpearAttackResult(
    double totalDamage,
    double velocityBonusDamage,
    double relativeSpeed,
    double lungeHorizontalVelocityMultiplier,
    int hungerCost,
    int lungeCooldownTicks
) {
}
