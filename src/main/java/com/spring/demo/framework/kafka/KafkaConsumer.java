package com.spring.demo.framework.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Description: Kafka消息消费者
 * @Author: Super
 * @CreateDate: 2020/7/15 21:31
 * @Version: 1.0
 */
@Component
@Slf4j
public class KafkaConsumer {

	@KafkaListener(topics = {"test"})
	public void receiveMsg(ConsumerRecord<?, ?> consumerRecord) {
		Optional<?> kafkaMsg = Optional.ofNullable(consumerRecord.value());
		log.info("Kafka receiveMsg, consumerRecord is {}", consumerRecord.toString());
		if (kafkaMsg.isPresent()) {
			Object msg = kafkaMsg.get();
			log.info("receiveMsg is {}", msg.toString());
		}
	}
}
