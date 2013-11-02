package com.mentonica.mcsub;

import com.mentonica.mcsub.get.parser.Parse;
import com.mentonica.mcsub.get.site.Get;
import com.mentonica.mcsub.get.site.Lines;
import org.bukkit.plugin.java.JavaPlugin;

public class Start extends JavaPlugin {

    public static void startScript() {
        try {
            Get.getUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Lines.seperate();
        Parse p = new Parse();
        p.startTimer();
        //Variables.playersDone.add("Jelle");
        //try {
        //  Set.set();
        //} catch (IOException e) {
        //  e.printStackTrace();
        //}
    }
}
