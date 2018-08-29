package com.burgess.excel.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * @project banana-excel
 * @package com.burgess.excel.util
 * @file DateUtils.java
 * @author burgess.zhang
 * @time 22:53:08/2018-08-27
 * @desc 日期工具类
 */
public class DateUtils {

	private static final Pattern MILLIS = Pattern.compile("[0-9][0-9]*");

	public static String toText(Date date, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
		return dateFormat.format(date);
	}

	public static String toText(Number date, String format) {
		long time = date.longValue();
		if (time <= 0) {
			return null;
		}
		Date value = new Date(time);
		DateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
		return dateFormat.format(value);
	}

	public static Date toDate(long date, String format) {
		if (date <= 0) {
			return null;
		}
		return new Date(date);
	}

	public static Date toDate(double date, String format) {
		long value = Double.valueOf(date).longValue();
		return toDate(value, format);
	}

	public static Date toDate(String date, String format) throws ParseException {
		if (MILLIS.matcher(date).matches()) {
			long time = Long.parseLong(date);
			if (time <= 0) {
				return null;
			}
			return new Date(time);
		}
		DateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
		return dateFormat.parse(date);
	}

}
