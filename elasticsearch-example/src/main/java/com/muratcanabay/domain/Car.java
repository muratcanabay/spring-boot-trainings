package com.muratcanabay.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "users")
@Data
@Builder
public class Car {

    @Id
    private String id;

    @Field(name = "brand", type = FieldType.Text)
    private String brand;

    @Field(name = "gear", type = FieldType.Keyword)
    private Gear gear;

    @CreatedDate
    @Field(name = "createdAt", type = FieldType.Date)
    private Date createdAt;

}
