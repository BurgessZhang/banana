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

	//详细信息
	private String detailMsg;
	private String errorMsg;

	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * @return the detailMsg
	 */
	public String getDetailMsg() {
		return detailMsg;
	}

	/**
	 * @param detailMsg the detailMsg to set
	 */
	public void setDetailMsg(String detailMsg) {
		this.detailMsg = detailMsg;
	}

	/**
	 * @file OfficeException.java
	 * @author burgess.zhang
	 * @time 22:52:19/2018-08-27
	 * @desc 
	 * @param detailMsg
	 * @param errorMsg
	 */
	public OfficeException(String detailMsg, String errorMsg) {
		super();
		this.detailMsg = detailMsg;
		this.errorMsg = errorMsg;
	}

	/**
	 * @file OfficeException.java
	 * @author burgess.zhang
	 * @time 22:52:36/2018-08-27
	 * @desc 
	 * @param detailMsg
	 */
	public OfficeException(String detailMsg) {
		super(detailMsg,null);
	}
	
	
	
}
