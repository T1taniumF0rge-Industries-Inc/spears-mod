package com.titan1um.spears.forge;

import com.titan1um.spears.common.SpearRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod("spearsmod")
public final class ForgeSpearsEntrypoint {
    public ForgeSpearsEntrypoint() {
        SpearRegistry.spearIds();
    }
}
