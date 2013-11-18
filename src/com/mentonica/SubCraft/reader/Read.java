package com.mentonica.subcraft.reader;

import com.mentonica.subcraft.get.data.Variables;
import com.mentonica.subcraft.writer.Write;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

    public static boolean FReadConfigFile() throws IOException {
        BufferedReader br = null;
        File cf = new File(Variables.getPluginFolder() + "/config.yml");
        if (!cf.exists()) {
            return false;
        } else {
            try {

                String key;

                br = new BufferedReader(new FileReader(Variables.getPluginFolder() + "/config.yml"));

                while ((key = br.readLine()) != null) {
                    Variables.setSubCraftKey(key);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (br != null) br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            return true;
        }
    }

    public static void ReadConfigFile() throws IOException {
        File cf = new File(Variables.getPluginFolder() + "/config.yml");
        if (!cf.exists()) {
            Write.writeConfigFile(cf);
        }
    }


}
