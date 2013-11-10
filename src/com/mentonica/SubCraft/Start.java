package com.mentonica.SubCraft;

import com.mentonica.SubCraft.get.data.Variables;
import com.mentonica.SubCraft.get.parser.Parse;
import com.mentonica.SubCraft.get.site.Get;
import com.mentonica.SubCraft.get.site.Lines;
import com.mentonica.SubCraft.set.SVariables;
import com.mentonica.SubCraft.set.site.Set;
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
                            //System.out.println("We're here");
                        }
                    }
                },
                0, (60 * 1000)
        );
    }
}
