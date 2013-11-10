package com.mentonica.SubCraft.players;

import com.mentonica.SubCraft.get.data.Constants;
import com.mentonica.SubCraft.get.data.Variables;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Insert extends JavaPlugin {
    private static URL url;
    public static void insertPlayer(String rank, String playerName) throws IOException {
        if (!Variables.addedPlayers.contains(playerName)){
            String URL_LOCATION = Constants.URL_LOCATION + "player.php?username=" + playerName + "&rank=" + rank;
            url = new URL(URL_LOCATION);
            URLConnection conn = url.openConnection();
            new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            Variables.addedPlayers.add(playerName);
            System.out.println(URL_LOCATION);
        }
    }
}
