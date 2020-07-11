package com.chernykh.sprint07.task2;

import java.time.LocalDate;

public class Util {

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

