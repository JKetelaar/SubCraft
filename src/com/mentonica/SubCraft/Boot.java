package com.mentonica.SubCraft;

import com.mentonica.SubCraft.get.data.Variables;
import com.mentonica.SubCraft.get.parser.Parse;
import com.mentonica.SubCraft.get.site.Get;
import com.mentonica.SubCraft.get.site.Lines;
import com.mentonica.SubCraft.players.Insert;
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

import java.io.IOException;

public class Boot extends JavaPlugin implements Listener {
    Permission permission;

    public void onEnable() {
        //Todo #Add function for main server#
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(this, this);
        getLogger().info("SubCraft started!");
        Variables.setServerKey(Bukkit.getServerId());
        Variables.setError(false);
        Start t = new Start();
        t.startTimer();
    }

    @Override
    public void onDisable() {
        getLogger().info("SubCraft stopped!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        RegisteredServiceProvider permissionProvider = getServer().getServicesManager().getRegistration(Permission.class);
        if (permissionProvider != null) {
            permission = ((Permission)permissionProvider.getProvider());
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
                    //Parse p = new Parse();
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
