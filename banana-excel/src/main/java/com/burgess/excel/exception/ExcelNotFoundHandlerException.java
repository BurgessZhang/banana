package com.burgess.excel.exception;

/**
 * @project banana-excel
 * @package com.burgess.excel.exception
 * @file ExcelNotFoundHandlerException.java
 * @author burgess.zhang
 * @time 22:01:40/2018-08-28
 * @desc
 */
public class ExcelNotFoundHandlerException extends ExcelHandlerException {
	private static final long serialVersionUID = 1L;

	public ExcelNotFoundHandlerException(String handlerName, String errorMsg, Exception e) {
		super(handlerName, errorMsg, e);
		super.setCode(EXCEL_NOTFOUND_HANDLER_EXCEPTION_CODE);
		;
	}
}
