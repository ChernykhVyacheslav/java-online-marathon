package com.chernykh.sprint09.task2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static String getDateAfterToday(int years, int months, int days) {
        return LocalDate.now()
                .plusYears(years).plusMonths(months).plusDays(days)
                .format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
