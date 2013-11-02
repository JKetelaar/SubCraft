package com.mentonica;

import com.mentonica.mcsub.get.parser.Parse;
import com.mentonica.mcsub.get.site.Get;
import com.mentonica.mcsub.get.site.Lines;
import com.mentonica.mcsub.set.Variables;
import com.mentonica.mcsub.set.site.Set;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class Boot extends JavaPlugin {
    public void onEnable(){

        try {
            Get.getUsers();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        Lines.seperate();
        Parse.parse();
        Variables.playersDone.add("Jelle");
        try {
            Set.set();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
