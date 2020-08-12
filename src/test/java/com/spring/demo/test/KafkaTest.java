package com.spring.demo.test;

import com.spring.demo.framework.kafka.KafkaProducer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @Description: TODO
 * @Author: Super
 * @CreateDate: 2020/7/15 21:59
 * @Version: 1.0
 */
@SpringBootTest
public class KafkaTest {

	@Autowired
	private KafkaProducer kafkaProducer;
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Test
	void test() {
		kafkaProducer.sendMsg("test", "Hello, Kafka!");
	}
}
