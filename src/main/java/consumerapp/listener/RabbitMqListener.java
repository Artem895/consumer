package consumerapp.listener;

import consumerapp.config.RabbitConfig;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class RabbitMqListener {

    Logger logger=Logger.getLogger(RabbitMqListener.class);

    @RabbitListener(queues = RabbitConfig.ALERT_QUEUE)
    public void listenalert(String message){
        logger.info("message from alert queue"+message);
    }
    @RabbitListener(queues = RabbitConfig.DAILY_QUEUE)
    public void listendaily(String message){
        logger.info("message from daily queue"+message);

    }
    @RabbitListener(queues = RabbitConfig.ERROR_QUEUE)
    public void listenerror(String message){
        logger.info("message from error queue"+message);
    }

}
