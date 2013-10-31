package com.mentonica.mcsub.get.data;

import java.util.ArrayList;

public class Variables {
    private static String urlContent;

    public static ArrayList<String> splittedArray = new ArrayList<String>();

    public static String getUrlContent() {
        return urlContent;
    }

    public static void setUrlContent(String urlContent) {
        Variables.urlContent = urlContent;
    }

    public static ArrayList<String> getSplittedArray() {
        return splittedArray;
    }

}
