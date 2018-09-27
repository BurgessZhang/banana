package com.burgess.common.map;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @project banana-common
 * @package com.burgess.common.map
 * @file MapUtils.java
 * @author burgess.zhang
 * @time 下午2:03:46/2018年8月30日
 * @desc map 工具类型
 */
public class MapFactory {

	/**
	 * @file MapUtils.java
	 * @author burgess.zhang
	 * @time 下午2:05:55/2018年8月30日
	 * @desc 校验map为null
	 * @param map
	 * @return
	 */
	public static <K, V> boolean isBlank(Map<K, V> map) {
		if (null == map || map.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * @file MapUtils.java
	 * @author burgess.zhang
	 * @time 下午2:07:27/2018年8月30日
	 * @desc 校验map不为null
	 * @param map
	 * @return
	 */
	public static <K, V> boolean isNotBlank(Map<K, V> map) {
		return !isBlank(map);
	}
	
	/**
	 * @file MapUtils.java
	 * @author burgess.zhang
	 * @time 22:47:00/2018-09-11
	 * @desc 将bean转换为map
	 * @param object
	 * @param clazz
	 * @return
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static Map<String, Object> beanToMap(Object object,Class<?> clazz) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Map<String, Object> map = new HashMap<>();
		//获取指定类的beaninfo对象
		BeanInfo beanInfo = Introspector.getBeanInfo(clazz,Object.class);
		//获取所有的属性描述器
		PropertyDescriptor[] pDescriptors = beanInfo.getPropertyDescriptors();
		for(PropertyDescriptor pd: pDescriptors) {
			String key = pd.getName();
			Method method = pd.getReadMethod();
			Object value = method.invoke(object);
			map.put(key, value);
		}
		return map;
	}

	/**
	 * @file MapUtils.java
	 * @author burgess.zhang
	 * @time 22:50:41/2018-09-11
	 * @desc 将map转换为bean
	 * @param map
	 * @param clazz
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws IntrospectionException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	public static <T> T mapToBean(Map<String, Object> map,Class<T> clazz) throws InstantiationException, IllegalAccessException, IntrospectionException, IllegalArgumentException, InvocationTargetException{
		//创建bean对象
		T object = clazz.newInstance();
		//获取指定类的beanInfo对象
		BeanInfo beanInfo = Introspector.getBeanInfo(clazz,Object.class);
		//获取所有的属性描述器
		PropertyDescriptor[] pDescriptors = beanInfo.getPropertyDescriptors();
		for(PropertyDescriptor pd: pDescriptors) {
			Object value = map.get(pd.getName());
			Method method = pd.getWriteMethod();
			method.invoke(object, value);
		}
		return object;
	}
}
