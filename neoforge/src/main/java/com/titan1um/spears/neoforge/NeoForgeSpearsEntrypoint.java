package com.titan1um.spears.neoforge;

import com.titan1um.spears.common.SpearRegistry;
import net.neoforged.fml.common.Mod;

@Mod("spearsmod")
public final class NeoForgeSpearsEntrypoint {
    public NeoForgeSpearsEntrypoint() {
        SpearRegistry.spearIds();
    }
}
