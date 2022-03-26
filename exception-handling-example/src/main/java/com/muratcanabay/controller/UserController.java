package com.muratcanabay.controller;

import com.muratcanabay.entity.User;
import com.muratcanabay.exception.UserNotFoundException;
import com.muratcanabay.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;


@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {

        User foundUser = userRepository.findById(id).orElseThrow(() -> {
            throw new UserNotFoundException("User not found.");
        });
        return ResponseEntity.ok(foundUser);
    }

    @PostMapping("/user")
    public ResponseEntity<User> save(@RequestBody User user) {

        if (user.getCreatedAt() == null) user.setCreatedAt(new Date());

        User savedUser = userRepository.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable Long id) {

        User foundUser = userRepository.findById(id).orElseThrow(() -> {
            throw new UserNotFoundException("No user found to delete.");
        });
        userRepository.deleteById(foundUser.getId());
    }
}
