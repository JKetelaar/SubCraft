package com.mentonica.SubCraft.get.site;

import com.mentonica.SubCraft.get.data.Variables;
import org.bukkit.plugin.java.JavaPlugin;

public class Lines extends JavaPlugin {
    public static void seperate() {
        String full = Variables.getUrlContent();

        if (Variables.isAble() == true) {
            try {
                String[] splitted = full.split("<br>");
                for (String s : splitted) {
                    Variables.splittedArray.add(s);
                }
            } catch (Exception e) {
                Variables.setAble(false);
                System.out.println("Able set to false");
            }
        }
    }
}
