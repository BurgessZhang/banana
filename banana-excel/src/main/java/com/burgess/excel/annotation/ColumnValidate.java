package com.burgess.excel.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @project banana-excel
 * @package com.burgess.excel.annotation
 * @file ColumnValidate.java
 * @author burgess.zhang
 * @time 21:41:40/2018-08-28
 * @desc 列校验
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ColumnValidate {
	public String value();
	public String argsKeyValue();
}
