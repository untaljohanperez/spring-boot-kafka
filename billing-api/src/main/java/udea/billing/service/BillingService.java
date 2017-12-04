package udea.billing.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import udea.billing.api.BillingApiController;
import udea.billing.kafka.Producer;
import udea.billing.model.Bill;
import udea.billing.model.KafkaMessage;

import java.util.UUID;

@Component
public class BillingService {
    private static final Logger log = LoggerFactory.getLogger(BillingApiController.class);

    @Autowired
    private Producer producer;
    @Autowired
    ObjectMapper mapper = new ObjectMapper();

    @Value("${kafka.topic.billing}")
    private String createUserTopic;

    public Bill createBill(Bill bill) {
        try {
            bill.setId(UUID.randomUUID().toString());
            producer.publishMessage(new KafkaMessage(createUserTopic, mapper.writeValueAsString(bill)));
            return bill;
        } catch (Exception e) {
            log.error(e.toString());
            return bill;
        }
    }
}
