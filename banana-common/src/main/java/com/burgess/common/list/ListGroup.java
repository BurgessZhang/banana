package com.burgess.common.list;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @project banana-common
 * @package com.burgess.common.list
 * @file ListGroup.java
 * @author burgess.zhang
 * @time 下午1:33:53/2018年8月30日
 * @desc list分组合并
 */
public class ListGroup {

	/**
	 * @project banana-common
	 * @package com.burgess.common.list
	 * @file ListGroup.java
	 * @author burgess.zhang
	 * @time 下午1:34:53/2018年8月30日
	 * @desc 分组依据接口，用于集合分组时获取分组依据
	 */
	public interface GroupBy<T> {
		T groupby(Object object);
	}

	/**
	 * @file ListGroup.java
	 * @author burgess.zhang
	 * @time 下午1:37:24/2018年8月30日
	 * @desc list 分组合并
	 * @param colls
	 * @param gb
	 * @return
	 */
	public static final <T extends Comparable<T>, D> Map<T, List<D>> Group(Collection<D> colls, GroupBy<T> gb) {
		if (Objects.isNull(colls) || colls.isEmpty()) {
			return null;
		}
		if (Objects.isNull(gb)) {
			return null;
		}
		Iterator<D> iterator = colls.iterator();
		Map<T, List<D>> map = new HashMap<>();
		while (iterator.hasNext()) {
			D d = iterator.next();
			T t = gb.groupby(d);
			if (map.containsKey(t)) {
				map.get(t).add(d);
			} else {
				List<D> list = new ArrayList<>();
				list.add(d);
				map.put(t, list);
			}

		}
		return map;
	}

	/**
	 * @file ListGroup.java
	 * @author burgess.zhang
	 * @time 下午1:41:57/2018年8月30日
	 * @desc 将List<V>安装V的methodName方法返回值分组，合并到Map<K,List<V>>中要保证入参的method必须为V的某一个有返回值的方法，并且该返回值必须为k类型
	 * @param list
	 * @param map
	 * @param clazz
	 * @param methodName
	 */
	public static <K, V> void listGroupToMap(List<V> list, Map<K, List<V>> map, Class<V> clazz, String methodName) {
		// 入参非法校验
		if (null == list || null == map || null == clazz || null == methodName || "".equals(methodName)) {
			return;
		}
		// 获取方法
		Method method = getMethodByName(clazz, methodName);
		// 非空判断
		if (Objects.isNull(method)) {
			return;
		}
		// 正式分组
		listGroupToMap(list, map, method);
	}

	/**
	 * @file ListGroup.java
	 * @author burgess.zhang
	 * @time 下午1:47:18/2018年8月30日
	 * @desc 根据类和方法名，获取方法对象
	 * @param clazz
	 * @param methodName
	 * @return
	 */
	public static Method getMethodByName(Class<?> clazz, String methodName) {
		if (null == clazz || null == methodName || "".equals(methodName)) {
			return null;
		}
		try {
			return clazz.getDeclaredMethod(methodName);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			return null;
		} catch (SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @file ListGroup.java
	 * @author burgess.zhang
	 * @time 下午1:51:28/2018年8月30日
	 * @desc 将list<V>按照v的某个方法返回值分组，合并到Map<K,list<V>>中，要保证入参的method必须为v的某一个有返回值的方法，并且该返回值必须为k类型
	 * @param list
	 * @param map
	 * @param method
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> void listGroupToMap(List<V> list, Map<K, List<V>> map, Method method) {
		// 入参非法校验
		if (null == list || null == map || null == method) {
			return;
		}
		try {
			Object key = null;
			List<V> listTmp = null;
			for (V val : list) {
				if (Objects.nonNull(val)) {
					key = method.invoke(val);
					listTmp = map.get(key);
					if (null == listTmp) {
						listTmp = new ArrayList<>();
					}
					map.put((K) key, listTmp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
