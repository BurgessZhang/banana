package com.burgess.excel.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @project banana-excel
 * @package com.burgess.excel.annotation
 * @file ColumnDataTypeHandler.java
 * @author burgess.zhang
 * @time 21:38:57/2018-08-28
 * @desc 元数据类型操作
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ColumnDataTypeHandler {
	public String value();
}
