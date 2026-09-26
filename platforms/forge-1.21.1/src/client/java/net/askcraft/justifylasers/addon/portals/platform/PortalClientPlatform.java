package net.askcraft.justifylasers.addon.portals.platform;

import net.askcraft.justifylasers.registry.ModPortals;
import net.askcraft.justifylasers.client.render.CarriedBlockRenderer;
import net.askcraft.justifylasers.client.render.CompanionCubeRenderer;
import net.askcraft.justifylasers.client.render.PortalGunRenderer;
import net.askcraft.justifylasers.client.render.ResourceItemMeshes;
import net.askcraft.justifylasers.client.ClientSettingsKey;

public final class PortalClientPlatform {
    public static void initialize() { }
    public static void event(Object input) {
        if (input instanceof net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(ModPortals.CARRIED_BLOCK, CarriedBlockRenderer::new);
            event.registerEntityRenderer(ModPortals.COMPANION_CUBE, CompanionCubeRenderer::new);
        }
        if (input instanceof net.minecraftforge.client.event.RegisterKeyMappingsEvent event) event.register(ClientSettingsKey.PORTAL_CARRY);
    }
}
