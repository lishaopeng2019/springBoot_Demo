package com.spring.demo.framework.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.protocol.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description: Kafka消息生产者
 * @Author: Super
 * @CreateDate: 2020/7/15 21:22
 * @Version: 1.0
 */
@Component
@Slf4j
public class KafkaProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	/**
	 * Kafka发送消息到指定Topic
	 *
	 * @Param   [topic:Topic, msg:发送的消息]
	 */
	public void sendMsg(String topic, String msg) {
		ProducerRecord<String, String> producerRecord = new ProducerRecord(topic, msg);
		log.info("Kafka sendMsg, topic is {}, msg is {}", topic, msg);
		// kafkaTemplate.send(topic, msg);
		kafkaTemplate.send(producerRecord);
	}
}
