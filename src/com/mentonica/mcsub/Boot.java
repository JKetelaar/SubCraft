package com.mentonica.mcsub;

import com.mentonica.mcsub.get.data.Variables;
import com.mentonica.mcsub.players.Insert;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Boot extends JavaPlugin implements Listener {
    Permission permission;

    public void onEnable() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(this, this);
        getLogger().info("MCSub started!");
        Variables.setServerKey(Bukkit.getServerId());
        Variables.setError(false);
        Start t = new Start();
        t.startTimer();
    }

    @Override
    public void onDisable() {
        getLogger().info("MCSub stopped!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String rank = permission.getPrimaryGroup(player);
        String playerName = player.toString();
        Insert.insertPlayer(rank, playerName);
    }
}
