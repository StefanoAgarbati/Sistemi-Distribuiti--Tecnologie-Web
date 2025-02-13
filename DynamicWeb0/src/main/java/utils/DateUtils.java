package utils;

import java.util.Calendar;

public class DateUtils {
	
	public static DateUtils create() {
		return new DateUtils();
	}
	public static String getDateRep() {
		Calendar calendar = Calendar.getInstance();
		String day = getDayOffWeekRep(calendar.get(Calendar.DAY_OF_WEEK));
		String dayNumber = getNumberOfDayRep(calendar.get(Calendar.DAY_OF_MONTH));
		String month = getMonthRep(calendar.get(Calendar.MONTH));
		String year = getYearRep(calendar.get(Calendar.YEAR));
		String hh = getHours(calendar.get(Calendar.HOUR_OF_DAY));
		String mm = getMinutes(calendar.get(Calendar.MINUTE));
		String rep = getDateRep(day,dayNumber,month,year,hh,mm);
		return rep;
		
	}
	private static String getDateRep(String day, String dayNumber, String month, String year, String hh, String mm) {
		String rep = day + " " + dayNumber + " " + month + "'" + year + " " + hh + ":" + mm;
		return rep;
	}
	private static String getMinutes(int mm) {
		if(mm <= 9)
			return "0"+mm;
		return ""+mm;
	}
	private static String getHours(int hh) {
		return ""+hh;
	}
	private static String getYearRep(int year) {
		return ""+(year - 2000);
	}
	private static String getNumberOfDayRep(int dayNumber) {
		return ""+dayNumber;
	}
	private static String getMonthRep(int month) {
		String monthRep = "";
		switch(month) {
		case 0:
			monthRep = "Jan";
			break;
		case 1:
			monthRep = "Feb";
			break;
		case 2:
			monthRep = "Mar";
			break;
		case 3:
			monthRep = "Apr";
			break;
		case 4:
			monthRep = "May";
			break;
		case 5:
			monthRep = "Jun";
			break;
		case 6:
			monthRep = "Jul";
			break;
		case 7:
			monthRep = "Aug";
			break;
		case 8:
			monthRep = "Sep";
			break;
		case 9:
			monthRep = "Oct";
			break;
		case 10:
			monthRep = "Nov";
			break;
		case 11:
			monthRep = "Dec";
			break;
		}
		return monthRep;
	}
	private static String getDayOffWeekRep(int day) {
		String dayRep = "";
		switch(day) {
		case 1:
			dayRep = "Sun";
			break;
		case 2:
			dayRep = "Mon";
			break;
		case 3:
			dayRep = "Tue";
			break;
		case 4:
			dayRep = "Wed";
			break;
		case 5:
			dayRep = "Thu";
			break;
		case 6:
			dayRep = "Fri";
			break;
		case 7:
			dayRep = "Sat";
			break;
		}
		return dayRep;
	}
}
