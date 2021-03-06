package com.vc.ms.publisher;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vc.ms.config.MessageQueue;
import com.vc.ms.entity.Order;
import com.vc.ms.entity.OrderStatus;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@PostMapping("/{restaurantName}")
	public String bookOrder(@RequestBody Order order,@PathVariable String restaurantName) {
		order.setOid(UUID.randomUUID().toString());
		OrderStatus orderStatus = new OrderStatus(order,"PROCESS","Order Placed Succeessfully in "+restaurantName);
		rabbitTemplate.convertAndSend(MessageQueue.RABBITMQ_EXCHANGE,MessageQueue.RABBITMQ_ROUTING_KEY,orderStatus);
		return "Success!!";
	}
}

