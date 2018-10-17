package com.burgess.rocketmq.config;

import java.io.Serializable;

/**
 * @project banana-rocketmq
 * @package com.burgess.rocketmq.config
 * @file Producer.java
 * @author burgess.zhang
 * @time 13:59:25/2018-10-14
 * @desc 生产者配置
 */
public class Producer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//生产者组
	private String producerGroup;
	//namesrv地址
	private String namesrvHost;
	//端口号
	private String port;
	//主题
	private String topic;
	//标签
	private String tag;
	//唯一标识
	private String key;
	//发送的内容
	private String body;
	
	/**
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}
	/**
	 * @param topic the topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}
	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}
	/**
	 * @return the producerGroup
	 */
	public String getProducerGroup() {
		return producerGroup;
	}
	/**
	 * @param producerGroup the producerGroup to set
	 */
	public void setProducerGroup(String producerGroup) {
		this.producerGroup = producerGroup;
	}
	/**
	 * @return the namesrvHost
	 */
	public String getNamesrvHost() {
		return namesrvHost;
	}
	/**
	 * @param namesrvHost the namesrvHost to set
	 */
	public void setNamesrvHost(String namesrvHost) {
		this.namesrvHost = namesrvHost;
	}
	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}
	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}
	/**
	 * @file Producer.java
	 * @author burgess.zhang
	 * @time 21:27:56/2018-10-16
	 * @desc 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Producer [producerGroup=" + producerGroup + ", namesrvHost=" + namesrvHost + ", port=" + port
				+ ", topic=" + topic + ", tag=" + tag + ", key=" + key + ", body=" + body + "]";
	}

}
