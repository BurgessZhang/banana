package com.burgess.excel.exception;

/**
 * @project banana-excel
 * @package com.burgess.excel.exception
 * @file ExcelDataHandlerException.java
 * @author burgess.zhang
 * @time 22:04:07/2018-08-28
 * @desc
 */
public class ExcelDataHandlerException extends ExcelHandlerException {
	private static final long serialVersionUID = 1L;

	public ExcelDataHandlerException(String handlerName, String errorMsg, Exception e) {
		super(handlerName, errorMsg, e);
		this.setCode(EXCEL_DATA_HANDLER_EXCEPTION_CODE);
	}

}
