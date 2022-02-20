package com.muratcanabay.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class Message implements Serializable {

    private Long id;
    private String topic;
    private String message;
    private Date createdAt;
}
