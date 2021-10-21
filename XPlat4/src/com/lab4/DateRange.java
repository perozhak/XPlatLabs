package com.lab4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateRange {
    private static LocalDate minDate;
    private static LocalDate maxDate;
    private static Boolean isEmpty;

    public DateRange() {
        this.isEmpty = true;
    }

    public static String getRange() {
        return minDate
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                .toString()
                + " - "
                + maxDate
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                .toString();
    }

    public static LocalDate getMaxDate() {
        return maxDate;
    }

    public static LocalDate getMinDate() {
        return minDate;
    }

    public static void setMaxDate(LocalDate maxDate) {
        DateRange.maxDate = maxDate;
    }

    public static void setMinDate(LocalDate minDate) {
        DateRange.minDate = minDate;
    }

    public static Boolean IsEmpty() {
        return isEmpty;
    }

    public static void setNotEmpty() {
        DateRange.isEmpty = false;
    }
}
