package com.chernykh.sprint09.task1;

import java.time.LocalDate;

public class Utils {

    public static boolean isLeapYear(int year) {
        return LocalDate.ofYearDay(year, 1).isLeapYear();
    }
}
