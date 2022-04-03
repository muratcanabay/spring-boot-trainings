package com.muratcanabay.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class HelloWorldController {

    private final MessageSource messageSource;

    @GetMapping("/hello-world")
    public String sayHello(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("hello.world", null, "Default Message", locale);
    }

}
