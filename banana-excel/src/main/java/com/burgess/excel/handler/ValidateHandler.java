package com.burgess.excel.handler;

/**
 * @project banana-excel
 * @package com.burgess.excel.handler
 * @file ValidateHandler.java
 * @author burgess.zhang
 * @time 22:08:46/2018-08-28
 * @desc
 */
public interface ValidateHandler {
	public String getfNandlerName();

	/**
	 * 解析时校验，excel单元格的数据
	 * 
	 * @param cellValue
	 * @return
	 */
	public Boolean parse(Object cellValue);

	/**
	 * 导出校验，校验字段的值
	 * 
	 * @param fieldValue
	 * @return
	 */
	public Boolean export(Object fieldValue);
}
