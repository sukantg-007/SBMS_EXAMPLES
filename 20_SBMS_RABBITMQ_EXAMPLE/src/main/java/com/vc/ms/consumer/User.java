package com.vc.ms.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.vc.ms.config.MessageQueue;
import com.vc.ms.entity.OrderStatus;

@Component
public class User {
	@RabbitListener(queues = MessageQueue.RABBITMQ_QUEUE)
	public void consumeMessageQueue(OrderStatus orderStatus) {
		System.out.println("Message Received From Queue : "+orderStatus);
	}
}
