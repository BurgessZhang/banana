package com.burgess.excel.exception;

/**
 * @project banana-excel
 * @package com.burgess.excel.exception
 * @file ExcelIoInputException.java
 * @author burgess.zhang
 * @time 22:00:19/2018-08-28
 * @desc
 */
public class ExcelIoInputException extends ExcelIoException {
	private static final long serialVersionUID = 1L;

	public ExcelIoInputException(String errorMsg, Exception exm) {
		this(null, errorMsg, exm);
	}

	public ExcelIoInputException(String fileName, String errorMsg, Exception exm) {
		super(fileName, errorMsg, exm);
		super.setCode(EXCEL_IO_INPUT_EXCEPTION_CODE);
	}

	public ExcelIoInputException(String errorMsg) {
		this(errorMsg, null);
	}
}
