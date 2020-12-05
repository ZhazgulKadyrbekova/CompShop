package com.example.demo;
import com.example.demo.entity.CompEntity;

//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class CompControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String url(){
        return "http://localhost:" + port;
    }

    @Test
    public void addElementTest() {
        CompEntity compEntity = new CompEntity();
        ResponseEntity<CompEntity> postResponse = restTemplate.postForEntity(url() + "/comp/add", compEntity, CompEntity.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void deleteElementTest(){
        int id = 0;
        CompEntity compEntity = restTemplate.getForObject(url() + "/comp/delete/" + id, CompEntity.class);
        assertNotNull(compEntity);
        restTemplate.delete(url() + "/comp/delete/" + id);
        try {
            compEntity = restTemplate.getForObject(url() + "/comp/delete/" + id, CompEntity.class);
        } catch (final HttpClientErrorException exception){
            assertEquals(exception.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void updateElementTest(){
        int id = 0;
        CompEntity compEntity = new CompEntity();
        CompEntity comp = restTemplate.getForObject(url() + "/comp/update/" + id, CompEntity.class);
        comp.setName(compEntity.getName());
        comp.setHdd(compEntity.getHdd());
        comp.setRam(compEntity.getRam());
        comp.setCpu(compEntity.getCpu());
        restTemplate.put(url() + "/comp/update/" + id, comp);
        CompEntity update = restTemplate.getForObject(url() + "/comp/update/" + id, CompEntity.class);
        assertNotNull(update);
    }

    @Test
    public void getAllTest(){
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(url() + "/comp/getAll",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }
}
