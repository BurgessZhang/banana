package com.burgess.rocketmq.producer;

import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

import org.apache.rocketmq.client.QueryResult;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.*;
import org.apache.rocketmq.remoting.exception.RemotingException;

import com.burgess.rocketmq.config.Producer;

/**
 * @author burgess.zhang
 * @project banana-rocketmq
 * @package com.burgess.rocketmq.producer
 * @file ProducerBean.java
 * @time 14:22:36/2018-10-14
 * @desc
 */
public class ProducerBean {

    // 生产者创建对象
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

        this.defaultMQProducer.setNamesrvAddr(producer.getNamesrvHost() + ":" + producer.getPort());

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
     * @param message
     * @return
     * @throws MQClientException
     * @throws RemotingException
     * @throws MQBrokerException
     * @throws InterruptedException
     * @file ProducerBean.java
     * @author burgess.zhang
     * @time 14:26:40/2018-10-14
     * @desc 发送消息
     */
    public SendResult send(Message message)
            throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
        return this.defaultMQProducer.send(message);
    }

    /**
     * @param message 消息内容
     * @param timeout 超时时间
     * @return
     * @throws MQClientException
     * @throws RemotingException
     * @throws MQBrokerException
     * @throws InterruptedException
     * @file ProducerBean.java
     * @author burgess.zhang
     * @time 上午11:55:02/2018年10月17日
     * @desc 发送消息
     */
    public SendResult send(Message message, long timeout)
            throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
        return this.defaultMQProducer.send(message, timeout);
    }

    /**
     * @param '[msg, sendCallback 发送完成执行回调方法：执行成功或执行失败]
     * @return void
     * @file ProducerBean.java
     * @method send
     * @desc 发送消息
     * @author free.zhang
     * @date 2018/10/17 13:11
     */
    public void send(Message msg, SendCallback sendCallback) throws MQClientException, RemotingException, InterruptedException {
        this.defaultMQProducer.send(msg, sendCallback);
    }

    /**
     * @param '[message, sendCallback 发送完成执行回调方法：执行成功或执行失败, timeout 发送超时时间]
     * @return void
     * @file ProducerBean.java
     * @method send
     * @desc 发送消息
     * @author free.zhang
     * @date 2018/10/17 13:13
     */
    public void send(Message message, SendCallback sendCallback, long timeout) throws RemotingException, MQClientException, InterruptedException {
        this.defaultMQProducer.send(message, sendCallback, timeout);
    }

    /**
     * @param '[message]
     * @return void
     * @file ProducerBean.java
     * @method sendOneway
     * @desc 单向发送消息
     * @author free.zhang
     * @date 2018/10/17 13:14
     */
    public void sendOneway(Message message) throws MQClientException, RemotingException, InterruptedException {
        this.defaultMQProducer.sendOneway(message);
    }

    /**
     * @param '[message, queue 目标消息队列]
     * @return org.apache.rocketmq.client.producer.SendResult
     * @file ProducerBean.java
     * @method send
     * @desc 将消息发送到指定队列
     * @author free.zhang
     * @date 2018/10/17 13:17
     */
    public SendResult send(Message message, MessageQueue queue) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        return this.defaultMQProducer.send(message, queue);
    }

    /**
     * @param '[message, queue 目标消息队列, timeout 超时时间]
     * @return org.apache.rocketmq.client.producer.SendResult
     * @file ProducerBean.java
     * @method send
     * @desc 将消息发送打指定队列
     * @author free.zhang
     * @date 2018/10/17 13:18
     */
    public SendResult send(Message message, MessageQueue queue, long timeout) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        return this.defaultMQProducer.send(message, queue, timeout);
    }

    /**
     * @param '[message, queue 目标消息队列, sendCallback 发送完成执行回调方法：执行成功或执行失败, timeout 发送超时时间]
     * @return void
     * @file ProducerBean.java
     * @method send
     * @desc 将消息发送到指定队列
     * @author free.zhang
     * @date 2018/10/17 13:20
     */
    public void send(Message message, MessageQueue queue, SendCallback sendCallback) throws RemotingException, MQClientException, InterruptedException {
        this.defaultMQProducer.send(message, queue, sendCallback);
    }

    /**
     * @param '[message, queue 目标消息队列, sendCallback 发送完成执行回调方法：执行成功或执行失败, timeout 发送超时时间]
     * @return void
     * @file ProducerBean.java
     * @method send
     * @desc 将消息发送到指定队列
     * @author free.zhang
     * @date 2018/10/17 13:21
     */
    public void send(Message message, MessageQueue queue, SendCallback sendCallback, long timeout) throws RemotingException, MQClientException, InterruptedException {
        this.defaultMQProducer.send(message, queue, sendCallback, timeout);
    }

    /**
     * @param '[message, queue 目标消息队列]
     * @return void
     * @file ProducerBean.java
     * @method sendOneway
     * @desc 单向发送消息到指定队列
     * @author free.zhang
     * @date 2018/10/17 13:22
     */
    public void sendOneway(Message message, MessageQueue queue) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        this.defaultMQProducer.send(message, queue);
    }

    /**
     * @param '[message, selector 消息队列选择器，通过它得到目标消息队列, arg 随着消息队列选择器工作参数]
     * @return org.apache.rocketmq.client.producer.SendResult
     * @file ProducerBean.java
     * @method send
     * @desc 根据消息队列选择器发送消息
     * @author free.zhang
     * @date 2018/10/17 13:24
     */
    public SendResult send(Message message, MessageQueueSelector selector, Object arg) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        return this.defaultMQProducer.send(message, selector, arg);
    }

    /**
     * @param '[message, selector 消息队列选择器，通过它得到目标消息队列, arg 随着消息队列选择器工作参数, timeout 超时时间]
     * @return org.apache.rocketmq.client.producer.SendResult
     * @file ProducerBean.java
     * @method send
     * @desc 根据消息队列选择器发送消息
     * @author free.zhang
     * @date 2018/10/17 13:33
     */
    public SendResult send(Message message, MessageQueueSelector selector, Object arg, long timeout) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        return this.defaultMQProducer.send(message, selector, arg, timeout);
    }

    /**
     * @file ProducerBean.java
     * @method send
     * @desc 根据消息队列选择器发送消息
     * @author free.zhang
     * @date 2018/10/17 13:35
     * @param '[message, selector 消息队列选择器，通过它得到目标消息队列, arg 随着消息队列选择器工作参数, sendCallback 回调函数]
     * @return void
     */
    public void send(Message message, MessageQueueSelector selector, Object arg, SendCallback sendCallback) throws RemotingException, MQClientException, InterruptedException {
        this.defaultMQProducer.send(message, selector, arg, sendCallback);
    }

    /**
     * @file ProducerBean.java
     * @method send
     * @desc 根据消息队列选择器发送消息
     * @author free.zhang
     * @date 2018/10/17 13:37
     * @param '[message, selector 消息队列选择器，通过它得到目标消息队列, arg 随着消息队列选择器工作参数, sendCallback 回调函数, timeout 超时时间]
     * @return void
     */
    public void send(Message message, MessageQueueSelector selector, Object arg, SendCallback sendCallback, long timeout) throws RemotingException, MQClientException, InterruptedException {
        this.defaultMQProducer.send(message, selector, arg, sendCallback, timeout);
    }

    /**
     * @file ProducerBean.java
     * @method sendOneway
     * @desc 根据消息队列选择器单向发送消息
     * @author free.zhang
     * @date 2018/10/17 13:39
     * @param '[message, selector 消息队列选择器，通过它得到目标消息队列, arg 随着消息队列选择器工作参数]
     * @return void
     */
    public void sendOneway(Message message, MessageQueueSelector selector, Object arg) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        this.defaultMQProducer.send(message, selector, arg);
    }

    /**
     * @file ProducerBean.java
     * @method sendMessageInTransaction
     * @desc 发送事务性消息
     * @author free.zhang
     * @date 2018/10/17 13:42
     * @param '[message, tranExecuter 本地事务执行人, arg 本地事务执行人参数]
     * @return org.apache.rocketmq.client.producer.TransactionSendResult
     */
    public TransactionSendResult sendMessageInTransaction(Message message, LocalTransactionExecuter tranExecuter,final Object arg) throws MQClientException {
        return this.defaultMQProducer.sendMessageInTransaction(message, tranExecuter, arg);
    }

    /**
     * @file ProducerBean.java
     * @method createTopic
     * @desc 主题创建
     * @author free.zhang
     * @date 2018/10/17 13:44
     * @param '[key, newTopic 主题名称, queueNum 队列号]
     * @return void
     */
    public void createTopic(String key, String newTopic, int queueNum) throws MQClientException {
        this.defaultMQProducer.createTopic(key, newTopic, queueNum);
    }

    /**
     * @file ProducerBean.java
     * @method createTopic
     * @desc 主题创建
     * @author free.zhang
     * @date 2018/10/17 13:48
     * @param '[key, newTopic 主题名称, queueNum 队列号, topicSysFlag 主题系统标识]
     * @return void
     */
    public void createTopic(String key, String newTopic, int queueNum, int topicSysFlag) throws MQClientException {
        this.defaultMQProducer.createTopic(key, newTopic, queueNum,topicSysFlag);
    }

    /**
     * @file ProducerBean.java
     * @method searchOffset
     * @desc 搜索指定时间正在使用的队列
     * @author free.zhang
     * @date 2018/10/17 13:50
     * @param '[queue, timestamp]
     * @return long
     */
    public long searchOffset(MessageQueue queue, long timestamp) throws MQClientException {
        return this.defaultMQProducer.searchOffset(queue, timestamp);
    }

    /**
     * @file ProducerBean.java
     * @method maxOffset
     * @desc 查询指定队列的最大偏移量
     * @author free.zhang
     * @date 2018/10/17 13:53
     * @param '[queue]
     * @return long
     */
    public long maxOffset(MessageQueue queue) throws MQClientException {
        return this.defaultMQProducer.maxOffset(queue);
    }

    /**
     * @file ProducerBean.java
     * @method minOffset
     * @desc 查询指定学生的最小偏移量
     * @author free.zhang
     * @date 2018/10/17 13:54
     * @param '[queue]
     * @return long
     */
    public long minOffset(MessageQueue queue) throws MQClientException {
        return this.defaultMQProducer.minOffset(queue);
    }

    /**
     * @file ProducerBean.java
     * @method earliestMsgStoreTime
     * @desc 查询队列当中最早的消息存储时间
     * @author free.zhang
     * @date 2018/10/17 13:55
     * @param '[queue]
     * @return long
     */
    public long earliestMsgStoreTime(MessageQueue queue) throws MQClientException {
        return this.defaultMQProducer.earliestMsgStoreTime(queue);
    }

    /**
     * @file ProducerBean.java
     * @method viewMessage
     * @desc 根据偏移量查询消息ID
     * @author free.zhang
     * @date 2018/10/17 13:56
     * @param '[offsetMsgId]
     * @return org.apache.rocketmq.common.message.MessageExt
     */
    public MessageExt viewMessage(String offsetMsgId) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        return this.defaultMQProducer.viewMessage(offsetMsgId);
    }

    /**
     * @file ProducerBean.java
     * @method queryMessage
     * @desc 根据key查询消息
     * @author free.zhang
     * @date 2018/10/17 13:57
     * @param '[topic, key, maxNum 最大数量, begin 开始位置, end 结束位置]
     * @return org.apache.rocketmq.client.QueryResult
     */
    public QueryResult queryMessage(String topic, String key, int maxNum, long begin, long end) throws MQClientException, InterruptedException {
        return this.defaultMQProducer.queryMessage(topic, key, maxNum, begin, end);
    }

    /**
     * @file ProducerBean.java
     * @method viewMessage
     * @desc 根据ID查询指定的消息
     * @author free.zhang
     * @date 2018/10/17 13:58
     * @param '[topic, msgId]
     * @return org.apache.rocketmq.common.message.MessageExt
     */
    public MessageExt viewMessage(String topic,String msgId) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        return this.defaultMQProducer.viewMessage(topic, msgId);
    }

    /**
     * @file ProducerBean.java
     * @method send
     * @desc 批量发送消息
     * @author free.zhang
     * @date 2018/10/17 14:00
     * @param '[messages]
     * @return org.apache.rocketmq.client.producer.SendResult
     */
    public SendResult send(Collection<Message> messages) throws MQClientException, RemotingException, MQBrokerException, InterruptedException {

        return this.defaultMQProducer.send(messages);
    }

    /**
     * @file ProducerBean.java
     * @method send
     * @desc 批量发送消息
     * @author free.zhang
     * @date 2018/10/17 14:01
     * @param '[messages, timeout]
     * @return org.apache.rocketmq.client.producer.SendResult
     */
    public SendResult send(Collection<Message> messages,long timeout) throws MQClientException, RemotingException, MQBrokerException, InterruptedException {

        return this.defaultMQProducer.send(messages, timeout);
    }

    /**
     * @file ProducerBean.java
     * @method send
     * @desc 向指定队列批量发送消息
     * @author free.zhang
     * @date 2018/10/17 14:01
     * @param '[messages, messageQueue]
     * @return org.apache.rocketmq.client.producer.SendResult
     */
    public SendResult send(Collection<Message> messages,MessageQueue messageQueue) throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
        return this.defaultMQProducer.send(messages, messageQueue);
    }

    /**
     * @file ProducerBean.java
     * @method send
     * @desc 向指定队列批量发送消息
     * @author free.zhang
     * @date 2018/10/17 14:01
     * @param '[msgs, messageQueue, timeout]
     * @return org.apache.rocketmq.client.producer.SendResult
     */
    public SendResult send(Collection<Message> messages, MessageQueue messageQueue,long timeout) throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
        return this.defaultMQProducer.send(messages, messageQueue, timeout);
    }

    /**
     * @file ProducerBean.java
     * @method setCallbackExecutor
     * @desc 设置一个执行人用于执行回调方法
     * @author free.zhang
     * @date 2018/10/17 14:02
     * @param '[callbackExecutor]
     * @return void
     */
    public void setCallbackExecutor(final ExecutorService callbackExecutor) {
        this.defaultMQProducer.setCallbackExecutor(callbackExecutor);
    }

}
