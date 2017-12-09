package udea.purchasingapi.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import udea.purchasingapi.model.Bill;
import udea.purchasingapi.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class PurchasingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PurchasingService.class);

    public void processBilling(Bill bill) {
        LOGGER.info("Getting billing to be showing in Purchasing System : " + bill.toString());
        String user = null;

        user = findUser(bill.getUser().getId());
        LOGGER.info("Finding an user from user-api : " + user);
    }

    private String findUser(String id) {
        String url = "http://user-api:4001/user-api/user/" + id;

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        // add request header
        request.addHeader("Content-Type", "application/json");

        HttpResponse response = null;
        BufferedReader rd = null;
        StringBuffer result = null;

        try {
            response = client.execute(request);
            rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            LOGGER.info("Error getting an user from Purchasing System : " + e);
        }

        LOGGER.info("User id : " + id);
        return result.toString();
    }

}
