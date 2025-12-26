package dev.the456gamer.EndthePortal;

import org.bukkit.World.Environment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.plugin.java.JavaPlugin;
import org.jspecify.annotations.NonNull;

public final class EndthePortal extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onPlayerTeleport(@NonNull PlayerTeleportEvent event) {
        if (event.getFrom().getWorld() == null) return;
        TeleportCause cause = event.getCause();
        if (event.getFrom().getWorld().getEnvironment() == Environment.THE_END) {
            if (cause == TeleportCause.END_PORTAL || cause == TeleportCause.UNKNOWN) event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityPortal(@NonNull EntityPortalEvent event) {
        if (event.getFrom().getWorld().getEnvironment() == Environment.THE_END) event.setCancelled(true);
    }
}
