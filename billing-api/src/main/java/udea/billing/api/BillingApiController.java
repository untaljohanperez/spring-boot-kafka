package udea.billing.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import udea.billing.kafka.Consumer;
import udea.billing.kafka.Producer;
import udea.billing.model.Bill;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import udea.billing.model.KafkaMessage;
import udea.billing.service.BillingService;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

@Controller
public class BillingApiController implements BillingApi {

    private static final Logger log = LoggerFactory.getLogger(BillingApiController.class);

    private HttpServletRequest request;
    private BillingService billingService;

    @Autowired
    public BillingApiController(HttpServletRequest request, BillingService billingService) {
        this.request = request;
        this.billingService = billingService;
    }

    public ResponseEntity<Bill> newBill(@ApiParam()  @Valid @RequestBody Bill bill) {
        return new ResponseEntity<Bill>(billingService.createBill(bill), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> getBilling(@PathVariable(value = "id")String id) {
        return new ResponseEntity<String>(id + "hola", HttpStatus.OK);
    }
}
