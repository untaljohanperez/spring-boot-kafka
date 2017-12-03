package udea.user.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import udea.user.model.Bill;
import udea.user.service.UserService;

import java.util.concurrent.CountDownLatch;

@Component
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
    private CountDownLatch latch = new CountDownLatch(1);
    @Autowired
    private UserService userService;
    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "${kafka.topic.billing}")
    public void receive(ConsumerRecord<?, ?> consumerRecord) {
        LOGGER.info("received payload='{}'", consumerRecord.value().toString());
        latch.countDown();
        Bill bill = getBill(consumerRecord.value().toString());
        userService.createOrUpdateUser(bill.getUser());
    }

    private Bill getBill(String jsonBill) {
        try {
            return objectMapper.readValue(jsonBill, Bill.class);
        } catch (Exception e) {
            LOGGER.error(e.toString());
            return null;
        }
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
