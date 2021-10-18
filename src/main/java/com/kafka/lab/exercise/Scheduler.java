package com.kafka.lab.exercise;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
	
	
	
	@Autowired
	private Producer producer;
	
	@Scheduled(cron = "0/10 * * * * *")
	public void schedule() {
		int randomInt = ThreadLocalRandom.current().nextInt(1, 101);
		producer.sendMessage(String.valueOf(randomInt), new Date().toString());
	}

}
