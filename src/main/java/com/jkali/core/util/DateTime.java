package com.jkali.core.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.time.DateUtils;


/**
 * Utility methods on Date
 */
public class DateTime {
	
	public static GregorianCalendar calendarInstance() {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTimeZone(DateUtils.UTC_TIME_ZONE);
		return cal;
	}
	public static GregorianCalendar calendarInstance(int year, int month, int day) {
		GregorianCalendar cal = calendarInstance();
		setCalendar(year, month, day, cal);
		return cal;	
	}
	public static void setCalendar(int year, int month, int day,Calendar cal) {
		cal.set(Calendar.YEAR,year);
		cal.set(Calendar.MONTH,month);
		cal.set(Calendar.DAY_OF_MONTH,day);
		cal.set(Calendar.HOUR_OF_DAY,0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		cal.set(Calendar.MILLISECOND,0);
	}

	public static SimpleDateFormat dateFormatInstance() {
		return (SimpleDateFormat) SimpleDateFormat.getInstance();
//		SimpleDateFormat f = new SimpleDateFormat();
//		f.setTimeZone(DateUtils.UTC_TIME_ZONE);
//		return f;
	}
	public static SimpleDateFormat utcDateFormatInstance() {
		SimpleDateFormat f = new SimpleDateFormat();
		f.setTimeZone(DateUtils.UTC_TIME_ZONE);
		return f;
	}
	public static ExtendedDateFormat extendedUtcDateFormatInstance() {
		ExtendedDateFormat f = new ExtendedDateFormat();
		f.setTimeZone(DateUtils.UTC_TIME_ZONE);
		return f;
	}
	
	public static DateFormat utcShortDateFormatInstance() {
		DateFormat f = DateFormat.getDateInstance(DateFormat.SHORT);
		f.setTimeZone(DateUtils.UTC_TIME_ZONE);
		return f;
	}
	public static SimpleDateFormat dateFormatInstance(String pattern) {
		SimpleDateFormat f = new SimpleDateFormat(pattern);
//		SimpleDateFormat f = new SimpleDateFormat();
		f.setTimeZone(DateUtils.UTC_TIME_ZONE);
		return f;
	}
	
	
	public static long midnightToday() {
		GregorianCalendar cal = calendarInstance();
		return dayFloor(cal.getTimeInMillis());
	}
	public static long midnightTomorrow() {
		GregorianCalendar cal = calendarInstance();
		cal.add(Calendar.DATE,1);
		return dayFloor(cal.getTimeInMillis());
	}

	public static long midnightNextDay(long d) {
		d = dayFloor(d);
		GregorianCalendar cal = calendarInstance();
		cal.setTimeInMillis(d);
		cal.add(Calendar.DATE,1);
		return cal.getTimeInMillis();
	}
	
	private static Date zeroDateInstance = null; // flyweight for 0 date
	public static Date getZeroDate() {
		if (zeroDateInstance == null) {
			zeroDateInstance = new Date(0);
		}
		return zeroDateInstance;
	}
	public static Date NA_TIME= new Date(1); // 1 ms after time 0

	private static Calendar maxCalendarInstance = null; // flyweight for maximum allowed date
	public static Calendar getMaxCalendar() {
		if (maxCalendarInstance == null) {
			maxCalendarInstance = calendarInstance(2050,Calendar.JANUARY,0);
		}
		return maxCalendarInstance;
	}
	private static Calendar zeroCalendarInstance = null; // flyweight for zeroimum allowed date
	public static Calendar getZeroCalendar() {
		if (zeroCalendarInstance == null) {
			zeroCalendarInstance = DateTime.calendarInstance();
			zeroCalendarInstance.setTimeInMillis(0);
		}
		return zeroCalendarInstance;
	}
	private static Date maxDateInstance = null; // flyweight for maximum allowed date
	public static Date getMaxDate() {
		if (maxDateInstance == null) {
			maxDateInstance = getMaxCalendar().getTime();
		}
		return maxDateInstance;
	}
	
	public static Date max(Date date1, Date date2) {
		return date1.after(date2) ? date1 : date2;
	}
	public static Date min(Date date1, Date date2) {
		return date1.before(date2) ? date1 : date2;
	}


	public static long closestDate(double value) {
		return closestDate(Math.round(value));
	}
	public static long closestDate(long date) {
		Calendar cal = DateTime.calendarInstance();
		cal.setTimeInMillis(date);
	//	cal.set(Calendar.SECOND,0); // now going to seconds
		cal.set(Calendar.MILLISECOND,0);
		return cal.getTimeInMillis();
	}
	public static long hourFloor(long date) {
		Calendar cal = DateTime.calendarInstance();
		cal.setTimeInMillis(date);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		cal.set(Calendar.MILLISECOND,0);
		
		return cal.getTimeInMillis();
	}
	public static long dayFloor(long date) {
		Calendar cal = DateTime.calendarInstance();
		cal.setTimeInMillis(date);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		cal.set(Calendar.MILLISECOND,0);
		cal.set(Calendar.HOUR_OF_DAY,0);
		return cal.getTimeInMillis();
	}
	public static Date dayFloor(Date date) {
		return new Date(dayFloor(date.getTime()));
	}
	public static long minuteFloor(long date) {
		Calendar cal = DateTime.calendarInstance();
		cal.setTimeInMillis(date);
		cal.set(Calendar.MILLISECOND,0);
		cal.set(Calendar.SECOND,0);
		
		return cal.getTimeInMillis();
	}

	public static long nextDay(long day) {
		GregorianCalendar d = DateTime.calendarInstance();
		d.setTimeInMillis(day);
		d.add(GregorianCalendar.DAY_OF_MONTH,1);
		return d.getTimeInMillis();
	}

	public static long hour24() {
		GregorianCalendar cal = DateTime.calendarInstance();
		cal.setTimeInMillis(0);
		cal.set(GregorianCalendar.HOUR_OF_DAY,24);
		return cal.getTimeInMillis();
	}
	
	public static long gmt(Date date) {
		if (date==null) 
			return 0;
		return date.getTime() - 60000L * date.getTimezoneOffset();
	}
	public static Date fromGmt(Date date) {
		if (date==null) 
			return null;
		return new Date(date.getTime() + 60000L * date.getTimezoneOffset());
	}
	public static long fromGmt(long d) {
		if (d==0) 
			return 0;
		Date date = new Date(d);
		return new Date(date.getTime() + 60000L * date.getTimezoneOffset()).getTime();
		
	}
	public static Date gmtDate(Date date) {
		return new Date(gmt(date));
	}
	
	/**
	 * Get an integer for the date in form YYYYMMDD where the months go from 1 to 12 (unlike calendar where they go from 0 to 11)
	 * @param date
	 * @return
	 */
	public static int toId(long date) {
		GregorianCalendar cal = DateTime.calendarInstance();
		cal.setTimeInMillis(date);
		return cal.get(Calendar.YEAR) * 10000 + (1+cal.get(Calendar.MONTH)) * 100 + cal.get(Calendar.DAY_OF_MONTH);
	}
	/**
	 * Get an integer for the date in form YYYYMMDD where the months go from 1 to 12 (unlike calendar where they go from 0 to 11)
	 * @param date
	 * @return
	 */
	public static long fromId(int id) {
		GregorianCalendar cal = DateTime.calendarInstance(id/10000,(id/100)%100-1,id%100);
		return cal.getTimeInMillis();
		
	}
	
	/**
	 * Get an integer for the date in form YYYYMMDD where the months go from 1 to 12 (unlike calendar where they go from 0 to 11)
	 * @param date
	 * @return
	 */
	public static int currentToYYMM() {
		GregorianCalendar cal = DateTime.calendarInstance();
		return (cal.get(Calendar.YEAR) % 100) * 100 + (1+cal.get(Calendar.MONTH));
		
	}
	
	
	 private static final long ONE_HOUR = 60 * 60 * 1000L;
	 public static long daysBetween(Date d1, Date d2){
	    return ( (d2.getTime() - d1.getTime() + ONE_HOUR) / 
	                  (ONE_HOUR * 24));
	  }
}
