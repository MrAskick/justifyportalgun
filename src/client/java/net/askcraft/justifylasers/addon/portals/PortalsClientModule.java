package net.askcraft.justifylasers.addon.portals;

import net.askcraft.justifylasers.api.JustifyClientModule;
import net.askcraft.justifylasers.addon.portals.platform.PortalClientPlatform;
import net.askcraft.justifylasers.client.PortalHud;
import net.askcraft.justifylasers.client.render.ResourceItemMeshes;
import net.askcraft.justifylasers.platform.GameVersion;
import net.askcraft.justifylasers.registry.ModPortals;

public final class PortalsClientModule implements JustifyClientModule {
    public String id() { return "justify_portal_gun"; }
    public void initialize() {
        ResourceItemMeshes.register(ModPortals.COMPANION_CUBE_ITEM, GameVersion.id(id(), "models/item/companion_cube.json"), stack -> 0xFFFFFF);
        for (var gun : ModPortals.guns()) ResourceItemMeshes.register(gun,
                stack -> net.askcraft.justifylasers.client.ClientSettings.get().portalGunModel == net.askcraft.justifylasers.client.ClientSettings.PortalGunModel.REALISTIC
                        ? GameVersion.id(id(), "models/item/portal_gun_realistic.json") : GameVersion.id("justifylasers", "models/item/portal_gun.json"),
                stack -> ((net.askcraft.justifylasers.item.PortalGunItem)stack.getItem()).color(stack));
        PortalHud.sprites(GameVersion.id(id(), "textures/gui/lempty.png"), GameVersion.id(id(), "textures/gui/lfull.png"),
                GameVersion.id(id(), "textures/gui/rempty.png"), GameVersion.id(id(), "textures/gui/rfull.png"));
        PortalClientPlatform.initialize();
    }
    public void loaderEvent(Object event) { PortalClientPlatform.event(event); }
}
