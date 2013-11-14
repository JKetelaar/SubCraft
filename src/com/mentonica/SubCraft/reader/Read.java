package com.mentonica.SubCraft.reader;

import com.mentonica.SubCraft.get.data.Variables;
import com.mentonica.SubCraft.writer.Write;

import java.io.File;
import java.io.IOException;

public class Read {

    public static void ReadFolder() {
        File f = Variables.getPluginFolder();
        if (!f.exists()) {
            CreateFolder(f);
        }
    }

    private static void CreateFolder(File f) {
        f.mkdir();
    }

    public static boolean FReadConfigFile() {
        File cf = new File(Variables.getPluginFolder() + "/config.yml");
        if (!cf.exists()) {
            return false;
        }
        return true;
    }

    public static void ReadConfigFile() throws IOException {
        File cf = new File(Variables.getPluginFolder() + "/config.yml");
        if (!cf.exists()) {
            Write.writeConfigFile(cf);
        }
    }


}
