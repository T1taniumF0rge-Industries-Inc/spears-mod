package com.titan1um.spears.fabric;

import com.titan1um.spears.common.SpearRegistry;
import net.fabricmc.api.ModInitializer;

public final class FabricSpearsEntrypoint implements ModInitializer {
    @Override
    public void onInitialize() {
        SpearRegistry.spearIds();
    }
}
