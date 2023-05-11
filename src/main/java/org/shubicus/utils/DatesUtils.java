package org.shubicus.utils;

import org.tinylog.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.google.common.base.Preconditions.checkArgument;

public final class DatesUtils {

    private DatesUtils() {
    }

    public static String getFutureMonthAndDayWithSuffix(int plusDays) {
        LocalDate date = LocalDate.now().plusDays(plusDays);
        int day = date.getDayOfMonth();
        String suffix = getDayOfMonthSuffix(day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        String formattedDate = date.format(formatter).replaceFirst("\\d+", day + suffix);
        Logger.info(formattedDate);
        return formattedDate;
    }

    public static String getFutureMonthAndDay(int plusDays) {
        LocalDate date = LocalDate.now().plusDays(plusDays);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d");
        String formattedDate = date.format(formatter);
        Logger.info(formattedDate);
        return formattedDate;
    }

    private static String getDayOfMonthSuffix(final int n) {
        checkArgument(n >= 1 && n <= 31, "illegal day of month: " + n);

        if (n >= 11 && n <= 13) {
            return "th";
        }

        switch (n % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }
}
