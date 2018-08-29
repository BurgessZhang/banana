package com.burgess.excel.exception;

/**
 * @project banana-excel
 * @package com.burgess.excel.exception
 * @file ExcelBeanException.java
 * @author burgess.zhang
 * @time 22:06:10/2018-08-28
 * @desc
 */
public class ExcelBeanException extends ExcelException {
	private static final long serialVersionUID = 1L;

	public ExcelBeanException(String errorMsg, Exception exm) {
		super(errorMsg, exm);

	}

	public ExcelBeanException(Object target, String errorMsg, Exception exm) {
		this(target == null ? null : target.getClass(), target, errorMsg, exm);

	}

	public ExcelBeanException(Class<?> beanClass, Object target, String errorMsg, Exception exm) {
		super(errorMsg, exm);
		this.target = target;
		this.beanClass = beanClass;
		this.setCode(EXCEL_BEAN_EXCEPTION_CODE);
	}

	/**
	 * 转换目的对象
	 */
	private Object target;
	/**
	 * 目标类
	 */
	private Class<?> beanClass;

	public Class<?> getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(Class<?> beanClass) {
		this.beanClass = beanClass;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}
}
