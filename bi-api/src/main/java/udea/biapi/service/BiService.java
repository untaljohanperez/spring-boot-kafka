package udea.biapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import udea.biapi.model.Bill;
import udea.biapi.model.ItemOrder;

import java.util.List;

@Component
public class BiService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BiService.class);

    public void processBilling(Bill bill) {
        LOGGER.info("Getting billing to be showing in BI System : " + bill.toString());
    }

}
