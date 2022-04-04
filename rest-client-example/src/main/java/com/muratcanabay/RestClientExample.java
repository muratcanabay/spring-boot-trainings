package com.muratcanabay;

import com.muratcanabay.client.RestTemplateBean;
import com.muratcanabay.entity.Cat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestClientExample {

    private final static String URL = "https://catfact.ninja/fact";

    public static void main(String[] args) {
        SpringApplication.run(RestClientExample.class, args);

        RestTemplateBean bean = new RestTemplateBean();
        RestTemplate restTemplate = bean.getRestTemplate();

        Cat cat = restTemplate.getForEntity(URL, Cat.class).getBody();
        System.out.println(cat);
    }
}
