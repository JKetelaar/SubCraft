package com.mentonica.mcsub.get.site;

import com.mentonica.mcsub.get.data.Variables;

public class Lines {
    public static void seperate(){
        String full = Variables.getUrlContent();
        String[] splitted = full.split("<br/>");

        for (String s : splitted){
            Variables.splittedArray.add(s);
        }
    }
}
