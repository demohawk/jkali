package com.jkali.core.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;


public class UTIL {
	public static final int DT_LASTDAY_OF_MONTH = 1; // 当前月的最后一天
	public static final int DT_TODAY_IN_LAST_MONTH = 2; // 上一个月的当天
	public static final int DT_FIRSTDAY_OF_MONTH = 3; // 当前月的第一天
	public static final int DT_FIRSTDAY_OF_YEAR = 6; // 当前月的第一天

	/**
	 * Constructor for Common.
	 */
	private UTIL() {
		super();
	}

	/**
	 * 格式化数字
	 * 
	 * @param d
	 *            double
	 * @return String 返回具有2位小数的数字字符串
	 */
	public static String FormatNumber(double d) {
		String retStr = "0.00";
		try {
			DecimalFormat dFormat = new DecimalFormat("#0.00");
			retStr = dFormat.format(d);
			return retStr;
		} catch (Exception e) {
			return retStr;
		}
	}
	
	public static String FormatNumberVar(double d,int n ) {
		String retStr="";
		String FStr="";	
		switch (n){
		case  0: {retStr = "0";FStr="#0";break;}
		case  1: {retStr = "0.0";FStr="#0.0";break;}
		case  2: {retStr = "0.00";FStr="#0.00";break;}
		case  3: {retStr = "0.000";FStr="#0.0000";break;}
		case  4: {retStr = "0.0000";FStr="#0.0000";break;}
		case  5: {retStr = "0.00000";FStr="#0.00000";break;}
		case  6: {retStr = "0.000000";FStr="#0.000000";break;}
        
		
		}
		
		
		
		//String retStr = "0";
		try {
			DecimalFormat dFormat = new DecimalFormat(FStr);
			retStr = dFormat.format(d);
			return retStr;
		} catch (Exception e) {
			return retStr;
		}
	}

	/**
	 * 格式化数字
	 * 
	 * @param d
	 *            double
	 * @return String 返回格式化后的数字字符串
	 */
	public static String FormatNumber(double d, String strFormat) {
		String retStr = "0";
		try {
			DecimalFormat dFormat = new DecimalFormat(strFormat);
			retStr = dFormat.format(d);
			return retStr;
		} catch (Exception e) {
			return retStr;
		}
	}

	/**
	 * 格式化数字
	 * 
	 * @param d
	 *            double
	 * @return String 返回具有2位小数的数字字符串
	 */
	public static String formatNumber(double d) {
		String retStr = "0.00";
		try {
			DecimalFormat dFormat = new DecimalFormat("#0.00");
			retStr = dFormat.format(d);
			return retStr;
		} catch (Exception e) {
			return retStr;
		}
	}
	
	
	public static String formatNumberList(double d) {
		String retStr = "0.00";
		try {
			DecimalFormat dFormat = new DecimalFormat("#0.00");
			retStr = dFormat.format(d);
			if (retStr.equals("0.00") || retStr.equals("-0.00")) {
				retStr="-";
			}
			return retStr;
		} catch (Exception e) {
			return retStr;
		}
	}
	
	public static String formatNumberListRate(double d) {
		String retStr = "0.0000";
		try {
			DecimalFormat dFormat = new DecimalFormat("#0.0000");
			retStr = dFormat.format(d);
			if (retStr.equals("0.0000") || retStr.equals("-0.0000")) {
				retStr="-";
			}
			return retStr;
		} catch (Exception e) {
			return retStr;
		}
	}

	/**
	 * 格式化数字
	 * 
	 * @param d
	 *            double
	 * @return String 返回格式化后的数字字符串
	 */
	public static String formatNumber(double d, String strFormat) {
		String retStr = "0";
		try {
			DecimalFormat dFormat = new DecimalFormat(strFormat);
			retStr = dFormat.format(d);
			return retStr;
		} catch (Exception e) {
			return retStr;
		}
	}

	/**
	 * 获取当前的格式化日期
	 * 
	 * @return String 返回形式为"yyyy-MM-dd"的格式化日期
	 */
	public static String formatDate() {
		String retStr = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		retStr = sdf.format(new Date());
		return retStr;
	}

	/**
	 * 获取当前的格式化日期
	 * 
	 * @param format
	 *            String 指定的格式
	 * @return String
	 */
	public static String formatDate(String format) {
		String retStr = "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		retStr = sdf.format(new Date());
		return retStr;
	}

	/**
	 * 获取指定日期的固定格式化日期
	 * 
	 * @param dt
	 *            Date 指定的日期
	 * @return String 返回形式为"yyyy-MM-dd"的格式化日期
	 */
	public static String formatDate(Date dt) {
		if (dt == null)
			return "";
		String retStr = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		retStr = sdf.format(dt);
		return retStr;
	}

	/**
	 * 获取指定日期的固定格式化日期
	 * 
	 * @param cal
	 *            Calendar 指定的日期
	 * @return String 返回形式为"yyyy-MM-dd"的格式化日期
	 */
	public static String formatDate(Calendar cal) {
		if (cal == null)
			return "";
		String retStr = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		retStr = sdf.format(cal.getTime());
		return retStr;
	}

	/**
	 * 获取指定日期的格式化日期
	 * 
	 * @param dt
	 *            Date
	 * @param format
	 *            String 指定的格式
	 * @return String
	 */
	public static String formatDate(Date dt, String format) {
		if (dt == null)
			return "";
		String retStr = "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		retStr = sdf.format(dt);
		return retStr;
	}

	/**
	 * 获取指定日期的格式化日期
	 * 
	 * @param cal
	 *            Calendar
	 * @param format
	 *            String 指定的格式
	 * @return String
	 */
	public static String formatDate(Calendar cal, String format) {
		if (cal == null)
			return "";
		String retStr = "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		retStr = sdf.format(cal.getTime());
		return retStr;
	}

	/**
	 * 获取特定日期的格式化日期，以当前日期为基准
	 * 
	 * @param mode
	 *            int
	 *            指定的格式：DT_LASTDAY_OF_MONTH，DT_TODAY_IN_LAST_MONTH，DT_FIRSTDAY_OF_MONTH
	 * @return String
	 */
	public static String formatDate(int mode) {
		String retStr = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		switch (mode) {
			case UTIL.DT_LASTDAY_OF_MONTH :
				cal.set(
					cal.DAY_OF_MONTH,
					cal.getActualMaximum(cal.DAY_OF_MONTH));
				break;
			case UTIL.DT_TODAY_IN_LAST_MONTH :
				cal.add(cal.MONTH, -1);
				break;
			case UTIL.DT_FIRSTDAY_OF_MONTH :
				cal.set(cal.DAY_OF_MONTH, 1);
				break;
			case UTIL.DT_FIRSTDAY_OF_YEAR :
				cal.set(cal.DAY_OF_YEAR, 1);
				break;
			default :
				break;
		}
		retStr = sdf.format(cal.getTime());
		return retStr;
	}

	/**
	 * 获取特定日期的格式化日期，以指定的月份为基准
	 * 
	 * @param month
	 *            int 指定的月份，从0开始
	 * @param mode
	 *            int
	 *            指定的格式：DT_LASTDAY_OF_MONTH，DT_TODAY_IN_LAST_MONTH，DT_FIRSTDAY_OF_MONTH
	 * @return String
	 */
	public static String formatDate(int month, int mode) {
		String retStr = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.set(cal.MONTH, month);
		switch (mode) {
			case UTIL.DT_LASTDAY_OF_MONTH :
				cal.set(
					cal.DAY_OF_MONTH,
					cal.getActualMaximum(cal.DAY_OF_MONTH));
				break;
			case UTIL.DT_TODAY_IN_LAST_MONTH :
				cal.add(cal.MONTH, -1);
				break;
			case UTIL.DT_FIRSTDAY_OF_MONTH :
				cal.set(cal.DAY_OF_MONTH, 1);
				break;
			default :
				break;
		}
		retStr = sdf.format(cal.getTime());
		return retStr;
	}

	/**
	 * 获取当前的格式化日期时间
	 * 
	 * @return String 返回形式为"yyyy-MM-dd HH:mm:ss"的格式化日期时间
	 */
	public static String formatDateTime() {
		String retStr = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		retStr = sdf.format(new Date());
		return retStr;
	}

	/**
	 * 获取指定日期时间的固定格式化日期时间
	 * 
	 * @param dt
	 *            Date 指定的日期时间
	 * @return String 返回形式为"yyyy-MM-dd HH:mm:ss"的格式化日期时间
	 */
	public static String formatDateTime(Date dt) {
		if (dt == null)
			return "";
		String retStr = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		retStr = sdf.format(dt);
		return retStr;
	}

	/**
	 * 获取指定日期时间的固定格式化日期时间
	 * 
	 * @param cal
	 *            Calendar 指定的日期时间
	 * @return String 返回形式为"yyyy-MM-dd HH:mm:ss"的格式化日期时间
	 */
	public static String formatDateTime(Calendar cal) {
		if (cal == null)
			return "";
		String retStr = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		retStr = sdf.format(cal.getTime());
		return retStr;
	}

	/**
	 * 分解字符串，字符串的分隔符为','
	 * 
	 * @param str
	 *            String
	 * @param needNull
	 *            boolean 若为true则包含空字符串，反之不包括， 例如a,,b,c，若包含空字符串，则结果为"a","" ,b ,c
	 * @return String[] 返回一个分割后的字符串数组
	 */
	public static String[] splitString(String str, boolean needNull) {
		return splitString(str, ",", needNull);
	}

	/**
	 * 分解字符串
	 * 
	 * @param str
	 *            String
	 * @param delim
	 *            String 指定的分割符
	 * @param needNull
	 *            boolean 若为true则包含空字符串，反之不包括， 例如a,,b,c，若包含空字符串，则结果为"a","" ,b ,c
	 * @return String[] 返回一个分割后的字符串数组
	 */
	public static String[] splitString(
		String str,
		String delim,
		boolean needNull) {
		List<String> list = new ArrayList<String>();
		if (needNull) {
			String strTemp = str;
			while (true) {
				int n = strTemp.indexOf(delim);
				if (n < 0) {
					list.add(strTemp);
					break;
				}
				list.add(strTemp.substring(0, n));
				strTemp = strTemp.substring(n + delim.length());
			}
		} else {
			StringTokenizer st = new StringTokenizer(str, delim);
			while (st.hasMoreElements()) {
				list.add(st.nextToken());
			}

		}
		String[] retStr = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			retStr[i] = list.get(i);
		}
		return retStr;
	}

	/**
	 * 分解字符串，字符串的分隔符为','
	 * 
	 * @param str
	 *            String
	 * @return String[] 返回一个分割后的字符串数组
	 */
	public static String[] splitString(String str) {
		StringTokenizer st = new StringTokenizer(str, ",");
		List<String> list = new ArrayList<String>();
		while (st.hasMoreElements()) {
			list.add(st.nextToken());
		}
		String[] retStr = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			retStr[i] = list.get(i);
		}
		return retStr;
	}

	/**
	 * 分解字符串
	 * 
	 * @param str
	 *            String
	 * @param delim
	 *            String 指定的分割符
	 * @return String[] 返回一个分割后的字符串数组
	 */
	public static String[] splitString(String str, String delim) {
		StringTokenizer st = new StringTokenizer(str, delim);
		List<String> list = new ArrayList<String>();
		while (st.hasMoreElements()) {
			list.add(st.nextToken());
		}
		String[] retStr = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			retStr[i] = list.get(i);
		}
		return retStr;
	}

	/**
	 * 进行中文字体的转换
	 * 
	 * @param str
	 *            String
	 * @return String 返回转换后的值
	 */
	public static String Convert(String str) {
		String r = new String("");
		try {
			if (str != null) {
				r = new String(str.getBytes("UTF-8"), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new String("");
		}
		return r.trim();
	}

	/**
	 * 进行中文字体的转换
	 * 
	 * @param str
	 *            String
	 * @param strNull
	 *            String 当str为null时的替代值
	 * @return String 返回转换后的值
	 */
	public static String Convert(String str, String strNull) {
		String r = strNull;
		try {
			if (str != null) {
				r = new String(str.getBytes("UTF-8"), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return strNull;
		}
		return r.trim();
	}

	

	

	

	
	
	/**
	 * 替换null的字符
	 * 
	 * @param str
	 *            String
	 * @param strNull
	 *            String 当str为null时的替代值
	 * @return String 返回转换后的值
	 */
	public static String ReplaceNull(String str, String strNull) {
		if (str == null)
			return strNull;
		else
			return str.trim();
	}

	/**
	 * 替换null的字符
	 * 
	 * @param str
	 *            String
	 * @param strNull
	 *            String 当str为null时的替代值
	 * @return String 返回转换后的值
	 */
	public static String stringNoNull(String str) {
		if (str == null)
			return "";
		else
			return str.trim();
	}

	/**
	 * 字符串替换：在oldStr中，将所有的str1的字符串替换成str2
	 * 
	 * @param oldStr
	 *            String
	 * @param str1
	 *            String
	 * @param str2
	 *            String
	 * @return String
	 */
	public static String replaceAll(String oldStr, String str1, String str2) {
		StringBuffer sb = new StringBuffer();
		if (oldStr == null
			|| str1 == null
			|| str2 == null
			|| str1.equals(str2))
			return oldStr;
		String strTemp = oldStr;
		while (true) {
			int n = strTemp.indexOf(str1);
			if (n < 0) {
				sb.append(strTemp);
				break;
			}
			sb.append(strTemp.substring(0, n));
			sb.append(str2);
			strTemp = strTemp.substring(n + str1.length());
		}
		return sb.toString();
	}

	/**
	 * 重复字符串，构造成一个新的字符串
	 * 
	 * @param str
	 *            String
	 * @param times
	 *            int
	 * @return String
	 */
	public static String repeatString(String str, int times) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < times; i++) {
			sb.append(str);
		}
		return sb.toString();
	}

	/**
	 * 将Unicode转换为UTF8
	 * 
	 * @param instr
	 *            String
	 * @return String 返回UTF-8字符串
	 */
	public static String convertUnicode2UTF8Byte(String instr) {
		if (instr == null)
			return "";
		int len = instr.length();
		byte[] abyte = new byte[len << 2];
		int j = 0;
		String str = "";
		for (int i = 0; i < len; i++) {
			char c = instr.charAt(i);
			if (c < 0x80) {
				abyte[j++] = (byte) c;
				str += c;
			} else if (c < 0x0800) {
				abyte[j++] = (byte) (((c >> 6) & 0x1F) | 0xC0);
				str += "%" + Integer.toHexString(abyte[j - 1]).substring(6);
				abyte[j++] = (byte) ((c & 0x3F) | 0x80);
				str += "%" + Integer.toHexString(abyte[j - 1]).substring(6);
			} else if (c < 0x010000) {
				abyte[j++] = (byte) (((c >> 12) & 0x0F) | 0xE0);
				str += "%" + Integer.toHexString(abyte[j - 1]).substring(6);
				abyte[j++] = (byte) (((c >> 6) & 0x3F) | 0x80);
				str += "%" + Integer.toHexString(abyte[j - 1]).substring(6);
				abyte[j++] = (byte) ((c & 0x3F) | 0x80);
				str += "%" + Integer.toHexString(abyte[j - 1]).substring(6);
			} else if (c < 0x200000) {
				abyte[j++] = (byte) (((c >> 18) & 0x07) | 0xF8);
				str += "%" + Integer.toHexString(abyte[j - 1]).substring(6);
				abyte[j++] = (byte) (((c >> 12) & 0x3F) | 0x80);
				str += "%" + Integer.toHexString(abyte[j - 1]).substring(6);
				abyte[j++] = (byte) (((c >> 6) & 0x3F) | 0x80);
				str += "%" + Integer.toHexString(abyte[j - 1]).substring(6);
				abyte[j++] = (byte) ((c & 0x3F) | 0x80);
				str += "%" + Integer.toHexString(abyte[j - 1]).substring(6);
			}
		}
		return str;
	}

	/**
	 * 将UTF8转换为Unicode
	 * 
	 * @param instr
	 *            String 参数名称
	 * @return String 返回Unicode字符串
	 */
	public static String convertUTF8String2Unicode(String instr) {
		if (instr == null)
			return "";
		int charindex = instr.length();
		int actualValue;
		int inputValue;
		StringBuffer sbtemp = new StringBuffer();

		for (int i = 0; i < charindex;) {
			actualValue = -1;
			inputValue = instr.charAt(i++);

			inputValue &= 0xff;
			if ((inputValue & 0x80) == 0) {
				actualValue = inputValue;
			} else if ((inputValue & 0xF8) == 0xF0) {
				actualValue = (inputValue & 0x1f) << 18;

				int nextByte = instr.charAt(i++) & 0xff;
				if ((nextByte & 0xC0) != 0x80) {
					System.err.println("CM:Invalid UTF-8 format");
				}
				actualValue += (nextByte & 0x3F) << 12;

				nextByte = instr.charAt(i++) & 0xff;
				if ((nextByte & 0xC0) != 0x80) {
					System.err.println("CM:Invalid UTF-8 format");
				}
				actualValue += (nextByte & 0x3F) << 6;

				nextByte = instr.charAt(i++) & 0xff;
				if ((nextByte & 0xC0) != 0x80) {
					System.err.println("CM:Invalid UTF-8 format");
				}
				actualValue += (nextByte & 0x3F);
			} else if ((inputValue & 0xF0) == 0xE0) {
				actualValue = (inputValue & 0x1f) << 12;

				int nextByte = instr.charAt(i++) & 0xff;
				if ((nextByte & 0xC0) != 0x80) {
					System.err.println("CM:Invalid UTF-8 format");
				}
				actualValue += (nextByte & 0x3F) << 6;

				nextByte = instr.charAt(i++) & 0xff;
				if ((nextByte & 0xC0) != 0x80) {
					System.err.println("CM:Invalid UTF-8 format");
				}
				actualValue += (nextByte & 0x3F);
			} else if ((inputValue & 0xE0) == 0xC0) {
				actualValue = (inputValue & 0x1f) << 6;
				int nextByte = instr.charAt(i++) & 0xff;
				if ((nextByte & 0xC0) != 0x80) {
					System.err.println("CM:Invalid UTF-8 format");
				}
				actualValue += (nextByte & 0x3F);
			}
			sbtemp.append((char) actualValue);
		} //end for 	
		return sbtemp.toString();
	}

	/**
	 * 将ISO10646转换为Unicode
	 * 
	 * @param instr
	 *            String 参数名称
	 * @return String 返回Unicode字符串
	 */
	public static String ISO10646ToUnicode(String str) {
		String result = new String("");
		StringBuffer sb = new StringBuffer("");
		try {
			/* 将字符串转换成byte数组 */
			byte[] myByte = str.getBytes("ISO10646");
			int len = myByte.length;

			for (int i = 0; i < len; i = i + 2) {
				byte hiByte = myByte[i];
				byte loByte = myByte[i + 1];

				int ch = (int) hiByte << 8;
				ch = ch & 0xff00;
				ch += (int) loByte & 0xff;

				sb.append((char) ch);
			}

			result = new String(sb.toString());

		} catch (Exception e) {
			System.out.println("Encoding Error");
		}
		return result;
	}

	/**
	 * 将Unicode转换为Byte
	 * 
	 * @param instr
	 *            String 参数名称
	 * @return String 返回Unicode字符串
	 */
	public static String Unicode2Byte(String str) {
		String resultStr = "";
		int len = str.length();
		byte abyte[] = new byte[len << 1];
		int j = 0;
		for (int i = 0; i < len; i++) {
			char c = str.charAt(i);
			if ((int) c > 127) {
				resultStr += "&#x" + Integer.toHexString((int) c) + ";";
			} else {
				resultStr += c;
			}
			abyte[j++] = (byte) (c & 0xff);
			abyte[j++] = (byte) (c >> 8);
		}
		return resultStr;
	}

	/**
	 * 解析日期时间字符串
	 * 
	 * @param str
	 *            String
	 * @return Calendar
	 */
	public static Calendar parseCalendar(String str, String format) {
		if (str == null || str.equals(""))
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(str));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return cal;
	}

	/**
	 * 解析日期时间字符串
	 * 
	 * @param str
	 *            String
	 * @return Date
	 */
	public static java.util.Date parseDate(String str, String format) {
		if (str == null || str.equals(""))
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 转换
	 * 
	 * @param str
	 *            String
	 * @return int
	 */
	public static int parseInt(String str) {
		if (str == null || str.equals(""))
			return 0;		
		try {
			int n = Integer.parseInt(str);
			return n;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 转换
	 * 
	 * @param str
	 *            String
	 * @return double
	 */
	public static double parseDouble(String str) {
		if (str == null || str.equals(""))
			return 0;		
		try {
			double n = Double.parseDouble(str);
			return n;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 转换为sql Date
	 * 
	 * @param date
	 *            java.util.Date
	 * @return sql.Date
	 */
	public static java.sql.Date toSqlDate(Date date) {
		if (date == null)
			return null;
		return new java.sql.Date(date.getTime());
	}

	/**
	 * 转换为sql Date
	 * 
	 * @param date
	 *            java.util.Calendar
	 * @return sql.Date
	 */
	public static java.sql.Date toSqlDate(Calendar date) {
		if (date == null)
			return null;
		return new java.sql.Date(date.getTime().getTime());
	}

	/**
	 * 获取字节个数，假定中文字符占2个字节，英文字符占1个字节
	 * 
	 * @param String
	 *            str
	 * @return int
	 */
	public static int getByteLength(String str) {
		if (str == null)
			return 0;
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 0 && c <= 255) {
				cnt++;
			} else {
				cnt += 2;
			}
		}
		return cnt;
	}

	/**
	 * 为字串增长为定长的字符串，前面补指定字符
	 * 
	 * @param str
	 *            待增长的字符串 fillStr 补齐的字符 len 增长后的指定长度
	 * 
	 * @return String
	 * 
	 */
	public static String strIncreament(String str, String fillStr, int len) {
		String result = "";

		StringBuffer sb = new StringBuffer();
		if (str == null) {
			for (int i = 0; i < len; i++) {
				result += fillStr;
			}
			return result;
		} else {
			for (int i = 0; i < len - str.length(); i++) {
				result += fillStr;
			}
			return result + str;
		}

	}
	
	/**
	 * 为字串增长为定长的字符串，后面补指定字符
	 * 
	 * @param str
	 *            待增长的字符串 fillStr 补齐的字符 len 增长后的指定长度
	 * 
	 * @return String
	 * 
	 */
	public static String strIncreamentAfter(String str, String fillStr, int len) {
		String result = "";
		if (str == null) {
			for (int i = 0; i < len; i++) {
				result += fillStr;
			}
			return result;
		} else {
			for (int i = 0; i < len - str.length(); i++) {
				result += fillStr;
			}
			return str + result;
		}

	}
}
