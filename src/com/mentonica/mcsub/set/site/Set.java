package com.mentonica.mcsub.set.site;

import com.mentonica.mcsub.get.data.Constants;
import com.mentonica.mcsub.get.data.Variables;
import com.mentonica.mcsub.set.SVariables;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Set extends JavaPlugin {
    private static URL url;

    public static void set() throws IOException {
        if (SVariables.playersDone.size() > 0) {
            for (String s : SVariables.getPlayersDone()) {
                String URL_LOCATION = Constants.URL_LOCATION + "set.php?commandid=" + s + "&key=" + Variables.getServerKey();
                url = new URL(URL_LOCATION);
                URLConnection conn = url.openConnection();
                new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
            }
            System.out.println("All id's are set to done");
        } else {
            System.out.println("No id's are available to be set to done");
        }
    }
}