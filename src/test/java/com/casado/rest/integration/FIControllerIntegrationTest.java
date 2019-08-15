package com.casado.rest.integration;

import com.casado.rest.RestApplication;
import com.casado.rest.challenge.entity.FinancialInstrument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FIControllerIntegrationTest {

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
    public void testGetAllFIs() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/getAllFinancialInstrumentByIds",
                HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
    }

    @Test
    public void testGetFIById() {
        FinancialInstrument fi = restTemplate.getForObject(getRootUrl() + "/financialInstrument/1", FinancialInstrument.class);
        System.out.println(fi.getFiName());
        assertNotNull(fi);
    }


    @Test
    public void testCreateFI() {
        FinancialInstrument fi = new FinancialInstrument();
        fi.setFiName("admin@gmail.com");
        fi.setFiDescription("admin");

        ResponseEntity<FinancialInstrument> postResponse = restTemplate.postForEntity(getRootUrl() + "/financialInstrument", fi, FinancialInstrument.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateFI() {
        int id = 1;
        FinancialInstrument fi = restTemplate.getForObject(getRootUrl() + "/financialInstrument/" + id, FinancialInstrument.class);
        fi.setFiName("admin1");
        fi.setFiDescription("admin2");

        restTemplate.put(getRootUrl() + "/financialInstrument/" + id, fi);

        FinancialInstrument updatedFI = restTemplate.getForObject(getRootUrl() + "/financialInstrument/" + id, FinancialInstrument.class);
        assertNotNull(updatedFI);
    }

    @Test
    public void testDeleteFI() {
        int id = 2;
        FinancialInstrument fi = restTemplate.getForObject(getRootUrl() + "/financialInstrument/" + id, FinancialInstrument.class);
        assertNotNull(fi);

        restTemplate.delete(getRootUrl() + "/financialInstrument/" + id);

        try {
            fi = restTemplate.getForObject(getRootUrl() + "/financialInstrument/" + id, FinancialInstrument.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
