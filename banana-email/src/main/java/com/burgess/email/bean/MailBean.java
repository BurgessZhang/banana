package com.burgess.email.bean;

import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Properties;

/**
 * @project banana-email
 * @package com.burgess.email.bean
 * @file MailBean.java
 * @author burgess.zhang
 * @time 下午4:08:20/2018年8月10日
 * @desc 邮件属性封装
 */
public class MailBean implements Serializable {

	private static final long serialVersionUID = 849168267024701774L;

	// 发件人邮箱
	private String sender;
	// 发件人名称
	private String userName;
	// 密码
	private String password;
	// 字符编码
	private String charset;
	// 邮件服务器地址
	private String mailServerHost;
	// 邮件服务器端口号
	private String mailServerPort;
	// 是否需要身份验证
	private boolean validate = false;

	// 收件人
	private String receivers;
	// 标题
	private String title;
	// 邮件内容
	private String mailContent;
	// 发送类型
	private String mimetype;
	// 附件
	private File[] attachements;

	/**
	 * @file MailBean.java
	 * @author burgess.zhang
	 * @time 下午4:21:25/2018年8月10日
	 * @desc 获取邮件会话属性
	 * @return
	 */
	public Properties getProperties() {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", this.mailServerHost);
		properties.put("mail.smtp.port", this.mailServerPort);
		properties.put("mail.smtp.auth", this.validate ? "true" : "false");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.socketFactory.fallback", "false");
		properties.put("mail.smtp.socketFactory.port", "465");

		return properties;
	}

	/**
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * @param sender the sender to set
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the charset
	 */
	public String getCharset() {
		return charset;
	}

	/**
	 * @param charset the charset to set
	 */
	public void setCharset(String charset) {
		this.charset = charset;
	}

	/**
	 * @return the mailServerHost
	 */
	public String getMailServerHost() {
		return mailServerHost;
	}

	/**
	 * @param mailServerHost the mailServerHost to set
	 */
	public void setMailServerHost(String mailServerHost) {
		this.mailServerHost = mailServerHost;
	}

	/**
	 * @return the mailServerPort
	 */
	public String getMailServerPort() {
		return mailServerPort;
	}

	/**
	 * @param mailServerPort the mailServerPort to set
	 */
	public void setMailServerPort(String mailServerPort) {
		this.mailServerPort = mailServerPort;
	}

	/**
	 * @return the validate
	 */
	public boolean isValidate() {
		return validate;
	}

	/**
	 * @param validate the validate to set
	 */
	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	/**
	 * @return the receivers
	 */
	public String getReceivers() {
		return receivers;
	}

	/**
	 * @param receivers the receivers to set
	 */
	public void setReceivers(String receivers) {
		this.receivers = receivers;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the mailContent
	 */
	public String getMailContent() {
		return mailContent;
	}

	/**
	 * @param mailContent the mailContent to set
	 */
	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}

	/**
	 * @return the mimetype
	 */
	public String getMimetype() {
		return mimetype;
	}

	/**
	 * @param mimetype the mimetype to set
	 */
	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	/**
	 * @return the attachements
	 */
	public File[] getAttachements() {
		return attachements;
	}

	/**
	 * @param attachements the attachements to set
	 */
	public void setAttachements(File[] attachements) {
		this.attachements = attachements;
	}

	/**
	 * @file MailBean.java
	 * @author burgess.zhang
	 * @time 下午4:18:00/2018年8月10日
	 * @desc
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MailBean [sender=" + sender + ", userName=" + userName + ", password=" + password + ", charset="
				+ charset + ", mailServerHost=" + mailServerHost + ", mailServerPort=" + mailServerPort + ", validate="
				+ validate + ", receivers=" + receivers + ", title=" + title + ", mailContent=" + mailContent
				+ ", mimetype=" + mimetype + ", attachements=" + Arrays.toString(attachements) + "]";
	}

}
