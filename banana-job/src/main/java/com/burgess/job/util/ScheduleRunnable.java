package com.burgess.job.util;

import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.ReflectionUtils;

import com.burgess.job.exception.BananaJobException;

/**
 * @project banana-job
 * @package com.burgess.job.util
 * @file ScheduleRunnable.java
 * @author burgess.zhang
 * @time 14:04:43/2018-09-01
 * @desc 定时任务执行
 */
public class ScheduleRunnable implements Runnable {

	private Object target;
	private Method method;
	private String params;

	/**
	 * @file ScheduleRunnable.java
	 * @author burgess.zhang
	 * @time 14:05:42/2018-09-01
	 * @desc 构造器
	 * @param target
	 * @param method
	 * @param params
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public ScheduleRunnable(String beanName, String methodName, String params)
			throws NoSuchMethodException, SecurityException {
		super();
		this.target = SpringContextUtils.getBean(beanName);
		this.params = params;
		if (StringUtils.isNotBlank(params)) {
			this.method = target.getClass().getDeclaredMethod(methodName, String.class);
		} else {
			this.method = target.getClass().getDeclaredMethod(methodName);
		}
	}

	/**
	 * @file ScheduleRunnable.java
	 * @author burgess.zhang
	 * @time 14:04:43/2018-09-01
	 * @desc
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			ReflectionUtils.makeAccessible(method);
			if (StringUtils.isNotBlank(params)) {
				method.invoke(target, params);
			} else {
				method.invoke(target);
			}
		} catch (Exception e) {
			throw new BananaJobException("执行定时任务失败", e);
		}

	}

}
