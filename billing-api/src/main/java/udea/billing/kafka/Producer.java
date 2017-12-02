package udea.billing.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import udea.billing.model.KafkaMessage;

@Component
public class Producer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendBilling(KafkaMessage kafkaMessage) {
        LOGGER.info("sending payload='{}' to topic='{}'", kafkaMessage.getMessage(), kafkaMessage.getTopic());
        System.out.println("sending payload='{}' to topic='{}'");
        kafkaTemplate.send(kafkaMessage.getTopic(), kafkaMessage.getMessage());
    }
}
