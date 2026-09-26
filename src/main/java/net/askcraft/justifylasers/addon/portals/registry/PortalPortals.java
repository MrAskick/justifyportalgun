package net.askcraft.justifylasers.addon.portals.registry;

import net.askcraft.justifylasers.JustifyLasers;
import net.askcraft.justifylasers.item.PortalGunItem;
import net.askcraft.justifylasers.platform.Platform;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;


import net.askcraft.justifylasers.registry.*;
import net.askcraft.justifylasers.portal.PortalPalette;
import net.askcraft.justifylasers.platform.GameVersion;

public final class PortalPortals extends ModPortals {
    public static void initializeEntities() {
        COMPANION_CUBE = Platform.register(Registries.ENTITY_TYPE, GameVersion.id("justify_portal_gun", "companion_cube"),
                GameVersion.entityDimensions(net.minecraft.entity.EntityType.Builder.<net.askcraft.justifylasers.entity.CompanionCubeEntity>create(
                        net.askcraft.justifylasers.entity.CompanionCubeEntity::new, net.minecraft.entity.SpawnGroup.MISC), .9F, .9F)
                        .maxTrackingRange(10).trackingTickInterval(1).build("justify_portal_gun:companion_cube"));
        CARRIED_BLOCK = Platform.register(Registries.ENTITY_TYPE, net.askcraft.justifylasers.platform.GameVersion.id("justify_portal_gun", "carried_block"),
                net.askcraft.justifylasers.platform.GameVersion.entityDimensions(net.minecraft.entity.EntityType.Builder.<net.askcraft.justifylasers.entity.CarriedBlockEntity>create(
                    net.askcraft.justifylasers.entity.CarriedBlockEntity::new, net.minecraft.entity.SpawnGroup.MISC), .98F, .98F).maxTrackingRange(10).trackingTickInterval(1).build("justify_portal_gun:carried_block"));
    }
    public static void initializeItems() {
        COMPANION_CUBE_ITEM = Platform.register(Registries.ITEM, GameVersion.id("justify_portal_gun", "companion_cube"),
                new net.askcraft.justifylasers.item.CompanionCubeItem(new Item.Settings().maxCount(16)));
        // Keep the alpha.50 registry ID so existing guns survive the module split.
        PORTAL_GUN = Platform.register(Registries.ITEM, JustifyLasers.id("portal_gun"),
                new PortalGunItem(new Item.Settings().maxCount(1)));
        PORTAL_GUN_VIOLET = gun("violet", PortalPalette.VIOLET, PortalGunItem.Mode.DUAL);
        PORTAL_GUN_CYAN = gun("cyan", PortalPalette.CYAN, PortalGunItem.Mode.DUAL);
        PORTAL_GUN_GREEN = gun("green", PortalPalette.GREEN, PortalGunItem.Mode.DUAL);
        PORTAL_GUN_BLUE = gun("blue", PortalPalette.CLASSIC, PortalGunItem.Mode.BLUE_ONLY);
        PORTAL_GUN_ORANGE = gun("orange", PortalPalette.CLASSIC, PortalGunItem.Mode.ORANGE_ONLY);
    }
    private static Item gun(String name, PortalPalette palette, PortalGunItem.Mode mode) {
        return Platform.register(Registries.ITEM, GameVersion.id("justify_portal_gun", "portal_gun_" + name),
                new PortalGunItem(new Item.Settings().maxCount(1), palette, mode));
    }

    public static void initializeGroup() {
        Platform.register(Registries.ITEM_GROUP, JustifyLasers.id("portals"), Platform.itemGroupBuilder()
                .displayName(Text.translatable("itemGroup.justify_portal_gun"))
                .icon(() -> new ItemStack(PORTAL_GUN))
                .entries((context, entries) -> { guns().forEach(entries::add); entries.add(COMPANION_CUBE_ITEM); }).build());
    }
}
