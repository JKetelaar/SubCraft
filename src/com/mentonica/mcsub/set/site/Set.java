package com.mentonica.mcsub.set.site;

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
        for (String s : SVariables.getPlayersDone()) {
            String URL_LOCATION = "http://mentonica.com/dev/dutchrastacraft/api/set.php?commandid=" + s;
            url = new URL(URL_LOCATION);
            URLConnection conn = url.openConnection();
            new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
        }
        System.out.println("All accounts are set");
    }
}
