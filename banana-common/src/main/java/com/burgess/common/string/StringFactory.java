package com.burgess.common.string;

/**
 * @project banana-common
 * @package com.burgess.common.string
 * @file StringFactory.java
 * @author burgess.zhang
 * @time 11:53:38/2018-09-15
 * @desc 字符串工具类
 */
public class StringFactory {

	
	//私有化构造方法
	private StringFactory() {}
	
	/**
	 * @file StringFactory.java
	 * @author burgess.zhang
	 * @time 11:57:49/2018-09-15
	 * @desc 校验字符串是否为null
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		if (null == str || "".equals(str) || "" == str) {
			return true;
		}
		return false;
	}
	
	/**
	 * @file StringFactory.java
	 * @author burgess.zhang
	 * @time 11:57:34/2018-09-15
	 * @desc 校验字符串是否非空
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}
	
}
