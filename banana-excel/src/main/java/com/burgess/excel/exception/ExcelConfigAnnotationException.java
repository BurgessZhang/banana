package com.burgess.excel.exception;

/**
 * @project banana-excel
 * @package com.burgess.excel.exception
 * @file ExcelConfigAnnotationException.java
 * @author burgess.zhang
 * @time 22:05:05/2018-08-28
 * @desc 
 */
public class ExcelConfigAnnotationException extends ExcelConfigException {
	
	private static final long serialVersionUID = 1L;

	public ExcelConfigAnnotationException(String errorMsg, Exception exm) {
		this(null,errorMsg, exm);
	}
	public ExcelConfigAnnotationException(Class<?> annotation, String errorMsg, Exception exm) {
		super(errorMsg, exm);
		this.annotation= annotation;
		super.setCode(EXCEL_CONFIG_ANNOTATION_EXCEPTION_CODE);
	}
	
	//分析的注解类
	private Class<?> annotation;

	public Class<?> getAnnotation() {
		return annotation;
	}
	public void setAnnotation(Class<?> annotation) {
		this.annotation = annotation;
	}
	
}
