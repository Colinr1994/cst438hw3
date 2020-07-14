package cst438hw3.controllers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rabbitmq.client.AMQP.Queue;

@Controller
public class Hw3controller {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private Queue queue;
	
}
