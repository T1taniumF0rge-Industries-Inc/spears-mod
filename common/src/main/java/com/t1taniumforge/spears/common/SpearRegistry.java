package com.t1taniumforge.spears.common;

import java.util.EnumMap;
import java.util.Map;

public final class SpearRegistry {
    private SpearRegistry() {
    }

    public static Map<SpearTier, String> spearIds() {
        Map<SpearTier, String> ids = new EnumMap<>(SpearTier.class);
        ids.put(SpearTier.WOOD, "wooden_spear");
        ids.put(SpearTier.STONE, "stone_spear");
        ids.put(SpearTier.IRON, "iron_spear");
        ids.put(SpearTier.COPPER, "copper_spear");
        ids.put(SpearTier.GOLD, "golden_spear");
        ids.put(SpearTier.DIAMOND, "diamond_spear");
        ids.put(SpearTier.NETHERITE, "netherite_spear");
        return ids;
    }
}
