package com.titan1um.spears.common;

public enum LungeLevel {
    NONE(0, 1.0, 0),
    I(1, 1.3, 2),
    II(2, 1.6, 3),
    III(3, 2.0, 4);

    private final int level;
    private final double horizontalVelocityMultiplier;
    private final int hungerCost;

    LungeLevel(int level, double horizontalVelocityMultiplier, int hungerCost) {
        this.level = level;
        this.horizontalVelocityMultiplier = horizontalVelocityMultiplier;
        this.hungerCost = hungerCost;
    }

    public int level() {
        return level;
    }

    public double horizontalVelocityMultiplier() {
        return horizontalVelocityMultiplier;
    }

    public int hungerCost() {
        return hungerCost;
    }
}
