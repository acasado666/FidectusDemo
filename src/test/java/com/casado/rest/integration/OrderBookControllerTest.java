package com.casado.rest.integration;


import com.casado.rest.RestApplication;
import com.casado.rest.challenge.entity.OrderBook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class OrderBookControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + "8080";
    }

    @Test
    public void contextLoads() {

    }

    @Test
    public void testGetAllOBs() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/getAllOrderBooktByIds",
                HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
    }

    @Test
    public void testGetOBById() {
        OrderBook ob = restTemplate.getForObject(getRootUrl() + "/orderBook/1", OrderBook.class);
        System.out.println(ob.getDescription());
        System.out.println(ob.getTitle());
        assertNotNull(ob);
    }

    //This test will not work is security is activated
    @Test
    public void testCreateOB() {
        OrderBook ob = new OrderBook();
        ob.setTitle("admin@gmail.com");
        ob.setDescription("admin");
        ob.setId(5L);

        ResponseEntity<OrderBook> postResponse = restTemplate.postForEntity(getRootUrl() + "/orderBook", ob, OrderBook.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

}
