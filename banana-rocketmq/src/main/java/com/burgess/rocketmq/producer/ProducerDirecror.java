package com.burgess.rocketmq.producer;

import com.burgess.rocketmq.config.Producer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tom.zhang
 * @project banana
 * @package com.burgess.rocketmq.producer
 * @file ProducerDirecror.java
 * @time 2018-10-17 14:05
 * @desc 生产者指挥
 */
public class ProducerDirecror {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerDirecror.class);

    private ProducerBean producerBean;

    public ProducerDirecror(ProducerBean producerBean) {
        this.producerBean = producerBean;
    }

    /**
     * @param '[producer]
     * @return org.apache.rocketmq.client.producer.SendResult
     * @file ProducerDirecror.java
     * @method send
     * @desc 发送消息
     * @author free.zhang
     * @date 2018/10/17 14:11
     */
    public void send(Producer producer) {
        try {
            LOGGER.info("[class: ProducerDirecror.java]-[method: send]-[function: {}] [参数/结果]: {}", "发送消息", producer.toString());
            this.producerBean.start(producer);

            Message message = new Message("topic", "tags", "keys", "".getBytes());

            SendResult result = this.producerBean.send(message);

            LOGGER.info("[class: ProducerDirecror.java]-[method: send]-[function: {}] [参数/结果]: {}", "发送消息结果",result.toString());

            this.producerBean.shutdown();

        } catch (MQClientException e) {
            LOGGER.error("[class: ProducerDirecror.java]-[method: send]-[function: {}] [参数/结果]: {}", "发送消息", e.getMessage());
        } catch (InterruptedException e) {
            LOGGER.error("[class: ProducerDirecror.java]-[method: send]-[function: {}] [参数/结果]: {}", "发送消息", e.getMessage());
        } catch (RemotingException e) {
            LOGGER.error("[class: ProducerDirecror.java]-[method: send]-[function: {}] [参数/结果]: {}", "发送消息", e.getMessage());
        } catch (MQBrokerException e) {
            LOGGER.error("[class: ProducerDirecror.java]-[method: send]-[function: {}] [参数/结果]: {}", "发送消息", e.getMessage());
        }


    }

}
