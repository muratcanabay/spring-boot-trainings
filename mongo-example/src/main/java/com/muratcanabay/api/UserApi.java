package com.muratcanabay.api;

import com.muratcanabay.domain.User;
import com.muratcanabay.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserApi {

    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = User.builder()
                .name(user.getName())
                .birthDate(user.getBirthDate())
                .createdAt(new Date())
                .build();
        return ResponseEntity.ok(userRepository.save(savedUser));
    }
}
