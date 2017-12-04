package udea.inventoryapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import udea.inventoryapi.model.ItemOrder;

import java.util.List;

@Component
public class InventoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryService.class);

    public void processOrder(List<ItemOrder> order) {
        order.stream().forEach(this::manageInventory);
    }

    private void manageInventory(ItemOrder itemOrder) {
        LOGGER.info("Processing " + itemOrder.toString());
    }
}
