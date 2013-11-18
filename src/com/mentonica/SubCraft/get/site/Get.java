package com.mentonica.subcraft.get.site;

import com.mentonica.subcraft.get.data.Constants;
import com.mentonica.subcraft.get.data.Variables;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Get extends JavaPlugin {

    public static void getUsers() throws Exception {
        if (Variables.isAble()) {
            URL url;
            String content = null;
            try {
                String URL_LOCATION = Constants.URL_LOCATION + "get.php?key=" + Variables.getServerKey();

                url = new URL(URL_LOCATION);

                URLConnection conn = url.openConnection();


                BufferedReader br = new BufferedReader(

                        new InputStreamReader(conn.getInputStream()));

                String inputLine;

                while ((inputLine = br.readLine()) != null) {
                    content = inputLine;
                }
                br.close();
                Variables.setUrlContent(content);

                String t = "No results found.";
                String f = "An error occurred, please contact the system administrator.";
                if (Variables.getUrlContent().toString().equals(t) || Variables.getUrlContent().toString().equals(f)) {
                    Variables.setAble(false);
                }

            } catch (MalformedURLException e) {
            } catch (IOException e) {
            }
        }
    }
}
