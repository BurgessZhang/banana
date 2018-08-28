package com.burgess.excel.util;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @project banana-excel
 * @package com.burgess.excel.util
 * @file DataUtils.java
 * @author burgess.zhang
 * @time 21:30:03/2018-08-28
 * @desc data工具类型
 */
public class DataUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataUtils.class);

	/**
	 * @file DataUtils.java
	 * @author burgess.zhang
	 * @time 21:33:25/2018-08-28
	 * @desc 转换两个bean的数据
	 * @param a
	 * @param bclass
	 * @return
	 * @throws ReflectiveOperationException
	 */
	public static <A, B> B convertAtoB(A a, Class<B> bclass) throws ReflectiveOperationException {
		LOGGER.info("DataUtils.convertAtoB : a={},bclass={}", a, bclass);
		if (a == null) {
			String msg = String.format("the a param of  DataUtils.convertAtoB(A a, Class<B> bclass)is null . ");
			LOGGER.error(msg);
			throw new IllegalArgumentException(msg);
		}
		if (bclass == null) {
			String msg = String.format("the bclass param of  DataUtils.convertAtoB(A a, Class<B> bclass)is null . ");
			LOGGER.error(msg);
			throw new IllegalArgumentException(msg);
		}
		BeanUtils beanA = new BeanUtils(a.getClass());
		BeanUtils beanB = new BeanUtils(bclass);
		B b = null;
		try {
			b = bclass.newInstance();
		} catch (InstantiationException e) {
			String msg = String.format("class=%s Instantiation Exception:%s", bclass.getName(), String.valueOf(e));
			LOGGER.error(msg);
			throw new RuntimeException(msg);
		} catch (IllegalAccessException e) {
			String msg = String.format("class=%s illegalAccess  Exception:%s", bclass.getName(), String.valueOf(e));
			LOGGER.error(msg);
			throw new RuntimeException(msg);
		}
		if (b != null) {
			Set<String> propertys = beanA.getBeanPropertyDescriptor().keySet();
			for (String pro : propertys) {
				beanB.setPropertyValue(b, pro, beanA.getPropertyValue(a, pro));
			}
		}
		return b;

	}

	/**
	 * @file DataUtils.java
	 * @author burgess.zhang
	 * @time 21:33:48/2018-08-28
	 * @desc Map转成bean
	 * @param map
	 * @param tclass
	 * @return
	 */
	public static <T> T convert(Map<Object, Object> map, Class<T> tclass) {
		LOGGER.info("DataUtils.convert : map={},bclass={}", map, tclass);

		if (map == null) {
			String msg = String
					.format("the map param of  DataUtils.convert(Map<Object,Object> map,Class<T> tclass) is null . ");
			LOGGER.error(msg);
			throw new IllegalArgumentException(msg);
		}
		if (tclass == null) {
			String msg = String.format(
					"the tclass param of  DataUtils.convert(Map<Object,Object> map,Class<T> tclass) is null . ");
			LOGGER.error(msg);
			throw new IllegalArgumentException(msg);
		}
		T t = null;
		BeanUtils BeanUtil = null;
		Set<String> propertys = null;
		Object value = null;
		if (map != null) {
			try {
				t = (T) tclass.newInstance();
				BeanUtil = new BeanUtils(tclass);
				BeanUtil.init();
				propertys = BeanUtil.getBeanPropertyDescriptor().keySet();
				for (String pro : propertys) {
					if (map.containsKey(pro)) {
						value = changeToMatchType(BeanUtil, pro, map.get(pro));
						BeanUtil.setPropertyValue(t, pro, value);
					}
				}
			} catch (InstantiationException e) {
				String msg = String.format(
						"public static <T>T DataUtils.convert(Map<Object,Object> map,Class<T> tclass),class=%s illegalAccess  Exception:%s",
						tclass.getName(), String.valueOf(e));
				LOGGER.error(msg);
				throw new RuntimeException(msg);
			} catch (IllegalAccessException e) {
				String msg = String.format(
						"DataUtils.convert(Map<Object,Object> map,Class<T> tclass) Illegal Access class[%s] field ",
						tclass.getName());
				LOGGER.error(msg);
				throw new RuntimeException(msg);
			}

		}
		return t;
	}

	/**
	 * @file DataUtils.java
	 * @author burgess.zhang
	 * @time 21:34:03/2018-08-28
	 * @desc 将bean转成json
	 * @param t
	 * @return
	 */
	public static <T> JSONObject convert(T t) {
		LOGGER.info("DataUtils.convert : t={}", t);
		JSONObject json = null;
		if (t == null) {
			String msg = String.format("the t param of  DataUtils.convert(T t)  is null . ");
			LOGGER.error(msg);
			throw new IllegalArgumentException(msg);
		}
		BeanUtils bean = new BeanUtils(t.getClass());
		bean.init();
		json = new JSONObject();
		Set<String> propertys = bean.getBeanPropertyDescriptor().keySet();
		for (String pro : propertys) {
			json.put(pro, bean.getPropertyValue(t, pro));
		}
		return json;
	}

	/**
	 * @file DataUtils.java
	 * @author burgess.zhang
	 * @time 21:34:22/2018-08-28
	 * @desc 将bean转成map
	 * @param t
	 * @return
	 */
	public static <T> Map<Object, Object> convertToMap(T t) {
		LOGGER.info("DataUtils.convertToMap : t={}", t);
		Map<Object, Object> json = null;
		if (t == null) {
			String msg = String.format("the t param of  DataUtils.convertToMap(T t)  is null . ");
			LOGGER.error(msg);
			throw new IllegalArgumentException(msg);
		}
		BeanUtils bean = new BeanUtils(t.getClass());

		bean.init();
		json = new HashMap<Object, Object>();
		Set<String> propertys = bean.getBeanPropertyDescriptor().keySet();
		for (String pro : propertys) {
			json.put(pro, bean.getPropertyValue(t, pro));
		}

		return json;
	}

	/**
	 * @file DataUtils.java
	 * @author burgess.zhang
	 * @time 21:34:36/2018-08-28
	 * @desc 将list转成jsonArray
	 * @param list
	 * @return
	 */
	public static <T> JSONArray convert(List<T> list) {
		LOGGER.info("DataUtils.convert : list={}", list);
		JSONArray jsonList = null;
		if (list == null || list.size() <= 0) {
			String msg = String.format("the list param of  DataUtils.convert(List<T> list) is null or less then zero ");
			LOGGER.error(msg);
			throw new IllegalArgumentException(msg);
		}
		JSONObject json = null;
		jsonList = new JSONArray();
		for (T t : list) {
			json = convert(t);
			jsonList.add(json);
		}
		return jsonList;
	}

	public static JSONObject convert(Map<Object, Object> map) {
		if (map == null) {
			String msg = String.format("the map param of  DataUtils.convert(Map<Object, Object> map) is null  ");
			LOGGER.error(msg);
			throw new IllegalArgumentException(msg);
		}
		LOGGER.info("DataUtils.convert : map={}", map);
		JSONObject json = null;

		json = new JSONObject();
		Set<Object> propertys = map.keySet();
		for (Object o : propertys) {
			json.put(String.valueOf(o), map.get(o));
		}
		return json;
	}

	public static Map<Object, Object> convert(JSONObject json) {
		if (json == null) {
			String msg = String.format("the json param of  DataUtils.convert(Map<Object, Object>[] map) is null  ");
			LOGGER.error(msg);
			throw new IllegalArgumentException(msg);
		}
		LOGGER.info("DataUtils.convert : json={}", json);
		Set<String> iterator = json.keySet();
		Map<Object, Object> map = new HashMap<Object, Object>();
		for (String name : iterator) {
			map.put(name, json.get(name));
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public static Map<Object, Object>[] convert(JSONArray jsonArray) {
		LOGGER.info("DataUtils.convert : jsonArray={}", jsonArray);
		Map<Object, Object> map = null;
		if (jsonArray == null || jsonArray.size() <= 0) {
			String msg = String.format(
					"the jsonArray param of  DataUtils.convert(JSONArray  jsonArray) is null or less then zero ");
			LOGGER.error(msg);
			throw new IllegalArgumentException(msg);
		}

		int i = 0;
		int size = jsonArray.size();
		Map<Object, Object>[] result = new Map[size];
		for (Object json : jsonArray) {
			JSONObject j = (JSONObject) json;
			map = convert(j);
			result[i] = map;
			i++;
		}
		return result;
	}

	public static Map<Object, Object> convertMap(Map<String, Object> map) {
		Map<Object, Object> resultMap = new HashMap<Object, Object>();
		Set<String> propertys = map.keySet();
		for (String name : propertys) {
			resultMap.put(name, map.get(name));
		}
		return resultMap;
	}

	public static Map<String, Object> convertMapToMap(Map<Object, Object> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Set<Object> propertys = map.keySet();
		for (Object name : propertys) {
			resultMap.put(String.valueOf(name), map.get(name));
		}
		return resultMap;
	}

	public static JSONArray convert(Map<Object, Object>[] map) {
		LOGGER.info("DataUtils.convert : map");
		JSONArray jsonList = null;
		JSONObject json = null;
		if (map == null || map.length <= 0) {

			String msg = String.format(
					"the value param of  DataUtils.convert(Map<Object, Object>[] map) is null or less then zero ");
			LOGGER.error(msg);
			throw new IllegalArgumentException(msg);
		}
		jsonList = new JSONArray();
		for (Map<Object, Object> m : map) {
			json = convert(m);
			jsonList.add(json);
		}
		return jsonList;
	}

	public static Object changeToMatchType(BeanUtils bean, String fieldName, Object value) {
		LOGGER.info("DataUtils.changeToMatchType : bean={},fieldName={},value=", bean, fieldName, value);
		/*
		 * if(value==null){ String msg=String.
		 * format("the value param  DataUtils.changeToMatchType(BeanUtil bean,String fieldName,Object value) "
		 * ); logger.error(msg); throw new IllegalArgumentException(msg); }
		 */
		if (StringUtils.isEmpty(fieldName)) {

			String msg = String.format(
					"the fieldName param  DataUtils.changeToMatchType(BeanUtil bean,String fieldName,Object value) ");
			LOGGER.error(msg);
			throw new IllegalArgumentException(msg);
		}
		if (bean == null) {

			String msg = String.format(
					"the bean param  DataUtils.changeToMatchType(BeanUtil bean,String fieldName,Object value) ");
			LOGGER.error(msg);
			throw new IllegalArgumentException(msg);
		}
		Object returnValue = null;
		String dataType = bean.getPropertyType(fieldName);
		switch (dataType) {
		case "java.lang.String":
		case "string":
		case "String":
			String string = String.valueOf(value == null ? "" : value);
			returnValue = string;
			break;
		case "java.math.BigDecimal":
		case "java.math.Decimal":
		case "Decimal":
		case "decimal":
		case "bigDecimal":
			BigDecimal bigDecimal = BigDecimal.valueOf(Double.valueOf(String.valueOf(value == null ? 0d : value)));
			returnValue = bigDecimal;
			break;
		case "java.lang.Double":
		case "double":
		case "Double":
			Double double1 = Double.valueOf(String.valueOf(value == null ? "0d" : value));
			returnValue = double1;
			break;
		case "java.lang.Float":
		case "float":
		case "Float":
			Float float1 = Float.valueOf(String.valueOf(value == null ? "0f" : value));
			returnValue = float1;
			break;
		case "java.lang.Long":
		case "long":
		case "Long":
			Long long1 = Long.valueOf(String.valueOf(value == null ? "0l" : value));
			returnValue = long1;
			break;
		case "java.lang.Integer":
		case "int":
		case "Integer":
		case "integer":
			Integer integer = Integer.valueOf(Double.valueOf(String.valueOf(value == null ? "0d" : value)).intValue());
			returnValue = integer;
			break;
		case "java.lang.Boolean":
		case "boolean":
		case "Boolean":
		case "Bool":
		case "bool":
			Boolean booleanValue = Boolean.valueOf(String.valueOf(value == null ? "false" : value));
			returnValue = booleanValue;
			break;
		case "java.util.Date":
		case "date":
		case "Date":
			Date date = null;
			date = (Date) value;
			returnValue = date;
			break;
		case "java.util.Calendar":
		case "calendar":
		case "Calendar":
			Calendar calendar = (Calendar) value;
			returnValue = calendar;
			break;
		default:
			returnValue = value;
		}
		return returnValue;

	}

}
