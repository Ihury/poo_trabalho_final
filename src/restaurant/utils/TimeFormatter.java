package restaurant.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormatter {
  public static String formatTime(Date time) {    
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    return formatter.format(time);
  }
}
