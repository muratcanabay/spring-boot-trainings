package com.muratcanabay.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.muratcanabay.model.Credential;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping
public class CredentialsController {

    /**
     * Dynamically filters all fields except username
     *
     * @return {@link Credential}
     */
    @GetMapping("/dynamic-filtering")
    public MappingJacksonValue getCredentials() {

        Credential credential = Credential.builder()
                .id(UUID.randomUUID().toString())
                .username("test@example.com")
                .password("password")
                .createdAt(new Date())
                .build();

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("username");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("credentialFilterBean", filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(credential);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }

}
