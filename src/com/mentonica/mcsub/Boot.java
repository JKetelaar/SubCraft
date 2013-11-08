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
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

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
        RegisteredServiceProvider permissionProvider = getServer().getServicesManager().getRegistration(Permission.class);
        if (permissionProvider != null) {
            permission = ((Permission)permissionProvider.getProvider());
        }
        Player player = event.getPlayer();
        String rank = permission.getPrimaryGroup(player);
        String playerName = player.toString();
        playerName = playerName.replace("CraftPlayer{name=", "");
        playerName = playerName.replace("}", "");
        try {
            Insert.insertPlayer(rank, playerName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
