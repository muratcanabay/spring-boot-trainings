package com.muratcanabay.service;

import com.muratcanabay.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto saveUser(UserDto userDto);
}
