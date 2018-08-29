package com.burgess.excel.exception;

/**
 * @project banana-excel
 * @package com.burgess.excel.exception
 * @file OfficeException.java
 * @author burgess.zhang
 * @time 22:50:38/2018-08-27
 * @desc 自定义异常
 */
public class OfficeException extends Exception {

	private static final long serialVersionUID = 1L;

	// 详细信息
	private String detailMsg;

	public String getDetailMsg() {
		return detailMsg;
	}

	public void setDetailMsg(String detailMsg) {
		this.detailMsg = detailMsg;
	}

	private String errorMsg;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public OfficeException(String msg, Exception e) {
		super(e);
		this.errorMsg = msg;

	}

	public OfficeException(String msg) {
		this(msg, null);

	}

}
