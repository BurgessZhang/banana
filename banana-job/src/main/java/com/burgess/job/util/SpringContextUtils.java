package com.burgess.job.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @project banana-job
 * @package com.burgess.job.util
 * @file SpringContextUtils.java
 * @author burgess.zhang
 * @time 下午4:44:33/2018年8月31日
 * @desc spring context 工具类
 */
public class SpringContextUtils implements ApplicationContextAware {

	public static ApplicationContext applicationContext;

	/**
	 * @file SpringContextUtils.java
	 * @author burgess.zhang
	 * @time 下午4:45:10/2018年8月31日
	 * @desc 设置上下文
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 * @param applicationContext
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtils.applicationContext = applicationContext;
	}

	/**
	 * @file SpringContextUtils.java
	 * @author burgess.zhang
	 * @time 下午4:51:54/2018年8月31日
	 * @desc 根据名称获取bean
	 * @param name
	 * @return
	 */
	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}

	/**
	 * @file SpringContextUtils.java
	 * @author burgess.zhang
	 * @time 下午4:52:19/2018年8月31日
	 * @desc 根据名称获取指定类型bean
	 * @param name
	 * @param requiredType
	 * @return
	 */
	public static <T> T getBean(String name, Class<T> requiredType) {
		return applicationContext.getBean(name, requiredType);
	}

	/**
	 * @file SpringContextUtils.java
	 * @author burgess.zhang
	 * @time 下午4:52:47/2018年8月31日
	 * @desc 校验bean是否存在
	 * @param name
	 * @return
	 */
	public static boolean containsBean(String name) {
		return applicationContext.containsBean(name);
	}

	public static boolean isSingleton(String name) {
		return applicationContext.isSingleton(name);
	}

	public static Class<? extends Object> getType(String name) {
		return applicationContext.getType(name);
	}
}
