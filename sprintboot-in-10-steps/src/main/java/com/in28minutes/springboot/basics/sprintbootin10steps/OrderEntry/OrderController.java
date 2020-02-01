package com.in28minutes.springboot.basics.sprintbootin10steps.OrderEntry;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.json.JSONException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@RestController
public class OrderController {
    String user = "rzp_test_HZ8W2AX9wA0wmX";
    String password = "DVoFGYh0DsNHeaz1XmYjX2pG";

    private HttpHeaders createHttpHeaders(String user, String password) {
        String notEncoded = user + ":" + password;
        String encodedAuth = Base64.getEncoder().encodeToString(notEncoded.getBytes());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Basic " + encodedAuth);
        return headers;
    }

    @CrossOrigin
    @PostMapping("/getpaymentlink")
    public JSONObject getPaymentLink(@RequestBody Order order) throws JSONException, ParseException {
        final String uri = "https://api.razorpay.com/v1/orders";
        String result = "";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = null;
        JSONObject json = new JSONObject();
        json.put("amount", order.getAmount());
        json.put("currency", order.getCurrency());
        json.put("payment_capture", order.getPayment_capture());

        HttpHeaders headers = createHttpHeaders(user,password);
        HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);
        response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
        System.out.println("**********"+response+"************");
        JSONParser parser = new JSONParser();
        JSONObject jsonResponse = (JSONObject) parser.parse(response.getBody().toString());

        JSONObject orderId = new JSONObject();
        orderId.put("orderId",jsonResponse.get("id").toString());
        return orderId;
    }
}

