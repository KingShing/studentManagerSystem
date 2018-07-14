package pojo.tool;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date parseDate(String value) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    ParsePosition pos = new ParsePosition(0);
		    Date strtodate = formatter.parse(value, pos);
		    return strtodate;
	}

	public static String formatDateTime(Date fieldVal) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   String dateString = formatter.format(fieldVal);
		  return dateString;		
	}	
}
