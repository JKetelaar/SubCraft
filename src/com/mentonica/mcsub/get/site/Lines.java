package com.mentonica.mcsub.get.site;

import com.mentonica.mcsub.get.data.Variables;
import org.bukkit.plugin.java.JavaPlugin;

public class Lines extends JavaPlugin {
    public static void seperate(){
        String full = Variables.getUrlContent();
        String[] splitted = full.split("<br/>");

        for (String s : splitted){
            Variables.splittedArray.add(s);
        }
    }
}
