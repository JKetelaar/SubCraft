package com.mentonica.subcraft.writer;

import com.mentonica.subcraft.get.data.Variables;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Write {
    public static void writeConfigFile(File cf) throws IOException {
        cf.createNewFile();
        FileWriter fw = new FileWriter(cf.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(Variables.getServerKey());
        bw.close();
    }
}
