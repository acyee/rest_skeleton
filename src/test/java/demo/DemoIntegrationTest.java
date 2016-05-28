package demo; /**
 * Created by Anthony on 5/21/16.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port=8080")
public class DemoIntegrationTest {

    private static String baseUrl = "http://localhost:8080/api/demo";
    private RestTemplate restTemplate = new TestRestTemplate();
    private ObjectMapper mapper = new ObjectMapper();


    @Test
    public void demo() throws Exception {
        Demo d = new Demo();
        d.setText("hello world");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(d), headers);

        //create demo
        ResponseEntity<Demo> postResponse  =
                restTemplate.exchange(baseUrl, HttpMethod.POST, entity, Demo.class);

        assertTrue(postResponse.getStatusCode().is2xxSuccessful());

        //read it back
        HttpEntity<String> getEntity = new HttpEntity<>(headers);

        ResponseEntity<Demo> getResponse =
                restTemplate.exchange(baseUrl + "/" + postResponse.getBody().getId(), HttpMethod.GET, getEntity, Demo.class);

        assertTrue(getResponse.getStatusCode().is2xxSuccessful());
    }
}