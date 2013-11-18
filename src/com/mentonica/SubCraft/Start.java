package com.mentonica.subcraft;

import com.mentonica.subcraft.get.data.Variables;
import com.mentonica.subcraft.get.parser.Parse;
import com.mentonica.subcraft.get.site.Get;
import com.mentonica.subcraft.get.site.Lines;
import com.mentonica.subcraft.set.SVariables;
import com.mentonica.subcraft.set.site.Set;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class Start extends JavaPlugin {

    public static void startTimer() {
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        if (!Variables.isError()) {
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
                    }
                },
                0, (60 * 1000)
        );
    }
}
