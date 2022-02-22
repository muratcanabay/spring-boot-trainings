package com.muratcanabay.api;

import com.muratcanabay.service.WelcomeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/welcome")
public class WelcomeApi {

    private final WelcomeService welcomeService;

    public WelcomeApi(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }

    @PostMapping("/{name}")
    public ResponseEntity<String> welcome(@PathVariable String name) {
        return ResponseEntity.ok(welcomeService.welcome(name));
    }

    @GetMapping("/error")
    public HttpStatus welcome() {
        try {
            welcomeService.errorTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HttpStatus.BAD_REQUEST;
    }
}
