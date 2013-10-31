package com.mentonica;

import com.mentonica.mcsub.get.parser.Parse;
import com.mentonica.mcsub.get.site.Get;
import com.mentonica.mcsub.get.site.Lines;
import com.mentonica.mcsub.set.Variables;
import com.mentonica.mcsub.set.site.Set;

public class Boot {
    public static void main(String[] args) throws Exception {
        Get.getUsers();
        Lines.seperate();
        Parse.parse();
        Variables.playersDone.add("Jelle");
        Set.set();
    }
}
