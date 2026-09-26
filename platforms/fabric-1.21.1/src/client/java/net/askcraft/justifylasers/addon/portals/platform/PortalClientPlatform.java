package net.askcraft.justifylasers.addon.portals.platform;

import net.askcraft.justifylasers.registry.ModPortals;
import net.askcraft.justifylasers.client.render.CarriedBlockRenderer;
import net.askcraft.justifylasers.client.render.CompanionCubeRenderer;
import net.askcraft.justifylasers.client.render.PortalGunRenderer;
import net.askcraft.justifylasers.client.render.ResourceItemMeshes;
import net.askcraft.justifylasers.client.ClientSettingsKey;

public final class PortalClientPlatform {
    public static void initialize() {
        net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry.register(ModPortals.CARRIED_BLOCK, CarriedBlockRenderer::new);
        net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry.register(ModPortals.COMPANION_CUBE, CompanionCubeRenderer::new);
        net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper.registerKeyBinding(ClientSettingsKey.PORTAL_CARRY);
        for (var gun : ModPortals.guns()) net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry.INSTANCE.register(gun,
                PortalGunRenderer::renderItem);
        net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry.INSTANCE.register(ModPortals.COMPANION_CUBE_ITEM,
                (stack, mode, matrices, consumers, light, overlay) -> ResourceItemMeshes.render(stack, mode, matrices, consumers, light, overlay));
    }
    public static void event(Object input) { }
}
