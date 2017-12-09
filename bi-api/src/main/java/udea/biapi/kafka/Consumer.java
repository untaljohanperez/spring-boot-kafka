package udea.biapi.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import udea.biapi.model.Bill;
import udea.biapi.model.KafkaMessage;
import udea.biapi.service.BiService;

@Component
    public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private BiService biService;
    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "${kafka.topic.billing-generated}")
    public void consumeBillingGenerated(ConsumerRecord<?, ?> consumerRecord) {
        LOGGER.info("received payload='{}'", consumerRecord.value().toString());
        Bill bill = getBill(consumerRecord.value().toString());
        biService.processBilling(bill);
    }

    private Bill getBill(String jsonBill) {
        try {
            return objectMapper.readValue(jsonBill, Bill.class);
        } catch (Exception e) {
            LOGGER.error(e.toString());
            return null;
        }
    }
}
