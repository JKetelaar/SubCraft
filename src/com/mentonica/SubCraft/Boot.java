package com.mentonica.subcraft;

import com.mentonica.subcraft.get.data.Variables;
import com.mentonica.subcraft.get.parser.Parse;
import com.mentonica.subcraft.get.site.Get;
import com.mentonica.subcraft.get.site.Lines;
import com.mentonica.subcraft.players.Insert;
import com.mentonica.subcraft.reader.Read;
import com.mentonica.subcraft.set.SVariables;
import com.mentonica.subcraft.set.site.Set;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Boot extends JavaPlugin implements Listener {
    Permission permission;
    File pluginFolder = new File("plugins/subcraft");

    public void onEnable() {
        //Todo rewrite config system
        Variables.setPluginFolder(pluginFolder);

        Read.ReadFolder();
        try {
            if (!Read.FReadConfigFile()) {
                Variables.setConfigExists(false);
            } else {
                Variables.setConfigExists(true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The server key is: " + Variables.getSubCraftKey());
        if (Variables.isConfigExists()) {
            //Todo Add function for main server (player insertion)
            PluginManager pm = Bukkit.getServer().getPluginManager();
            pm.registerEvents(this, this);
            getLogger().info("subcraft started!");
            Variables.setServerKey(Bukkit.getServerId());
            Variables.setError(false);
            Start t = new Start();
            t.startTimer();
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("subcraft stopped!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (Bukkit.getServerId() == "O8HS0y4TvjWqqSvMifvYCqGQ3") {
            RegisteredServiceProvider permissionProvider = getServer().getServicesManager().getRegistration(Permission.class);
            if (permissionProvider != null) {
                permission = ((Permission) permissionProvider.getProvider());
            }
            Player player = event.getPlayer();
            String rank = permission.getPrimaryGroup(player);
            rank = rank.replace("+", "%2B");
            String playerName = player.toString();
            playerName = playerName.replace("CraftPlayer{name=", "");
            playerName = playerName.replace("}", "");
            System.out.println(playerName);
            try {
                Insert.insertPlayer(rank, playerName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("sckey") || cmd.getName().equalsIgnoreCase("screfresh")) {
            if (!(sender instanceof ConsoleCommandSender)) {
                sender.sendMessage("This command can only be run by the system");
            } else {
                if (!Variables.isConfigExists() && cmd.getName().equalsIgnoreCase("sckey") && args[0].length() == 25) {

                    String c = args[0];
                    Variables.setServerKey(c);
                    try {
                        Read.ReadConfigFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("subcraft key is set to " + Variables.getSubCraftKey());
                } else if (Variables.isConfigExists() && cmd.getName().equalsIgnoreCase("sckey") && args[0].length() == 25) {
                    System.out.println("The subcraft configuration key is already set.");
                } else if (!Variables.isError() && cmd.getName().equalsIgnoreCase("screfresh")) {
                    try {
                        Get.getUsers();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Lines.seperate();
                    Parse.startParse();
                    Variables.setAble(true);
                    Variables.splittedArray.clear();
                    try {
                        Set.set();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    SVariables.playersDone.clear();
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}


