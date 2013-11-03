package com.mentonica.mcsub.get.ranks;

import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Check extends JavaPlugin {
    public void checkRank() {
        Player player = Bukkit.getPlayerExact("jeronimo078");
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        Permission t = rsp.getProvider();
        String s = t.getPrimaryGroup(player);
        System.out.println(player);
        System.out.println(s);
    }
}