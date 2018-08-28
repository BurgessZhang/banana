package com.burgess.excel.exception;

/**
 * @project banana-excel
 * @package com.burgess.excel.exception
 * @file ExcelIoException.java
 * @author burgess.zhang
 * @time 21:59:23/2018-08-28
 * @desc 
 */
public class ExcelIoException extends ExcelException {
	private static final long serialVersionUID = 1L;

	public ExcelIoException(String errorMsg, Exception exm) {
		this("",errorMsg, exm);
	}
	public ExcelIoException(String fileName,String errorMsg, Exception exm) {
		super(errorMsg, exm);
		super.setCode(EXCEL_IO_EXCEPTION_CODE);
		this.fileName=fileName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * 文件名称
	 */
	private String fileName;
}
