package com.burgess.email.handle;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.burgess.email.bean.MailBean;
import com.burgess.email.util.FileUtils;

/**
 * @project banana-email
 * @package com.burgess.email.util
 * @file MailHtmlHandle.java
 * @author burgess.zhang
 * @time 下午3:50:35/2018年8月10日
 * @desc 发送html格式邮件
 */
public class MailHtmlHandle implements MailHandle{

	private static final Logger LOGGER = LoggerFactory.getLogger(MailHtmlHandle.class);

	/**
	 * @file MailHtmlHandle.java
	 * @author burgess.zhang
	 * @time 下午4:23:51/2018年8月10日
	 * @desc 发送邮件
	 * @param mailBean
	 * @return 邮件是否发送成功
	 * @see com.burgess.email.handle.MailHandle#sendMail(com.burgess.email.bean.MailBean)
	 */
	@Override
	public boolean sendMail(MailBean mailBean) {
		LOGGER.info("邮件发送信息: {}",mailBean.toString());
		Properties properties = mailBean.getProperties();
		// 创建验证器
		Authenticator authenticator = null;
		if (mailBean.isValidate()) {
			authenticator = new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(mailBean.getUserName(), mailBean.getPassword());
				}
			};
		}
		// 使用Properties创建session
		Session session = Session.getDefaultInstance(properties, authenticator);
		session.setDebug(true);
		// 使用session创建MiME类型的消息
		Message miMessage = new MimeMessage(session);

		try {
			// 设置发件人邮箱
			Address from = new InternetAddress(mailBean.getSender());
			miMessage.setFrom(from);
			
			//设置收件人邮箱
			Address receiver = new InternetAddress(mailBean.getReceivers());
			miMessage.setRecipient(Message.RecipientType.TO, receiver);
			
			// 设置标题
			miMessage.setSubject(mailBean.getTitle());

			// 设置邮件发送时间
			miMessage.setSentDate(new Date());
			
			//创建附件
			Multipart multipart = new MimeMultipart();
			
			//创建邮件内容
			MimeBodyPart bodyPart = new MimeBodyPart();

			// 设置邮件发送内容
			bodyPart.setContent(mailBean.getMailContent(),"text/html;charset="+mailBean.getCharset());
			
			//发件内容
			multipart.addBodyPart(bodyPart);
			
			//设置附件
			if (null != mailBean.getAttachements()) {
				MimeBodyPart attache = null;
				String fileName = null;
				for(File attachement : mailBean.getAttachements()) {
					attache = new MimeBodyPart();
					attache.setDataHandler(new DataHandler(new FileDataSource(attachement)));
					fileName = FileUtils.getLastName(attachement.getName());
					attache.setFileName(MimeUtility.encodeText(fileName,mailBean.getCharset(),null));
					
					multipart.addBodyPart(attache);
				}
			}
			
			//设置邮件发送内容
			miMessage.setContent(multipart);
			
			// 发送邮件
			Transport.send(miMessage);

			LOGGER.info("邮件发送成功!");
			return true;
		} catch (AddressException e) {
			LOGGER.error("邮件发送失败:  {}  --{}",mailBean.toString(),e.getMessage());
			e.printStackTrace();
			return false;
		} catch (MessagingException e) {
			LOGGER.error("邮件发送失败:  {}  -- {}",mailBean.toString(),e.getMessage());
			e.printStackTrace();
			return false;
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("邮件发送失败:  {}  -- {}",mailBean.toString(),e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
}
