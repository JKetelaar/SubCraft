package com.mentonica.mcsub;

import com.mentonica.mcsub.get.parser.Parse;
import com.mentonica.mcsub.get.site.Get;
import com.mentonica.mcsub.get.site.Lines;
import com.mentonica.mcsub.set.Variables;
import com.mentonica.mcsub.set.site.Set;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class Start extends JavaPlugin {
    private static String [] t = {"jeronimo078"};
    public static void startScript(){
        try {
            Get.getUsers();
        } catch (Exception e) {
            e.printStackTrace();
         }
        Lines.seperate();
        Parse p = new Parse();
        p.startTimer();
        Variables.playersDone.add("Jelle");
        try {
            Set.set();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
