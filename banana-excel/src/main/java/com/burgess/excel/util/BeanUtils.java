package com.burgess.excel.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @project banana-excel
 * @package com.burgess.excel.util
 * @file BeanUtils.java
 * @author burgess.zhang
 * @time 22:26:17/2018-08-27
 * @desc bean工具类
 */
public class BeanUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(BeanUtils.class);

	private Class<?> clasz;
	private Map<String, PropertyDescriptor> beanPropertyDescriptor;
	private Map<String, String> beanPropertyType;

	/**
	 * @return the beanPropertyDescriptor
	 */
	public Map<String, PropertyDescriptor> getBeanPropertyDescriptor() {
		return beanPropertyDescriptor;
	}

	/**
	 * @param beanPropertyDescriptor the beanPropertyDescriptor to set
	 */
	public void setBeanPropertyDescriptor(Map<String, PropertyDescriptor> beanPropertyDescriptor) {
		this.beanPropertyDescriptor = beanPropertyDescriptor;
	}

	/**
	 * @file BeanUtils.java
	 * @author burgess.zhang
	 * @time 22:30:42/2018-08-27
	 * @desc
	 */
	public BeanUtils(Class<?> classz) {
		LOGGER.info("creating BeanHelper");
		this.clasz = classz;
	}

	/**
	 * @file BeanUtils.java
	 * @author burgess.zhang
	 * @time 22:31:58/2018-08-27
	 * @desc 初始化工作
	 */
	public void init() {
		LOGGER.info("BeanHelper init");
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(clasz);
		} catch (IntrospectionException e) {
			LOGGER.error("获取类{}信息失败!", clasz.getName());
			e.printStackTrace();
		}
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		if (null == propertyDescriptors) {
			String msg = "无法获取类字段属性";
			LOGGER.error(msg);
			throw new RuntimeException(msg);
		}
		if (propertyDescriptors.length <= 0) {
			String msg = "类字段属性个数为0";
			LOGGER.error(msg);
			throw new RuntimeException(msg);
		}
		beanPropertyDescriptor = new HashMap<>();
		beanPropertyType = new HashMap<>();
		for (PropertyDescriptor pDescriptor : propertyDescriptors) {
			if (Objects.nonNull(pDescriptor)) {
				beanPropertyDescriptor.put(pDescriptor.getName(), pDescriptor);
				beanPropertyType.put(pDescriptor.getName(), pDescriptor.getPropertyType().getName());
			}
		}
		LOGGER.info("created BeanHelper");
	}

	/**
	 * @file BeanUtils.java
	 * @author burgess.zhang
	 * @time 22:46:48/2018-08-27
	 * @desc 初始化
	 * @param classz
	 */
	public void init(Class<?> classz) {
		if (Objects.isNull(classz)) {
			String msg = "the param classz of the method of BeanHelper.init(classz) is null ";
			LOGGER.error(msg);
			throw new IllegalArgumentException(msg);
		}
		LOGGER.info("BeanHelpers init(classz)");
		this.clasz = classz;
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(clasz);
		} catch (IntrospectionException e) {
			String msg = String.format("the class[%s] Introspection Exception.", classz.getName());
			LOGGER.error(msg);
			throw new RuntimeException(msg);
		}
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		if (null == pds) {
			String msg = String.format("未能获取类[%s]字段属性个数为0", classz.getName());
			LOGGER.error(msg);
			throw new RuntimeException(msg);
		}
		if (pds.length <= 0) {
			String msg = String.format("类[%s]字段属性个数为0", classz.getName());
			LOGGER.error(msg);
			throw new RuntimeException(msg);
		}
		beanPropertyDescriptor = new HashMap<String, PropertyDescriptor>();
		beanPropertyType = new HashMap<String, String>();
		for (PropertyDescriptor pDescriptor : pds) {
			if (Objects.nonNull(pDescriptor)) {
				beanPropertyDescriptor.put(pDescriptor.getName(), pDescriptor);
				beanPropertyType.put(pDescriptor.getName(), pDescriptor.getPropertyType().getName());
			}
		}
		LOGGER.info("init(classz)初始化工作完成");
	}

	/**
	 * @file BeanUtils.java
	 * @author burgess.zhang
	 * @time 22:47:04/2018-08-27
	 * @desc 属性值设置
	 * @param target
	 * @param propertyName
	 * @param vlaue
	 */
	public void setPropertyValue(Object target, String propertyName, Object vlaue) {

		LOGGER.info(String.format("正在给%s属性的值设置为%s", propertyName, vlaue));
		if (target == null) {
			String msg = "the param target of the method of BeanHelper.setPropertyValue(target,propertyName,vlaue) is null ";
			LOGGER.error(msg);
			throw new IllegalArgumentException(msg);
		}
		if (propertyName == null) {
			String msg = "the param propertyName of the method of BeanHelper.setPropertyValue(target,propertyName,vlaue) is null ";
			LOGGER.error(msg);
			throw new IllegalArgumentException(msg);
		}
		if (beanPropertyDescriptor == null) {
			String msg = " don't run BeanHelper.init() yet ";
			LOGGER.error(msg);
			throw new RuntimeException(msg);
		}
		PropertyDescriptor pd = beanPropertyDescriptor.get(propertyName);
		Method methodGetX = pd.getWriteMethod();
		try {
			if (methodGetX != null) {
				methodGetX.invoke(target, vlaue);
			} else {
				String msg = String.format("the property[%s] hash no write method of class[%s]", propertyName,
						target.getClass().getName());
				LOGGER.error(msg);
				throw new RuntimeException(msg);
			}
		} catch (IllegalArgumentException e) {
			String msg = "can't set the value of " + vlaue.getClass().getName() + " into the field of "
					+ pd.getPropertyType().getName();
			LOGGER.error(msg);
			throw new RuntimeException(msg);

		} catch (IllegalAccessException | InvocationTargetException e) {
			String msg = String.format(
					" Illegal Access or Invocation Target, set value to the property[%s] of class[%s]", propertyName,
					target.getClass().getName());
			LOGGER.error(msg);
			throw new RuntimeException(msg);

		}

	}

	/**
	 * @file BeanUtils.java
	 * @author burgess.zhang
	 * @time 22:48:29/2018-08-27
	 * @desc 获取属性值
	 * @param target
	 * @param propertyName
	 * @return
	 */
	public Object getPropertyValue(Object target, String propertyName) {

		LOGGER.info(String.format("正在获取%s的属性设置值", propertyName));
		if (target == null) {

			String msg = "the param target of the method of BeanHelper.getPropertyValue(target,propertyName) is null ";
			LOGGER.error(msg);
			throw new IllegalArgumentException(msg);
		}
		if (propertyName == null) {
			String msg = "the param propertyName of the method of BeanHelper.getPropertyValue(target,propertyName) is null ";
			LOGGER.error(msg);
			throw new IllegalArgumentException(msg);
		}
		if (beanPropertyDescriptor == null) {
			String msg = "未进行初始化，先进行初始化，运行init方法";
			LOGGER.error(msg);
			throw new RuntimeException(msg);
		}
		PropertyDescriptor pd = beanPropertyDescriptor.get(propertyName);
		Method methodGetX = pd.getReadMethod();
		Object reValue = null;
		try {
			if (methodGetX != null) {
				reValue = methodGetX.invoke(target);
			} else {
				String msg = String.format("the property[%s] of class[%s] has not getMethod ", propertyName,
						target.getClass().getName());
				throw new RuntimeException(msg);
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			String msg = String.format(
					"the property[%s] of class[%s] illegal Access , illegal Argument  or invocation target",
					propertyName, target.getClass().getName());
			throw new RuntimeException(msg);
		}
		LOGGER.info(String.format("%s属性的值值%s", propertyName, String.valueOf(reValue)));
		return reValue;
	}

	public String getPropertyType(String propertyName) {

		LOGGER.info(String.format("正在获取%s的属性的数据类型", propertyName));
		if (propertyName == null) {
			String msg = "the param propertyName of the method of BeanHelper.getPropertyType(propertyName) is null ";
			LOGGER.error(msg);
			throw new IllegalArgumentException(msg);
		}
		if (beanPropertyDescriptor == null) {

			String msg = String.format("未进行初始化，先进行初始化，运行init方法");
			LOGGER.error(msg);
			throw new RuntimeException(msg);
		}
		String propertyType = null;
		if (beanPropertyDescriptor.containsKey(propertyName)) {
			propertyType = beanPropertyType.get(propertyName);
		} else {
			String msg = String.format("类" + clasz.getName() + "不存在" + propertyName + "属性");
			LOGGER.error(msg);
			throw new RuntimeException(msg);
		}
		LOGGER.info(String.format("%s的属性的数据类型是%s", propertyName, propertyType));
		return propertyType;
	}

}
