package com.paypal.bfs.test.bookingserv.validation.utli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class DateTimeFormatValidator {

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public boolean isValidDate(String input) {
        try {
            dateFormat.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public boolean isValidDateTime(String input) {
        try {
            dateTimeFormat.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
