package com.chernykh.sprint09.task3;

import java.io.*;

public class Utils {

    public static void writeFile(String filename, String text) {
        File file = new File(filename);

        try (FileOutputStream fos = new FileOutputStream(file);

             BufferedOutputStream bos = new BufferedOutputStream(fos);

             DataOutputStream dos = new DataOutputStream(bos)) {
            for (byte b :
                    text.getBytes()) {
                dos.writeBytes(String.format("%7s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0'));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
