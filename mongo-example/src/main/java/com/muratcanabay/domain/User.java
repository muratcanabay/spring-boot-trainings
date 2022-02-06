package com.muratcanabay.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@Builder
public class User {

    @Id
    private String id;

    private String name;

    private Date birthDate;

    @CreatedDate
    private Date createdAt;
}
