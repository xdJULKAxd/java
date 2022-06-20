package pl.julka99.libraryservice.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;

public class DateHelper {
    public static Date convertToDate(String stringDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(stringDate);
        } catch (ParseException e) {
            throw new DateTimeException(e.getMessage(), e);
        }
    }
}
