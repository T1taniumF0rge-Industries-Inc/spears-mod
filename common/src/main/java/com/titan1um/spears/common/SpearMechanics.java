package com.titan1um.spears.common;

/**
 * Shared deterministic mechanics inspired by the current spear backport references.
 */
public final class SpearMechanics {

    /** Matches lunge cooldown observed in spears-test NeoForge runtime (80 ticks). */
    public static final int LUNGE_COOLDOWN_TICKS = 80;
    private static final double VELOCITY_DAMAGE_MULTIPLIER = 1.75;
    private static final double MAX_VELOCITY_BONUS = 8.0;

    private SpearMechanics() {
    }

    public static SpearAttackResult computeAttack(
        SpearTier tier,
        double attackerHorizontalSpeed,
        double targetHorizontalSpeed,
        LungeLevel lungeLevel,
        boolean isJabAttack
    ) {
        double relativeSpeed = computeRelativeSpeed(attackerHorizontalSpeed, targetHorizontalSpeed);
        double velocityBonus = Math.min(MAX_VELOCITY_BONUS, relativeSpeed * VELOCITY_DAMAGE_MULTIPLIER);
        double base = tier.baseDamage();
        double jabBonus = isJabAttack ? 1.5 : 0.0;

        double totalDamage = base + velocityBonus + jabBonus;
        double lungeMultiplier = isJabAttack ? lungeLevel.horizontalVelocityMultiplier() : 1.0;
        int hungerCost = isJabAttack ? lungeLevel.hungerCost() : 0;
        int cooldown = (isJabAttack && lungeLevel != LungeLevel.NONE) ? LUNGE_COOLDOWN_TICKS : 0;

        return new SpearAttackResult(totalDamage, velocityBonus, relativeSpeed, lungeMultiplier, hungerCost, cooldown);
    }

    /**
     * Relative speed model inspired by Masuno Spear backport:
     * strength = |v_attacker - v_target|; strength += max(10-strength,0) * 0.1
     */
    public static double computeRelativeSpeed(double attackerHorizontalSpeed, double targetHorizontalSpeed) {
        double attacker = Math.max(0.0, attackerHorizontalSpeed);
        double target = Math.max(0.0, targetHorizontalSpeed);
        double strength = Math.abs(attacker - target);
        double closeToZeroBoost = Math.max(10.0 - strength, 0.0);
        return strength + closeToZeroBoost * 0.1;
    }
}
