package com.chernykh.sprint09.task4;

import java.io.*;

public class Utils {

    public static String readFile(String filename) {
        File file = new File(filename);

        try (FileInputStream fis = new FileInputStream(file);

             BufferedInputStream bis = new BufferedInputStream(fis);

             DataInputStream dis = new DataInputStream(bis)) {

            String[] text = new String(dis.readAllBytes()).split("(?<=\\G.{7})");

            StringBuilder result = new StringBuilder();

            for (String s :
                    text) {
                result.append(parseBinaryString(s));
            }

            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String parseBinaryString(String binaryString) {
        return String.valueOf((char) Integer.parseInt(binaryString, 2));
    }
}
