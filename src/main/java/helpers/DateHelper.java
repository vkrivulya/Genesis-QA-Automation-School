package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateHelper {

    private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";

    public static String getCurrentDate() {
        return new SimpleDateFormat(DATE_FORMAT_PATTERN).format(new Date());
    }
}
