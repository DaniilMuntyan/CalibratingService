package kpi.trspo.calibrating.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CalibrateConfig {

    @Bean
    public Queue calibrate_queue() {
        return new Queue(MessagingConfig.CALIBRATE_CAMERA_QUEUE);
    }

    @Bean
    public Binding binding_calibrating_queue(Queue calibrate_queue, DirectExchange exchange) {
        return BindingBuilder.bind(calibrate_queue).to(exchange).with(MessagingConfig.CALIBRATE_CAMERA_ROUTING);
    }

    @Bean
    public Queue response_calibrate_camera_queue() {
        return new Queue(MessagingConfig.RESPONSE_CALIBRATE_CAMERA_QUEUE);
    }

    @Bean
    public Binding binding_response_calibrate_camera(Queue response_calibrate_camera_queue, DirectExchange exchange) {
        return BindingBuilder.bind(response_calibrate_camera_queue).to(exchange).with(MessagingConfig.RESPONSE_CALIBRATE_CAMERA_ROUTING);
    }
}
