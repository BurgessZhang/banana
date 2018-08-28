package com.burgess.common.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @project banana-common
 * @package com.burgess.common.date
 * @file DateFormatFactory.java
 * @author burgess.zhang
 * @time 22:11:00/2018-08-14
 * @desc 日期格式工厂
 */
public class DateFormatFactory {

	
	//私有化构造方法
	private DateFormatFactory() {};
	
	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:29:13/2018-08-14
	 * @desc 获取当前日期 yyyy-MM-dd HH:mm:ss格式字符串
	 * @return  yyyy-MM-dd HH:mm:ss格式当前日期字符串
	 */
	public static String currentDate() {
		return convertStrToDate(new Date(), DateFormatEnum.DATE_FORMAT_YMDHMS.getValue());
	}
	
	/**
	 * @file DateFormatFactory.java
	 * @author burgess.zhang
	 * @time 22:35:37/2018-08-14
	 * @desc 将日期转换为指定格式字符串
	 * @param date 日期
	 * @param pattern 格式
	 * @return 指定格式的日期字符串
	 */
	public static String convertStrToDate(Date date,String pattern) {
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
	 * @param date 日期字符串
	 * @param pattern 格式
	 * @return 指定格式的日期
	 * @throws ParseException
	 */
	public static Date convertDateToStr(String date,String pattern) throws ParseException {
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
	
}
