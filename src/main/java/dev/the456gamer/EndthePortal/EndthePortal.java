package dev.the456gamer.EndthePortal;

import java.util.logging.Logger;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jspecify.annotations.NonNull;

public final class EndthePortal extends JavaPlugin implements Listener {

    Logger logger;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.logger = this.getLogger();
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onEntityPortal(@NonNull EntityPortalEvent event) {
        //logger.info("got entity portal event " + event.getEntity() + ";" + event.getFrom().getWorld() + ";" + event.getFrom().getBlock());
        if (event.getFrom().getBlock().getType().equals(Material.END_PORTAL) && event.getFrom().getWorld().getEnvironment().equals(World.Environment.THE_END)) {
            event.setCancelled(true);
            //logger.info("prevented "+event.getEntity()+" from entering portal at "+event.getFrom());
        }
    }
}
