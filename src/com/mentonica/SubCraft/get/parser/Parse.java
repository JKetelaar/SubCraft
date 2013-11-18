package com.mentonica.subcraft.get.parser;

import com.mentonica.subcraft.get.data.Variables;
import com.mentonica.subcraft.set.SVariables;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class Parse extends JavaPlugin {

    public static void startParse() {
        if (Variables.isAble() == true) {
            for (String s : Variables.getSplittedArray()) {
                String[] t = s.split("%20");
                Variables.setCommand(t[0]);
                if (t.length > 1) {
                    Variables.setTPlayer(t[1]);
                    Variables.setCommandid(t[2]);
                    Variables.setInvcheck(Integer.parseInt(t[3]));
                    if (Variables.getInvcheck() == 1) {
                        Variables.setInvamount(Integer.parseInt(t[4]));
                    }
                    parse(Variables.getTPlayer());
                }
            }
        }

    }

    public static boolean parse(String args) {
        Player player = Bukkit.getPlayerExact(args);
        if (player != null) {
            if (Variables.getInvcheck() == 1 && player.getInventory().firstEmpty() == -1) {
                player.sendMessage("Your inventory is full, please make space to receive your order");
            } else {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), Variables.getCommand());
                SVariables.playersDone.add(Variables.getCommandid());
                /*Todo Insert this line*/ // player.sendMessage("Bedankt voor uw donatie. U hebt het volgende ontvangen: " + Variables.getCommand()/*Todo Change to itemname*/
                //+" producten of rank ontvangen, is dit niet het geval? Contacteer dan een staf-lid.");
                player.sendMessage("Bedankt voor uw donatie. U hebt uw producten of rank ontvangen, is dit niet het geval? Contacteer dan een staff-lid.");
            }

        }
        return false;
    }

}