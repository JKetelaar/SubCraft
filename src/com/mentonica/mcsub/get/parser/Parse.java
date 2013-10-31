package com.mentonica.mcsub.get.parser;

import com.mentonica.mcsub.get.data.Variables;

public class Parse {
    public static void parse(){
        for (String s : Variables.getSplittedArray()){
            String[] t = s.split("%20");
//            System.out.println(t[0]);
//            System.out.println(t[1]);
//            System.out.println(t[2]);
//            System.out.println(t[3]);
        }
    }
}
