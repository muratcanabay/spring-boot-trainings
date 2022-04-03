package com.muratcanabay.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Employee {

    private String id;

    private String name;

    private String surname;

    @JsonIgnore
    private Double salary;
}
