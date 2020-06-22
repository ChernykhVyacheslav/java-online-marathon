package com.chernykh.Sprint3.task6;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        String[] expected = {"First name: Karen, Last name: Davis, Address: Address #2",
                "First name: Steven, Last name: Taylor, Address: Address #3",
                "First name: Susan, Last name: Brown, Address: Address #4"};
        String[] actual = new String[3];
        AddressBook addressBook = new AddressBook(4);
        addressBook.create("John", "Brown", "Address #1");
        addressBook.create("Karen", "Davis", "Address #2");
        addressBook.create("Steven", "Taylor", "Address #1");
        addressBook.create("Susan", "Brown", "Address #4");
        addressBook.update("Steven", "Taylor", "Address #3");
        addressBook.delete("John", "Brown");
        int counter = 0;
        for (Object record : addressBook)
            actual[counter++] = record.toString();
        System.out.println(Arrays.equals(expected, actual));
    }
}