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
    static String content = null;

    public static void set() throws IOException {
        if (SVariables.playersDone.size() >= 1) {
            for (String s : SVariables.getPlayersDone()) {
                String URL_LOCATION = Constants.URL_LOCATION + "set.php?commandid=" + s + "&key=" + Variables.getServerKey();
                url = new URL(URL_LOCATION);
                URLConnection conn = url.openConnection();
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));


                String inputLine;

                while ((inputLine = br.readLine()) != null) {
                    content = inputLine;
                }
                br.close();
            }
            if (content.toString() != "Successfully set all commands to done.") {
                System.out.println("Error occured, please contact an administrator");
                Variables.setError(true);
            }
        }
    }
}
