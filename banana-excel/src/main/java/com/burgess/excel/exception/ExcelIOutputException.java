package com.burgess.excel.exception;

/**
 * @project banana-excel
 * @package com.burgess.excel.exception
 * @file ExcelIOutputException.java
 * @author burgess.zhang
 * @time 22:00:52/2018-08-28
 * @desc
 */
public class ExcelIOutputException extends ExcelIoException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcelIOutputException(String errorMsg, Exception exm) {
		super(errorMsg, exm);
		super.setCode(EXCEL_IO_OUTPUT_EXCEPTION_CODE);
	}

	public ExcelIOutputException(String fileName, String errorMsg, Exception exm) {
		super(fileName, errorMsg, exm);
		super.setCode(EXCEL_IO_OUTPUT_EXCEPTION_CODE);
	}
}
