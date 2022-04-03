package com.muratcanabay.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@JsonFilter("credentialFilterBean")
public class Credential {

    private String id;
    private String username;
    private String password;
    private Date createdAt;
}
