package com.chernykh.sprint7.task3;

@TestSuite({"m1", "m2"})
public class Class1{
    public void m2(){
        System.out.println("Hello");
    }

    public void m1(){
        System.out.println("Hello");
    }
}

@TestSuite({"method1", "method2", "method5"})
class Suite1{

    String method1(){
        return "inside method1";
    }
    public void method2(){
        System.out.println("from void method 2");
    }

    public void method3(){
    }
}