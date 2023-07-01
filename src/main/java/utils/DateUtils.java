package utils;

import java.time.LocalDateTime;

public class DateUtils {

    public static int getCurrentYear(){
        return LocalDateTime.now().getYear();
    }
}
