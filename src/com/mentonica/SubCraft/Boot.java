package com.mentonica.SubCraft;

import com.mentonica.SubCraft.get.data.Variables;
import com.mentonica.SubCraft.get.parser.Parse;
import com.mentonica.SubCraft.get.site.Get;
import com.mentonica.SubCraft.get.site.Lines;
import com.mentonica.SubCraft.players.Insert;
import com.mentonica.SubCraft.reader.Read;
import com.mentonica.SubCraft.set.SVariables;
import com.mentonica.SubCraft.set.site.Set;
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
    File pluginFolder = new File("plugins/SubCraft");

    public void onEnable() {
            System.out.println("HERE WE ARE");
            System.out.println(pluginFolder);

        Variables.setPluginFolder(pluginFolder);

        Read.ReadFolder();
        if (!Read.FReadConfigFile()) {
            Variables.setFileExists(false);
        }
        if (Variables.isFileExists()) {
            //Todo Add function for main server (player insertion)
            PluginManager pm = Bukkit.getServer().getPluginManager();
            pm.registerEvents(this, this);
            getLogger().info("SubCraft started!");
            Variables.setServerKey(Bukkit.getServerId());
            Variables.setError(false);
            Start t = new Start();
            t.startTimer();
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("SubCraft stopped!");
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
        if (cmd.getName().equalsIgnoreCase("subcraft")) {
            if (!(sender instanceof ConsoleCommandSender)) {
                sender.sendMessage("This command can only be run by the system.");
            } else {
                if (!Variables.isError()) {
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
                }
            }
            return true;
        }
        return false;
    }
}
