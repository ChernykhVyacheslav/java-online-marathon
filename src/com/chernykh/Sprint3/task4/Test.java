package com.chernykh.Sprint3.task4;

public class Test {

    public static void main(String[] args) {
        System.out.println(MyUtils.drawLine(LineType.DASHED));
        System.out.println(MyUtils.drawLine(LineType.DOTTED));
        System.out.println(MyUtils.drawLine(LineType.DOUBLE));
        System.out.println(MyUtils.drawLine(LineType.SOLID));
    }

}
