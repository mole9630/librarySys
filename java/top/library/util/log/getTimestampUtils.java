package top.library.util.log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mole9630
 */
public class GetTimestampUtils {
    public String getTimestamp() {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
