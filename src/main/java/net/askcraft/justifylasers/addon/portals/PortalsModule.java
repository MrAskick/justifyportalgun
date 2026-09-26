package net.askcraft.justifylasers.addon.portals;

import net.askcraft.justifylasers.api.JustifyModule;
import net.askcraft.justifylasers.addon.portals.registry.PortalPortals;
import net.askcraft.justifylasers.platform.Platform;
import net.askcraft.justifylasers.portal.PortalNetwork;
import net.askcraft.justifylasers.portal.PortalChunkTracking;
import net.minecraft.registry.RegistryKeys;

public final class PortalsModule implements JustifyModule {
    public String id() { return "justify_portal_gun"; }
    public void initialize() {
        Platform.onRegister(RegistryKeys.ITEM, PortalPortals::initializeItems);
        Platform.onRegister(RegistryKeys.ENTITY_TYPE, PortalPortals::initializeEntities);
        Platform.onRegister(RegistryKeys.SOUND_EVENT, net.askcraft.justifylasers.addon.portals.registry.PortalSounds::initialize);
        Platform.onRegister(RegistryKeys.ITEM_GROUP, PortalPortals::initializeGroup);
        Platform.onEndWorldTick(net.askcraft.justifylasers.portal.PortalCarry::tick);
        Platform.onEndWorldTick(PortalNetwork::tick);
        Platform.onEndWorldTick(PortalChunkTracking::tick);
    }
}
