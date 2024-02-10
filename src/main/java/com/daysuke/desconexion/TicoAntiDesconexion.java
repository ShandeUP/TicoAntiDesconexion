package com.daysuke.desconexion;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import static java.lang.System.out;

public final class TicoAntiDesconexion extends JavaPlugin implements Listener {
    public void onEnable() {
        out.println("Activado TicoAntiSpam");
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }

    public void onDisable() {
        HandlerList.unregisterAll((Plugin) this);
    }

    @EventHandler(
            priority = EventPriority.NORMAL,
            ignoreCancelled = true
    )
    public void onPlayerKick(PlayerKickEvent e) {
        if (e.getReason().equalsIgnoreCase("disconnect.spam")) {
            e.setCancelled(true);
        }
    }
}
