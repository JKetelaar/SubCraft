package com.mentonica.mcsub.set.site;

import com.mentonica.mcsub.set.Variables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Set {
    private static URL url;

    public static void set() throws IOException {
        for (String s : Variables.getPlayersDone()) {
            String URL_LOCATION = "http://spooner.accountservergroup.com/~mentonic/dev/dutchrastacraft/api/set.php?user=" + s;
            url = new URL(URL_LOCATION);
            URLConnection conn = url.openConnection();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
        }
    }
}
