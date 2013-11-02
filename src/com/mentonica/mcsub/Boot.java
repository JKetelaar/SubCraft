package com.mentonica.mcsub;

import org.bukkit.plugin.java.JavaPlugin;

public class Boot extends JavaPlugin {
    public void onEnable(){
        getLogger().info("onEnable has been invoked!");
        Start.startScript();

    }

    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    }
}
