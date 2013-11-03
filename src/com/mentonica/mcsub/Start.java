package com.mentonica.mcsub;

import com.mentonica.mcsub.get.data.Variables;
import com.mentonica.mcsub.get.parser.Parse;
import com.mentonica.mcsub.get.site.Get;
import com.mentonica.mcsub.get.site.Lines;
import org.bukkit.plugin.java.JavaPlugin;

public class Start extends JavaPlugin {

    public static void startTimer() {
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        try {
                            Get.getUsers();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Lines.seperate();
                        Parse p = new Parse();
                        p.startParse();
                        Variables.setAble(true);
                        Variables.splittedArray.clear();
                    }
                },
                0, (10 * 1000)
        );
    }
}
