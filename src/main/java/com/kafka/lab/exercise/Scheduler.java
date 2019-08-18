package com.kafka.lab.exercise;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
	
	
	
	@Autowired
	private Producer producer;
	
	@Scheduled(cron = "0/10 * * * * *")
	public void schedule() {
		producer.sendMessage(new Date().toString());
	}

}
