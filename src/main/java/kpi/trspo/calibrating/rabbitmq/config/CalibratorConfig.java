package kpi.trspo.calibrating.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CalibratorConfig {
    @Bean
    public Queue calibrator_queue() {
        return new Queue(MessagingConfig.CREATE_CALIBRATOR_QUEUE);
    }

    @Bean
    public Queue response_calibrator_queue() {
        return new Queue(MessagingConfig.RESPONSE_CALIBRATOR_QUEUE);
    }

    @Bean
    public Binding binding_create_calibrator(Queue calibrator_queue, DirectExchange exchange) {
        return BindingBuilder.bind(calibrator_queue).to(exchange).with(MessagingConfig.CREATE_CALIBRATOR_ROUTING);
    }

    @Bean
    public Binding binding_response_calibrator(Queue response_calibrator_queue, DirectExchange exchange) {
        return BindingBuilder.bind(response_calibrator_queue).to(exchange).with(MessagingConfig.RESPONSE_CALIBRATOR_ROUTING);
    }

    @Bean
    public Queue get_all_calibrators_queue() {
        return new Queue(MessagingConfig.GET_ALL_CALIBRATORS_QUEUE);
    }

    @Bean
    public Queue response_all_calibrators_queue() {
        return new Queue(MessagingConfig.RESPONSE_GET_ALL_CALIBRATORS_QUEUE);
    }

    @Bean
    public Binding binding_get_all_calibrators(Queue get_all_calibrators_queue, DirectExchange exchange) {
        return BindingBuilder.bind(get_all_calibrators_queue).to(exchange).with(MessagingConfig.GET_ALL_CALIBRATORS_ROUTING);
    }

    @Bean
    public Binding binding_response_all_calibrators(Queue response_all_calibrators_queue, DirectExchange exchange) {
        return BindingBuilder.bind(response_all_calibrators_queue).to(exchange).with(MessagingConfig.RESPONSE_GET_ALL_CALIBRATORS_ROUTING);
    }


}
