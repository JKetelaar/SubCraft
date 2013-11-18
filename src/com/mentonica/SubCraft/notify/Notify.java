package com.mentonica.subcraft.notify;

import com.mentonica.subcraft.get.data.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Notify {
    private static URL url;

    public static void Notification() throws IOException {
        String URL_LOCATION = Constants.URL_LOCATION + "error.php?commandid=";// + s + "&key=" + Variables.getServerKey();
        url = new URL(URL_LOCATION);
        URLConnection conn = url.openConnection();
        new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
    }
}
