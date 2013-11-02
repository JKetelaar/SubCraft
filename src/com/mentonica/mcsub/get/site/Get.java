package com.mentonica.mcsub.get.site;

import com.mentonica.mcsub.get.data.Variables;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Get extends JavaPlugin {

    public static void getUsers() throws Exception {
        URL url;
        String content = null;
        try {
            String URL_LOCATION="http://spooner.accountservergroup.com/~mentonic/dev/dutchrastacraft/api/get.php?key=" + Variables.getServerKey();

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

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
