package com.chernykh.sprint05.task4;

public class CodeException extends RuntimeException {
    public CodeException(String value) {
        super("Incorrect value " + value +
                " for code (should contains exactly 10 digits)");
    }
}
