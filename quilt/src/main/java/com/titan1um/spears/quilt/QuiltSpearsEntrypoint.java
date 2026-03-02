package com.titan1um.spears.quilt;

import com.titan1um.spears.common.SpearRegistry;
import net.fabricmc.api.ModInitializer;

public final class QuiltSpearsEntrypoint implements ModInitializer {
    @Override
    public void onInitialize() {
        SpearRegistry.spearIds();
    }
}
