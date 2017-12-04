package udea.inventoryapi.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import udea.inventoryapi.model.Bill;
import udea.inventoryapi.model.KafkaMessage;
import udea.inventoryapi.service.InventoryService;

@Component
    public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private Producer producer;
    @Value("${kafka.topic.billing-inventory-processed}")
    private String inventoryProcessedTopic;


    @KafkaListener(topics = "${kafka.topic.billing-user-created}")
    public void consumeBilling(ConsumerRecord<?, ?> consumerRecord) {
        LOGGER.info("received payload='{}'", consumerRecord.value().toString());
        Bill bill = getBill(consumerRecord.value().toString());
        inventoryService.processOrder(bill.getOrder());
        producer.publishMessage(new KafkaMessage(inventoryProcessedTopic, consumerRecord.value().toString()));
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
