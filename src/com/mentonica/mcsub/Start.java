package com.mentonica.mcsub;

import com.mentonica.mcsub.get.data.Variables;
import com.mentonica.mcsub.get.parser.Parse;
import com.mentonica.mcsub.get.site.Get;
import com.mentonica.mcsub.get.site.Lines;
import com.mentonica.mcsub.set.SVariables;
import com.mentonica.mcsub.set.site.Set;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

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
                        try {
                            Set.set();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        SVariables.playersDone.clear();
                    }
                },
                0, (60 * 1000)
        );
    }
}
