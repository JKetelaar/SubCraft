package com.mentonica.SubCraft.writer;

import com.mentonica.SubCraft.get.data.Variables;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Write {
    public static void writeConfigFile(File cf) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(cf, "UTF-8");
        writer.println(Variables.getServerKey());
    }
}
