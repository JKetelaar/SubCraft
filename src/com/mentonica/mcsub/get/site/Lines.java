package com.mentonica.mcsub.get.site;

import com.mentonica.mcsub.get.data.Variables;
import org.bukkit.plugin.java.JavaPlugin;

public class Lines extends JavaPlugin {
    public static void seperate() {
        String full = Variables.getUrlContent();

//        String t = Variables.getUrlContent().toString();
//        if (Variables.getUrlContent().toString().equals(t)){
//            System.out.println("String is fine");
//            Variables.setAble(false);
//        }

        if (Variables.isAble() == true) {
            try {
                String[] splitted = full.split("<br>");
                //System.out.println(full);
                for (String s : splitted) {
                    Variables.splittedArray.add(s);
                    // System.out.println(s);

                }
            } catch (Exception e) {
                Variables.setAble(false);
                System.out.println("Able set to false");
            }
        }
    }
}
