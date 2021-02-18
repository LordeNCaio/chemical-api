package com.chemicalgears.chemicalapi.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateTimeHelpers {

    /**
     * Convert LocalDateTime to java Date object
     * @param localDateTime Default LocalDateTime object
     * @return a Date object converted given parameter
     */
    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
