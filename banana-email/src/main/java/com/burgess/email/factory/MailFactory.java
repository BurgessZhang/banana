package com.burgess.email.factory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.burgess.email.bean.MailBean;
import com.burgess.email.constant.MailConstant;
import com.burgess.email.handle.MailHandle;
import com.burgess.email.handle.MailHtmlHandle;
import com.burgess.email.handle.MailTextHandle;

/**
 * @project banana-email
 * @package com.burgess.email.factory
 * @file MailFactory.java
 * @author burgess.zhang
 * @time 16:59:31/2018-08-10
 * @desc 邮件发送Factory
 */
public class MailFactory {

	private static final Logger LOGGER = LoggerFactory.getLogger(MailFactory.class);
	
	/**
	 * @file MailFactory.java
	 * @author burgess.zhang
	 * @time 17:33:29/2018-08-10
	 * @desc 邮件发送 
	 * @param mailBean
	 */
	public static void sendMessage(MailBean mailBean) {
		if (null == mailBean) {
			LOGGER.error("邮件发送参数不全!");
			return;
		}
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		/*Runnable runnable = () ->{
			MailHandle handle = getMailHandle(mailBean.getMimetype());
			handle.sendMail(mailBean);
		};*/
		
		executorService.execute(new Thread(()-> {
			MailHandle handle = getMailHandle(mailBean.getMimetype());
			handle.sendMail(mailBean);
		}));
		executorService.shutdown();
		
	}
	
	/**
	 * @file MailFactory.java
	 * @author burgess.zhang
	 * @time 17:07:27/2018-08-10
	 * @desc 创建邮件发送对象
	 * @param mimeTYpe
	 * @return
	 */
	private static MailHandle getMailHandle(String mimeTYpe) {
		switch (mimeTYpe) {
		case MailConstant.MIME_TYPE_HTML:
			return new MailHtmlHandle();
		case MailConstant.MIME_TYPE_TEXT:
			return new MailTextHandle();
		default:
			return null;
		}
	}
}
