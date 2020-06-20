package com.chernykh.Sprint3.task2;

public class Test {

    public static void main(String[] args) {
        NameList nameList = new NameList();

        NameList.Iterator iterator = nameList.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
