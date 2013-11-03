package com.mentonica.mcsub;

import com.mentonica.mcsub.get.data.Variables;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Boot extends JavaPlugin {
    public void onEnable() {
        getLogger().info("MCSub started!");
        Variables.setServerKey(Bukkit.getServerId());
        Start t = new Start();
        t.startTimer();
    }

    @Override
    public void onDisable() {
        getLogger().info("MCSub stopped!");
    }
}
