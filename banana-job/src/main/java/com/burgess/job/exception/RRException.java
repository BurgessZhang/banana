package com.burgess.job.exception;

/**
 * @project banana-job
 * @package com.burgess.job.exception
 * @file RRException.java
 * @author burgess.zhang
 * @time 13:24:55/2018-09-01
 * @desc 自定义异常
 */
public class RRException extends RuntimeException {

	private static final long serialVersionUID = 6688317915253883002L;

	private String msg;
	private int code = 500;

	public RRException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public RRException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}

	public RRException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}

	public RRException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
