package com.burgess.rocketmq.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.burgess.rocketmq.config.Producer;

/**
 * @project banana-rocketmq
 * @package com.burgess.rocketmq.producer
 * @file DirecrorProducer.java
 * @author burgess.zhang
 * @time 21:23:19/2018-10-16
 * @desc 生产者
 */
public class DirecrorProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(DirecrorProducer.class);

	private ProducerBean producerBean;

	public DirecrorProducer(ProducerBean producerBean) {
		this.producerBean = producerBean;
	}

	/**
	 * @file DirecrorProducer.java
	 * @author burgess.zhang
	 * @time 21:29:09/2018-10-16
	 * @desc 发送消息
	 * @param producer
	 */
	public void send(Producer producer) {
		try {
			LOGGER.info("[class: DirecrorProducer.java]-[method: send]-[function: {}]-[params: producer {}]", "发送消息",
					producer.toString());
			this.producerBean.start(producer);

			Message message = new Message(producer.getTopic(), producer.getTag(), producer.getKey(),
					producer.getBody().getBytes());

			SendResult sendResult = this.producerBean.send(message);

			LOGGER.info("[class: DirecrorProducer.java]-[method: send]-[function: {}]-[params: producer {}]",
					"发送消息返回结果", sendResult.toString());

			this.producerBean.shutdown();
		} catch (MQClientException e) {
			LOGGER.error("[class: DirecrorProducer.java]-[method: send]-[function: {}]-[params: producer]-[结果: {}]",
					"发送消息异常", e.getMessage());
		} catch (RemotingException e) {
			LOGGER.error("[class: DirecrorProducer.java]-[method: send]-[function: {}]-[params: producer]-[结果: {}]",
					"发送消息异常", e.getMessage());
		} catch (MQBrokerException e) {
			LOGGER.error("[class: DirecrorProducer.java]-[method: send]-[function: {}]-[params: producer]-[结果: {}]",
					"发送消息异常", e.getMessage());
		} catch (InterruptedException e) {
			LOGGER.error("[class: DirecrorProducer.java]-[method: send]-[function: {}]-[params: producer]-[结果: {}]",
					"发送消息异常", e.getMessage());
		}
	}

	/**
	 * @file DirecrorProducer.java
	 * @author burgess.zhang
	 * @time 21:36:30/2018-10-16
	 * @desc 发送一对多消息
	 * @param producer
	 */
	public void sendOneway(Producer producer) {

		try {
			LOGGER.info("[class: DirecrorProducer.java]-[method: sendOneway]-[function: {}]-[params: producer {}]",
					"发送一对多消息", producer.toString());

			this.producerBean.start(producer);

			Message message = new Message(producer.getTopic(), producer.getTag(), producer.getKey(),
					producer.getBody().getBytes());

			this.producerBean.sendOneway(message);

			this.producerBean.shutdown();

		} catch (MQClientException e) {
			LOGGER.error("[class: DirecrorProducer.java]-[method: sendOneway]-[function: {}]-[params: producer]-[结果: {}]",
					"发送一对多消息", null);
		} catch (RemotingException e) {
			LOGGER.error("[class: DirecrorProducer.java]-[method: sendOneway]-[function: {}]-[params: producer]-[结果: {}]",
					"发送一对多消息", null);
		} catch (InterruptedException e) {
			LOGGER.error("[class: DirecrorProducer.java]-[method: sendOneway]-[function: {}]-[params: producer]-[结果: {}]",
					"发送一对多消息", null);
		}
	}
	
}
