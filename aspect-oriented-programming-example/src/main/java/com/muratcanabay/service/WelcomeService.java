package com.muratcanabay.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

    public String welcome(String name) {
        return name;
    }

    public void errorTest() {
        throw new IllegalArgumentException();
    }
}
