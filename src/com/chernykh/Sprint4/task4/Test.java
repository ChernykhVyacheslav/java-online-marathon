package com.chernykh.Sprint4.task4;

public class Test {

    public static void main(String[] args) {

        Integer[] numbers = new Integer[3];
        int numberFromSecondPosition = ArrayUtil.<Integer>setAndReturn(numbers, 52, 1);
        System.out.println(numberFromSecondPosition);

        String[] words = new String[3];
        String wordFromSecondPosition = ArrayUtil.<String>setAndReturn(words, "Hello", 1);
        System.out.println(wordFromSecondPosition);
    }
}
