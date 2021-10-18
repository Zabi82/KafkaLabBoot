package com.kafka.lab.exercise;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
	private final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@KafkaListener(topics = "timestamp", groupId = "test-group")
	public void consume(ConsumerRecord<String, String> record) {
		logger.info(String.format("Key is %s, Consumed Message -> %s from partition %s and offset %s", record.key(), record.value(), record.partition(), record.offset()));
	}
}