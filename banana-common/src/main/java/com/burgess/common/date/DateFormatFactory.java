package com.burgess.common.date;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * @project banana-common
 * @package com.burgess.common.date
 * @file DateFormatFactory.java
 * @author burgess.zhang
 * @time 22:11:00/2018-08-14
 * @desc 日期格式工厂
 */
public class DateFormatFactory {
	
	private static final Pattern MILLIS = Pattern.compile("[0-9][0-9]*");

	// 私有化构造方法
	private DateFormatFactory() {};

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:29:13/2018-08-14
	 * @desc 获取当前日期 yyyy-MM-dd HH:mm:ss格式字符串
	 * @return yyyy-MM-dd HH:mm:ss格式当前日期字符串
	 */
	public static String currentDate() {
		return convertStrToDate(new Date(), DateFormatEnum.DATE_FORMAT_YMDHMS.getValue());
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:35:37/2018-08-14
	 * @desc 将日期转换为指定格式字符串
	 * @param date    日期
	 * @param pattern 格式
	 * @return 指定格式的日期字符串
	 */
	public static String convertStrToDate(Date date, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:39:44/2018-08-14
	 * @desc 获取当前日期 yyyy-MM-dd HH:mm:ss格式
	 * @return yyyy-MM-dd HH:mm:ss格式当前日期
	 * @throws ParseException
	 */
	public static Date currentDateTime() throws ParseException {
		return convertDateToStr(currentDate(), DateFormatEnum.DATE_FORMAT_YMDHMS.getValue());
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:38:22/2018-08-14
	 * @desc 将字符串转换为指定格式的日期
	 * @param date    日期字符串
	 * @param pattern 格式
	 * @return 指定格式的日期
	 * @throws ParseException
	 */
	public static Date convertDateToStr(String date, String pattern) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.parse(date);
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:42:39/2018-08-14
	 * @desc 获取当前时间戳
	 * @return 时间戳
	 */
	public static long currentTimestamp() {
		return System.currentTimeMillis();
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:11:56/2018-08-29
	 * @desc 将number类型转换为指定格式日期字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String toText(Number date, String format) {
		long time = date.longValue();
		if (time <= 0) {
			return null;
		}
		Date value = new Date(time);
		DateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
		return dateFormat.format(value);
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:12:22/2018-08-29
	 * @desc 将时间戳转换为指定格式日期
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date toDate(long date, String format) {
		if (date <= 0) {
			return null;
		}
		return new Date(date);
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:12:44/2018-08-29
	 * @desc 将double类型数值转换为指定格式Date
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date toDate(double date, String format) {
		long value = Double.valueOf(date).longValue();
		return toDate(value, format);
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:13:09/2018-08-29
	 * @desc 将String类型数值转换为Date
	 * @param date
	 * @param format
	 * @return
	 * @throws ParseException
	 */
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

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:14:49/2018-08-29
	 * @desc 获取当天开始时间
	 * @return date
	 */
	public static Date currentStartTime() {
		Calendar todayStart = Calendar.getInstance();
		todayStart.set(Calendar.HOUR_OF_DAY, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.SECOND, 0);
		todayStart.set(Calendar.MILLISECOND, 0);

		return todayStart.getTime();
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:17:58/2018-08-29
	 * @desc 获取当天结束时间
	 * @return date
	 */
	public static Date currentEndTime() {
		Calendar todayEnd = Calendar.getInstance();

		todayEnd.set(Calendar.HOUR_OF_DAY, 23);
		todayEnd.set(Calendar.MINUTE, 59);
		todayEnd.set(Calendar.SECOND, 59);
		todayEnd.set(Calendar.MILLISECOND, 59);

		return todayEnd.getTime();
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:32:34/2018-08-29
	 * @desc 获取昨天的开始时间
	 * @return
	 */
	public static Date getBeginDayOfYesterday() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(currentStartTime());
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:32:28/2018-08-29
	 * @desc 获取昨天的结束时间
	 * @return
	 */
	public static Date getEndDayOfYesterDay() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(currentEndTime());
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:32:22/2018-08-29
	 * @desc 获取明天的开始时间
	 * @return
	 */
	public static Date getBeginDayOfTomorrow() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(currentStartTime());
		cal.add(Calendar.DAY_OF_MONTH, 1);

		return cal.getTime();
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:32:14/2018-08-29
	 * @desc 获取明天的结束时间
	 * @return
	 */
	public static Date getEndDayOfTomorrow() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(currentEndTime());
		cal.add(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:32:07/2018-08-29
	 * @desc 获取本周的开始时间
	 * @return
	 */
	public static Date getBeginDayOfWeek() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayofweek == 1) {
			dayofweek += 7;
		}
		cal.add(Calendar.DATE, 2 - dayofweek);
		return getDayStartTime(cal.getTime());
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:31:40/2018-08-29
	 * @desc 获取本周的结束时间
	 * @return
	 */
	public static Date getEndDayOfWeek() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getBeginDayOfWeek());
		cal.add(Calendar.DAY_OF_WEEK, 6);
		Date weekEndSta = cal.getTime();
		return getDayEndTime(weekEndSta);
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:31:33/2018-08-29
	 * @desc 获取本月的开始时间
	 * @return
	 */
	public static Date getBeginDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 1, 1);
		return getDayStartTime(calendar.getTime());
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:31:27/2018-08-29
	 * @desc 获取本月的结束时间
	 * @return
	 */
	public static Date getEndDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 1, 1);
		int day = calendar.getActualMaximum(5);
		calendar.set(getNowYear(), getNowMonth() - 1, day);
		return getDayEndTime(calendar.getTime());
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:31:21/2018-08-29
	 * @desc 获取本年的开始时间
	 * @return
	 */
	public static java.util.Date getBeginDayOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		// cal.set
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DATE, 1);

		return getDayStartTime(cal.getTime());
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:31:14/2018-08-29
	 * @desc 获取本年的结束时间
	 * @return
	 */
	public static java.util.Date getEndDayOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DATE, 31);
		return getDayEndTime(cal.getTime());
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:31:07/2018-08-29
	 * @desc 获取某个日期的开始时间
	 * @param d
	 * @return
	 */
	public static Timestamp getDayStartTime(Date d) {
		Calendar calendar = Calendar.getInstance();
		if (null != d)
			calendar.setTime(d);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0,
				0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return new Timestamp(calendar.getTimeInMillis());
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:31:01/2018-08-29
	 * @desc 获取某个日期的结束时间
	 * @param d
	 * @return
	 */
	public static Timestamp getDayEndTime(Date d) {
		Calendar calendar = Calendar.getInstance();
		if (null != d)
			calendar.setTime(d);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23,
				59, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return new Timestamp(calendar.getTimeInMillis());
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:30:54/2018-08-29
	 * @desc 获取今年是哪一年
	 * @return
	 */
	public static Integer getNowYear() {
		Date date = new Date();
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return Integer.valueOf(gc.get(1));
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:30:49/2018-08-29
	 * @desc 获取本月是哪一月
	 * @return
	 */
	public static int getNowMonth() {
		Date date = new Date();
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return gc.get(2) + 1;
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:30:42/2018-08-29
	 * @desc 两个日期相减得到的天数
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int getDiffDays(Date beginDate, Date endDate) {

		if (beginDate == null || endDate == null) {
			throw new IllegalArgumentException("getDiffDays param is null!");
		}

		long diff = (endDate.getTime() - beginDate.getTime()) / (1000 * 60 * 60 * 24);

		int days = new Long(diff).intValue();

		return days;
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:30:35/2018-08-29
	 * @desc 两个日期相减得到的毫秒数
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static long dateDiff(Date beginDate, Date endDate) {
		long date1ms = beginDate.getTime();
		long date2ms = endDate.getTime();
		return date2ms - date1ms;
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:30:27/2018-08-29
	 * @desc 获取两个日期中的最大日期
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static Date max(Date beginDate, Date endDate) {
		if (beginDate == null) {
			return endDate;
		}
		if (endDate == null) {
			return beginDate;
		}
		if (beginDate.after(endDate)) {
			return beginDate;
		}
		return endDate;
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:30:20/2018-08-29
	 * @desc 获取两个日期中的最小日期
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static Date min(Date beginDate, Date endDate) {
		if (beginDate == null) {
			return endDate;
		}
		if (endDate == null) {
			return beginDate;
		}
		if (beginDate.after(endDate)) {
			return endDate;
		}
		return beginDate;
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:30:13/2018-08-29
	 * @desc 返回某月该季度的第一个月
	 * @param date
	 * @return
	 */
	public static Date getFirstSeasonDate(Date date) {
		final int[] SEASON = { 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4 };
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int sean = SEASON[cal.get(Calendar.MONTH)];
		cal.set(Calendar.MONTH, sean * 3 - 3);
		return cal.getTime();
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:30:05/2018-08-29
	 * @desc 返回某个日期下几天的日期
	 * @param date
	 * @param i
	 * @return
	 */
	public static Date getNextDay(Date date, int i) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) + i);
		return cal.getTime();
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:29:57/2018-08-29
	 * @desc 返回某个日期前几天的日期
	 * @param date
	 * @param i
	 * @return
	 */
	public static Date getFrontDay(Date date, int i) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) - i);
		return cal.getTime();
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:29:48/2018-08-29
	 * @desc 获取某年某月到某年某月按天的切片日期集合（间隔天数的日期集合）
	 * @param beginYear
	 * @param beginMonth
	 * @param endYear
	 * @param endMonth
	 * @param k
	 * @return
	 */
	public static List<Date> getTimeList(int beginYear, int beginMonth, int endYear, int endMonth, int k) {
		List<Date> list = new ArrayList<>();
		if (beginYear == endYear) {
			for (int j = beginMonth; j <= endMonth; j++) {
				list.addAll(getTimeList(beginYear, j, k));

			}
		} else {
			{
				for (int j = beginMonth; j < 12; j++) {
					list.addAll(getTimeList(beginYear, j, k));
				}

				for (int i = beginYear + 1; i < endYear; i++) {
					for (int j = 0; j < 12; j++) {
						list.addAll(getTimeList(i, j, k));
					}
				}
				for (int j = 0; j <= endMonth; j++) {
					list.addAll(getTimeList(endYear, j, k));
				}
			}
		}
		return list;
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:28:04/2018-08-29
	 * @desc 获取某年某月按天切片日期集合（某个月间隔多少天的日期集合）
	 * @param beginYear
	 * @param beginMonth
	 * @param k
	 * @return
	 */
	public static List<Date> getTimeList(int beginYear, int beginMonth, int k) {
		List<Date> list = new ArrayList<>();
		Calendar begincal = new GregorianCalendar(beginYear, beginMonth, 1);
		int max = begincal.getActualMaximum(Calendar.DATE);
		for (int i = 1; i < max; i = i + k) {
			list.add(begincal.getTime());
			begincal.add(Calendar.DATE, k);
		}
		begincal = new GregorianCalendar(beginYear, beginMonth, max);
		list.add(begincal.getTime());
		return list;
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:27:56/2018-08-29
	 * @desc 获取某年某月的第一天日期
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getStartMonthDate(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		return calendar.getTime();
	}

	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:27:49/2018-08-29
	 * @desc 获取某年某月的最后一天日期
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getEndMonthDate(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		int day = calendar.getActualMaximum(5);
		calendar.set(year, month - 1, day);
		return calendar.getTime();
	}
}
