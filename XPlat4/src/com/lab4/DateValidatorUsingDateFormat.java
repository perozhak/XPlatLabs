package com.lab4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

interface DateValidator {
    boolean isValid(String dateStr);
}

public class DateValidatorUsingDateFormat implements DateValidator {
    private String dateFormat;

    public DateValidatorUsingDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}