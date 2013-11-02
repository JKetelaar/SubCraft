package com.mentonica.mcsub.get.parser;

import com.mentonica.mcsub.get.data.Variables;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Parse {

    public static void parse(){
        for (String s : Variables.getSplittedArray()){
            String[] t = s.split("%20");
            Player target = Bukkit.getServer().getPlayer(t[0]);
            if (target.isOnline()){
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "");
            }
        }
    }
}
