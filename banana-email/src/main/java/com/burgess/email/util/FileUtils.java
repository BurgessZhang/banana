package com.burgess.email.util;

/**
 * @project banana-email
 * @package com.burgess.email.util
 * @file FileUtils.java
 * @author burgess.zhang
 * @time 下午3:40:20/2018年8月10日
 * @desc 文件工具类
 */
public class FileUtils {

	/**
	 * @file FileUtils.java
	 * @author burgess.zhang
	 * @time 下午3:42:23/2018年8月10日
	 * @desc 获取文件名称
	 * @param fileName
	 * @return 文件名称
	 */
	public static String getLastName(String fileName) {
		int pos = fileName.lastIndexOf("\\");
		if (pos > -1) {
			fileName = fileName.substring(pos + 1);
		}
		pos = fileName.lastIndexOf("/");
		if (pos > -1) {
			fileName = fileName.substring(pos + 1);
		}
		return fileName;
	}
	
}
