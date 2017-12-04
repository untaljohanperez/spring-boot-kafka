package udea.billing.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import udea.billing.model.KafkaMessage;

@Component
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private Producer producer;

    @Value("${kafka.topic.billing-generated}")
    private String billingGeneratedTopic;

    @KafkaListener(topics = "${kafka.topic.billing-inventory-processed}")
    public void consumeUserCreated(ConsumerRecord<?, ?> consumerRecord) {
        LOGGER.info(consumerRecord.topic() + "-" +  consumerRecord.toString());
        producer.publishMessage(new KafkaMessage(billingGeneratedTopic, consumerRecord.value().toString()));
    }
}
