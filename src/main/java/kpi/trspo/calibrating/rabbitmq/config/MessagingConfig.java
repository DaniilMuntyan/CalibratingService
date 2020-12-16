package kpi.trspo.calibrating.rabbitmq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {
    public static final String CALIBRATE_CAMERA_QUEUE = "calibrate_camera_queue";
    public static final String CALIBRATE_CAMERA_ROUTING = "calibrate_camera_routing";

    public static final String CREATE_CALIBRATOR_QUEUE = "create_calibrator_queue";
    public static final String GET_ALL_CALIBRATORS_QUEUE = "create_all_calibrators_queue";

    public static final String RESPONSE_CALIBRATOR_QUEUE = "response_calibrator_queue";
    public static final String RESPONSE_GET_ALL_CALIBRATORS_QUEUE = "response_get_all_calibrators_queue";
    public static final String RESPONSE_CALIBRATE_CAMERA_QUEUE = "response_calibrate_camera_queue";

    public static final String EXCHANGE = "direct_exchange";

    public static final String CREATE_CALIBRATOR_ROUTING = "create_calibrator_routing_key";
    public static final String GET_ALL_CALIBRATORS_ROUTING = "get_all_calibrators_routing_key";

    public static final String RESPONSE_CALIBRATOR_ROUTING = "response_calibrator_routing_key";
    public static final String RESPONSE_GET_ALL_CALIBRATORS_ROUTING = "response_get_all_calibrators_routing_key";
    public static final String RESPONSE_CALIBRATE_CAMERA_ROUTING = "response_calibrate_camera_routing_key";

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        System.out.println("host = " + connectionFactory.getHost() + " port = " + connectionFactory.getPort() +
                " username = " + connectionFactory.getUsername());
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

}
