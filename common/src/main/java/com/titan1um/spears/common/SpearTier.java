package com.titan1um.spears.common;

public enum SpearTier {
    WOOD(3.0, 1.2),
    STONE(4.0, 1.3),
    IRON(5.0, 1.4),
    COPPER(4.5, 1.35),
    GOLD(3.0, 1.6),
    DIAMOND(6.0, 1.45),
    NETHERITE(7.0, 1.5);

    private final double baseDamage;
    private final double attackSpeed;

    SpearTier(double baseDamage, double attackSpeed) {
        this.baseDamage = baseDamage;
        this.attackSpeed = attackSpeed;
    }

    public double baseDamage() {
        return baseDamage;
    }

    public double attackSpeed() {
        return attackSpeed;
    }
}
