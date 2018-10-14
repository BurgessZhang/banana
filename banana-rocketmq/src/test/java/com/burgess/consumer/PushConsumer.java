package com.burgess.consumer;

import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * @project banana-rocketmq
 * @package com.burgess.consumer
 * @file PushConsumer.java
 * @author burgess.zhang
 * @time 13:53:37/2018-10-14
 * @desc
 */
public class PushConsumer {

	/**
	 * @file PushConsumer.java
	 * @author burgess.zhang
	 * @time 13:53:37/2018-10-14
	 * @desc
	 * @param args
	 * @throws MQClientException 
	 */
	public static void main(String[] args) throws MQClientException {
		/**
		 * 一个应用创建一个Consumer，由应用来维护此对象，可以设置为全局对象或者单例<br>
		 * 注意：ConsumerGroupName需要由应用来保证唯一
		 */
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("testmerchantLeagueConsumerGroup");
		consumer.setNamesrvAddr("192.168.0.192:9876");

		/**
		 * 订阅指定topic下tags分别等于TagA或TagB
		 */
		consumer.subscribe("broker-a", "TagB || TagA");

		/**
		 * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费<br>
		 * 如果非第一次启动，那么按照上次消费的位置继续消费
		 */
		consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

		consumer.registerMessageListener(new MessageListenerConcurrently() {

			/**
			 * 默认msgs里只有一条消息，可以通过设置consumeMessageBatchMaxSize参数来批量接收消息
			 */
			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
				System.out.println(Thread.currentThread().getName() + " Receive New Messages: " + msgs);
				MessageExt msg = msgs.get(0);
				if (msg.getTopic().equals("broker-a")) {
					// 执行TopicTest1的消费逻辑
					if (msg.getTags() != null && msg.getTags().equals("TagA")) {
						// 执行TagA的消费
						String message = new String(msg.getBody());
						System.out.println(message);
					} else if (msg.getTags() != null && msg.getTags().equals("TagB")) {
						// 执行TagB的消费
						String message = new String(msg.getBody());
						System.out.println(message);
					}

				}
				// 消费者向mq服务器返回消费成功的消息
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});

		/**
		 * Consumer对象在使用之前必须要调用start初始化，初始化一次即可<br>
		 */
		consumer.start();

		System.out.println("Consumer Started.");
	}

}
