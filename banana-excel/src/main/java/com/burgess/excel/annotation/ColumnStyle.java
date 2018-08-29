package com.burgess.excel.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @project banana-excel
 * @package com.burgess.excel.annotation
 * @file ColumnStyle.java
 * @author burgess.zhang
 * @time 21:40:54/2018-08-28
 * @desc 列样式
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ColumnStyle {
	public String style();

	public String handlers();
}
