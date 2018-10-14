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
	 * @time 14:41:50/2018-10-14
	 * @desc 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Producer [producerGroup=" + producerGroup + ", namesrvHost=" + namesrvHost + ", port=" + port + "]";
	}

}
