package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDate {
	public static String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		Date date = new Date();
		
		return dateFormat.format(date).toString();
	}
}
