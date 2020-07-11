package com.chernykh.sprint7.task2.task2test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {
        try {
            Method method = Util.class.getDeclaredMethod("review", String.class);
            method.invoke(new Util(), "com.chernykh.sprint7.task2.task2test.Class3");
        }
        catch (Exception e) {
            System.out.println("Oops");
        }
    }
}

class Util {

    public static void review(String className) {
        try {
            Class<?> providedClass = Class.forName(className);
            if(providedClass.isAnnotationPresent(Review.class)) {
                Review review = providedClass.getAnnotation(Review.class);
                String dateString = "today".equals(review.date()) ? LocalDate.now().toString() : review.date();
                System.out.println("Class " + className + " was reviewed "
                        + dateString + " by " +
                        review.reviewer() + ".");
            } else {
                System.out.println("Class " + className + " isn't marked as Reviewed");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class " + className + " was not found");
        }
    }
}

@Review(reviewer = "me")
class Class3 {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Review {

    public String reviewer();
    public String date() default "today";
}