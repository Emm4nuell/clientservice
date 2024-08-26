package br.com.clientservice.infrastructure.config;

import br.com.clientservice.infrastructure.constants.RabbitMqConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMqConfig {

    @Bean
    public Queue sendEmailQueue(){
        return new Queue(RabbitMqConstants.SEND_EMAIL_QUEUE, true);
    }

    @Bean
    public DirectExchange sedEmailExchange(){
        return new DirectExchange(RabbitMqConstants.SEND_EMAIL_EXCHANGE, true, true);
    }

    @Bean
    public Binding routing_key(){
        return BindingBuilder.bind(sendEmailQueue()).to(sedEmailExchange()).with(RabbitMqConstants.EMAIL_ROUTING_KEY);
    }
}
