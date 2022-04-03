package com.muratcanabay.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.muratcanabay.model.Credential;
import com.muratcanabay.model.Employee;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping
public class EmployeeController {

    /**
     * Statically filters salary field of the Employee
     *
     * @return {@link Employee}
     */
    @GetMapping("/static-filtering")
    public Employee getEmployees() {

        return Employee.builder()
                .id(UUID.randomUUID().toString())
                .name("Murat Can")
                .surname("Abay")
                .salary(1000.0)
                .build();
    }
}
