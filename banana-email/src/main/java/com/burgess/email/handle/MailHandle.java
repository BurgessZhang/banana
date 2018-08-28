package com.burgess.email.handle;

import com.burgess.email.bean.MailBean;

/**
 * @project banana-email
 * @package com.burgess.email.handle
 * @file MailHandle.java
 * @author burgess.zhang
 * @time 下午4:07:23/2018年8月10日
 * @desc 邮件发送接口
 */
public interface MailHandle {

	public boolean sendMail(MailBean mailBean);
	
}
