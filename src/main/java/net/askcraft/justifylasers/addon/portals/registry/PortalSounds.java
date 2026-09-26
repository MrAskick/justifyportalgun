package net.askcraft.justifylasers.addon.portals.registry;

import net.askcraft.justifylasers.platform.GameVersion;
import net.askcraft.justifylasers.platform.Platform;
import net.askcraft.justifylasers.portal.PortalAudio;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;
import static net.askcraft.justifylasers.portal.PortalAudio.Cue.*;

public final class PortalSounds {
    public static void initialize() {
        bind(ENTER, "portal_enter"); bind(EXIT, "portal_exit"); bind(CLOSE, "portal_fizzle");
        bind(INVALID, "portal_invalid_surface"); bind(OPEN_BLUE, "portal_open_blue"); bind(OPEN_ORANGE, "portal_open_red");
        bind(AMBIENT, "wpn_portal_ambient_lp"); bind(GUN_INVALID, "portal_invalid_surface_swt");
        bind(GUN_CLOSE, "wpn_portal_fizzler_shimmy"); bind(FIRE_BLUE, "wpn_portal_gun_fire_blue");
        bind(FIRE_ORANGE, "wpn_portal_gun_fire_red"); bind(ACTIVATE, "wpn_portalgun_activation");
        bind(GRAB, "object_use_lp_start"); bind(HOLD, "object_use_lp_loop");
        bind(RELEASE, "object_use_stop"); bind(GRAB_FAILED, "object_use_failure");
    }
    private static void bind(PortalAudio.Cue cue, String path) {
        var id = GameVersion.id("justify_portal_gun", path);
        PortalAudio.bind(cue, Platform.register(Registries.SOUND_EVENT, id, SoundEvent.of(id)));
    }
    private PortalSounds() {}
}
