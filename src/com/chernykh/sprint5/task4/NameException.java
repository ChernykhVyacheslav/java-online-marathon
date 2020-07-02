package com.chernykh.sprint5.task4;

public class NameException extends RuntimeException {
    public NameException(String field, String value) {
        super("Incorrect value " + value + " for " + field +
                " (should start from upper case and contains only alphabetic characters and symbols -, _)");
    }
}
