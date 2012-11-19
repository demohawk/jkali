package com.jkali.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class CalendarUtil {
	public static final long WORKTIME = 8;
	public static final long SECOND_ms=1000;
	public static final long MINUTE_ms=60*SECOND_ms;
	public static final long HOUR_ms=60*MINUTE_ms;
	public static final long DAY_ms=24*HOUR_ms;
	public static final long WEEK_ms=DateTime.calendarInstance().getLeastMaximum(Calendar.DAY_OF_WEEK)*DAY_ms;
	public static final long MONTH_ms=DateTime.calendarInstance().getLeastMaximum(Calendar.DAY_OF_MONTH)*DAY_ms;
	public static final long YEAR_ms=DateTime.calendarInstance().getLeastMaximum(Calendar.DAY_OF_YEAR)*DAY_ms;
	

	private CalendarUtil() {
	}

	public static Date min(Date date, Date date1) {
		return date.before(date1) ? date : date1;
	}

	public static Date max(Date date, Date date1) {
		return date.after(date1) ? date : date1;
	}

	public static int compareEra(Calendar calendar, Calendar calendar1) {
		if(calendar.getClass() != calendar1.getClass())
			throw new IllegalArgumentException("Cannot compare calendars of dissimilar classes: " + calendar + ", " + calendar1);
		else
			return calendar.get(Calendar.ERA) - calendar1.get(Calendar.ERA);
	}

	public static int compareYear(Calendar calendar, Calendar calendar1) {
		int i = compareEra(calendar, calendar1);
		if(i != 0)
			return i;
		else
			return calendar.get(Calendar.YEAR) - calendar1.get(Calendar.YEAR);
	}

	public static int compareMonth(Calendar calendar, Calendar calendar1) {
		int i = compareYear(calendar, calendar1);
		if(i != 0)
			return i;
		else
			return calendar.get(Calendar.MONTH) - calendar1.get(Calendar.MONTH);
	}

	public static int compareDay(Calendar calendar, Calendar calendar1) {
		int i = compareYear(calendar, calendar1);
		if(i != 0)
			return i;
		else
			return calendar.get(Calendar.DAY_OF_YEAR) - calendar1.get(Calendar.DAY_OF_YEAR);
	}

	
		
	
	public static void secondFloor(Calendar calendar) {
		calendar.set(Calendar.MILLISECOND, 0);
	}

	public static void minuteFloor(Calendar calendar) {
		secondFloor(calendar);
		calendar.set(Calendar.SECOND, 0);
	}
	public static void minuteFloor(Calendar calendar,int number) {
		secondFloor(calendar);
		calendar.set(Calendar.SECOND, 0);
		if (number>1){
			int minutes=calendar.get(Calendar.SECOND);
			calendar.set(Calendar.SECOND,(minutes/number)*number);
		}
	}

	public static void hourFloor(Calendar calendar) {
		minuteFloor(calendar);
		calendar.set(Calendar.MINUTE, 0);
	}
	public static void hourFloor(Calendar calendar,int number) {
		minuteFloor(calendar);
		calendar.set(Calendar.MINUTE, 0);
		if (number>1){
			int hours=calendar.get(Calendar.HOUR);
			calendar.set(Calendar.HOUR,(hours/number)*number);
		}
	}

	public static void dayFloor(Calendar calendar) {
		hourFloor(calendar);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
	}

	public static void weekFloor(Calendar calendar) {
		int i = calendar.get(Calendar.YEAR);
		int k = calendar.get(Calendar.DAY_OF_YEAR);
		int l = calendar.get(Calendar.DAY_OF_WEEK);
		int i1 = calendar.getFirstDayOfWeek();
		int j1 = l - i1;
		if(j1 > 0) {
			k -= j1;
		} else
		if(j1 < 0) {
			k -= 7 + j1;
		}
		calendar.clear();
		boolean flag = calendar.isLenient();
		if(!flag) {
			calendar.setLenient(true);
		}
		calendar.set(Calendar.YEAR, i);
		calendar.set(Calendar.DAY_OF_YEAR, k);
		if(!flag) {
			int j = calendar.get(Calendar.YEAR);
			calendar.setLenient(false);
		}
	}

	public static void monthFloor(Calendar calendar) {
		dayFloor(calendar);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
	}
	public static void monthFloor(Calendar calendar,int number) { //number param for quarter and half
		dayFloor(calendar);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		if (number>1){
			int month=calendar.get(Calendar.MONTH);
			calendar.set(Calendar.MONTH,(month/number)*number);
		}
	}

	public static void yearFloor(Calendar calendar) {
		monthFloor(calendar);
		calendar.set(Calendar.MONTH, 0);
	}
	
	public static void floor(Calendar calendar,int field){
		floor(calendar, field,1);
	}
	public static void floor(Calendar calendar,int field,int number){
		switch (field) {
			case Calendar.YEAR :yearFloor(calendar);			
				break;
			case Calendar.MONTH :monthFloor(calendar,number);			
				break;
			case Calendar.WEEK_OF_YEAR :weekFloor(calendar);			
				break;
			case Calendar.DAY_OF_WEEK :dayFloor(calendar);			
				break;
			case Calendar.DAY_OF_MONTH :dayFloor(calendar);			
				break;
			case Calendar.HOUR_OF_DAY :hourFloor(calendar,number);			
				break;
			case Calendar.MINUTE :minuteFloor(calendar,number);			
				break;
			case Calendar.SECOND :secondFloor(calendar);			
				break;
		}
	}
	
	public static long getMinDuration(int field){
		switch (field) {
			case Calendar.YEAR : return YEAR_ms;			
			case Calendar.MONTH : return MONTH_ms;
			case Calendar.WEEK_OF_YEAR : return WEEK_ms;
			case Calendar.DAY_OF_WEEK : return DAY_ms;
			case Calendar.DAY_OF_MONTH : return DAY_ms;
			case Calendar.HOUR_OF_DAY : return HOUR_ms;
			case Calendar.MINUTE : return MINUTE_ms;
			case Calendar.SECOND : return SECOND_ms;
		}
		return -1;
		
	}
	
	/**
	 * Don't use in loops. DateFormat and Date have to be reused
	 * @param t
	 * @return
	 */
	public static String toString(long t){
		Calendar calendar=DateTime.calendarInstance();
		calendar.setTimeInMillis(t);
		return toString(calendar);
	}
	public static String toString(Calendar calendar){
		DateFormat df = DateFormat.getDateTimeInstance();
		return df.format(calendar.getTime());
	}
	
	public static long toLongTime(double t){
		return Math.round(t/1000)*1000;
	}
	public static long roundTime(double dt,Calendar tmp){
		long t=toLongTime(dt);
		tmp.setTimeInMillis(t);
		int sec=tmp.get(Calendar.SECOND);
		return (sec>30)?t+(60-sec):t-sec;
	}
	public static void roundTime(Calendar c){
		c.setTimeInMillis(roundTime(c.getTimeInMillis(),c));
	}

	/**
	 * 计算两个日期之间的间隔天数
	 * 
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return 间隔天数
	 */
	public static Long getIntervalDays(String startDate, String endDate) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date beginTime = sdf.parse(startDate);
			Date endTime = sdf.parse(endDate);
			// 默认为毫秒，除以1000是为了转换成秒
			long interval = (endTime.getTime() - beginTime.getTime()) / 1000;// 秒
			long day = interval / (24 * 3600);// 天

			return day;
		} catch (Exception e) {
		}
		return 0l;
	}

	public static boolean beforeAndAfterDays(String startDate, String endDate)
			throws ParseException {	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date beginTime = sdf.parse(startDate);
			Date endTime = sdf.parse(endDate);
			return beginTime.before(endTime);
		
	}


	public static String max(String startDate, String endDate)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date beginTime = sdf.parse(startDate);
		Date endTime = sdf.parse(endDate);
		return beginTime.after(endTime) ? startDate : endDate;

	}

	/**
	 * 根据起始日期和间隔天数查询结束日期
	 * 
	 * @param startDate
	 *            开始日期
	 * @param days
	 *            间隔天数
	 * @return 结束日期
	 */
	public static String getNewDate(String startDate, Long days) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date beginTime = sdf.parse(startDate);
			Long interval = days * 24 * 3600;
			Long end = beginTime.getTime() + interval * 1000;
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(end);

			return (new SimpleDateFormat("yyyy-MM-dd")).format(c.getTime());
		}
		catch (Exception e) {
		}
		return null;
	}

	/**
	 * 判断日期格式是否正确
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            格式
	 * @return
	 */
	public static boolean isRightFormat(String date, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date time = sdf.parse(date);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

}
