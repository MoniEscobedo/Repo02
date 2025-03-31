package com.example.greeting;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGreetingDefault() {
        ResponseEntity<Greeting> response = restTemplate.getForEntity("/greeting", Greeting.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().getContent()).isEqualTo("Hello, World!");
    }

    @Test
    public void testGreetingWithName() {
        ResponseEntity<Greeting> response = restTemplate.getForEntity("/greeting?name=User", Greeting.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().getContent()).isEqualTo("Hello, User!");
    }
}

