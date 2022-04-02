package com.muratcanabay.controller;

import com.muratcanabay.entity.User;
import com.muratcanabay.exception.UserNotFoundException;
import com.muratcanabay.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {

        User foundUser = userRepository.findById(id).orElseThrow(() -> {
            throw new UserNotFoundException("User not found.");
        });
        return ResponseEntity.ok(foundUser);
    }

    @GetMapping("/users-hateoas/{id}")
    public EntityModel<User> _findById(@PathVariable Long id) {

        User foundUser = userRepository.findById(id).orElseThrow(() -> {
            throw new UserNotFoundException("User not found.");
        });

        EntityModel<User> userEntityModel = EntityModel.of(foundUser);
        Link link = linkTo(methodOn(this.getClass()).findAll()).withRel("find_All").withType("GET");
        userEntityModel.add(link);
        return userEntityModel;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll() {

        List<User> userList = userRepository.findAll();
        return ResponseEntity.ok(userList);
    }

    @PostMapping("/users")
    public ResponseEntity<User> save(@Valid @RequestBody User user) {

        if (user.getCreatedAt() == null) user.setCreatedAt(new Date());

        User savedUser = userRepository.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Long id) {

        User foundUser = userRepository.findById(id).orElseThrow(() -> {
            throw new UserNotFoundException("No user found to delete.");
        });
        userRepository.deleteById(foundUser.getId());
    }
}
