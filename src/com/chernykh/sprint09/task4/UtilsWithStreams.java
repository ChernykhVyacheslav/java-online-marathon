package com.chernykh.sprint09.task4;

import java.io.*;
import java.util.stream.Stream;

public class UtilsWithStreams {

    public static String readFile(String filename) {
        File file = new File(filename);

        try (FileInputStream fis = new FileInputStream(file);

             BufferedInputStream bis = new BufferedInputStream(fis);

             DataInputStream dis = new DataInputStream(bis)) {

            String text = new String(dis.readAllBytes());

            StringBuilder result = new StringBuilder();

            Stream.of(text.split("(?<=\\G.{7})"))
                    .map(UtilsWithStreams::parseBinaryString).forEach(result::append);

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
