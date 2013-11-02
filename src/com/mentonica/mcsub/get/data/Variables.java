package com.mentonica.mcsub.get.data;

import java.util.ArrayList;

public class Variables {

    private static String TPlayer;

    private static String ServerKey;

    private static String urlContent;

    private static String command;

    public static ArrayList<String> splittedArray = new ArrayList<String>();

    public static String getServerKey() {
        return ServerKey;
    }

    public static void setServerKey(String serverKey) {
        ServerKey = serverKey;
    }

    public static String getUrlContent() {
        return urlContent;
    }

    public static void setUrlContent(String urlContent) {
        Variables.urlContent = urlContent;
    }

    public static ArrayList<String> getSplittedArray() {
        return splittedArray;
    }

    public static String getTPlayer() {
        return TPlayer;
    }

    public static void setTPlayer(String TPlayer) {
        Variables.TPlayer = TPlayer;
    }

    public static String getCommand() {
        return command;
    }

    public static void setCommand(String command) {
        Variables.command = command;
    }

}
