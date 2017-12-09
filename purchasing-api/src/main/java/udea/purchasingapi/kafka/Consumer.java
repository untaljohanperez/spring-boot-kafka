package udea.purchasingapi.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import udea.purchasingapi.model.Bill;
import udea.purchasingapi.service.PurchasingService;

@Component
    public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private PurchasingService purchasingService;
    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "${kafka.topic.billing-generated}")
    public void consumeBillingGenerated(ConsumerRecord<?, ?> consumerRecord) {
        LOGGER.info("received payload='{}'", consumerRecord.value().toString());
        Bill bill = getBill(consumerRecord.value().toString());
        purchasingService.processBilling(bill);
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
