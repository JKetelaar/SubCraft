package com.mentonica.SubCraft.get.data;

import java.io.File;
import java.util.ArrayList;

public class Variables {

    private static File pluginFolder;

    private static String TPlayer;

    private static String ServerKey;

    private static String urlContent;

    private static String command;

    private static int invcheck;

    private static int invamount;

    private static String commandid;

    private static boolean able;

    private static boolean error;

    private static boolean full;

    private static String SubCraftKey;

    private static boolean ConfigExists;

    public static ArrayList<String> splittedArray = new ArrayList<String>();

    public static ArrayList<String> addedPlayers = new ArrayList<String>();

    public static boolean isConfigExists() {
        return ConfigExists;
    }

    public static void setConfigExists(boolean configExists) {
        ConfigExists = configExists;
    }

    public static File getPluginFolder() {
        return pluginFolder;
    }

    public static void setPluginFolder(File pluginFolder) {
        Variables.pluginFolder = pluginFolder;
    }

    public static String getSubCraftKey() {
        return SubCraftKey;
    }

    public static void setSubCraftKey(String subCraftKey) {
        SubCraftKey = subCraftKey;
    }

    public static ArrayList<String> getAddedPlayers() {
        return addedPlayers;
    }

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

    public static int getInvcheck() {
        return invcheck;
    }

    public static int getInvamount() {
        return invamount;
    }

    public static void setInvcheck(int invcheck) {
        Variables.invcheck = invcheck;
    }

    public static void setInvamount(int invamount) {
        Variables.invamount = invamount;
    }

    public static String getCommandid() {
        return commandid;
    }

    public static void setCommandid(String commandid) {
        Variables.commandid = commandid;
    }

    public static boolean isAble() {
        return able;
    }

    public static void setAble(boolean able) {
        Variables.able = able;
    }

    public static boolean isError() {
        return error;
    }

    public static void setError(boolean error) {
        Variables.error = error;
    }

    public static boolean isFull() {
        return full;
    }

    public static void setFull(boolean full) {
        Variables.full = full;
    }
}
