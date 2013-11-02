package com.mentonica.mcsub.get.parser;

import com.mentonica.mcsub.get.data.Variables;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class Parse extends JavaPlugin {

    public static void startTimer() {
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        for (String s : Variables.getSplittedArray()) {
                            String[] t = s.split("%20");
                            Variables.setTPlayer(t[1]);
                            Variables.setCommand(t[0]);
                            parse(Variables.getTPlayer());
                        }
                    }
                },
                0, 60 * 1000
        );
    }

    public static boolean parse(String args) {


        Player player = Bukkit.getPlayerExact(args);
        if (player != null) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "say Player found");
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), Variables.getCommand());

        }
        else {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "say Player not found");
        }

        return false;
    }


}