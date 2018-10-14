package com.burgess.rocketmq.producer;

import java.util.Objects;
import java.util.concurrent.ExecutorService;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import com.burgess.rocketmq.config.Producer;

/**
 * @project banana-rocketmq
 * @package com.burgess.rocketmq.producer
 * @file ProducerBean.java
 * @author burgess.zhang
 * @time 14:22:36/2018-10-14
 * @desc 
 */
public class ProducerBean {
	
	//生产者创建对象
	private DefaultMQProducer defaultMQProducer;
	
	/**
	 * @throws MQClientException 
	 * @file ProducerBean.java
	 * @authorDefaultMQProducer burgess.zhang
	 * @time 14:24:27/2018-10-14
	 * @desc 启动该producer实例，
	 */
	public void start(Producer producer) throws MQClientException {
		this.defaultMQProducer = new DefaultMQProducer(producer.getProducerGroup());

		this.defaultMQProducer.setNamesrvAddr(producer.getNamesrvHost() +":" + producer.getPort());
		
		this.defaultMQProducer.start();
	}

	/**
	 * @file ProducerBean.java
	 * @author burgess.zhang
	 * @time 14:25:05/2018-10-14
	 * @desc 关闭该producer实例
	 */
	public void shutdown() {
		if (Objects.nonNull(this.defaultMQProducer)) {
			this.defaultMQProducer.shutdown();
		}
	}
	
	/**
	 * @file ProducerBean.java
	 * @author burgess.zhang
	 * @time 14:26:40/2018-10-14
	 * @desc 发送消息
	 * @param message
	 * @return
	 * @throws MQClientException
	 * @throws RemotingException
	 * @throws MQBrokerException
	 * @throws InterruptedException
	 */
	public SendResult send(Message message) throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
		return this.defaultMQProducer.send(message);
	}
	
	public void sendOneway(Message message) throws MQClientException, RemotingException, InterruptedException {
		this.defaultMQProducer.sendOneway(message);
	}
	
	public void sendAsync(Message message,SendCallback sendCallback) throws MQClientException, RemotingException, InterruptedException {
		this.defaultMQProducer.send(message,sendCallback);
	}
	
	public void setCallbackExecutor(final ExecutorService callbackExecutor) {
		this.defaultMQProducer.setCallbackExecutor(callbackExecutor);
	}
}
