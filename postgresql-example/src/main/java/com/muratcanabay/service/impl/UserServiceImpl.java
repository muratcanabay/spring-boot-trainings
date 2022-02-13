package com.muratcanabay.service.impl;

import com.muratcanabay.dto.UserDto;
import com.muratcanabay.entity.Order;
import com.muratcanabay.entity.User;
import com.muratcanabay.entity.UserType;
import com.muratcanabay.repository.OrderRepository;
import com.muratcanabay.repository.UserRepository;
import com.muratcanabay.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Override
    public List<UserDto> findAll() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        userList.forEach(user -> {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setPassword(user.getPassword());
            userDto.setUserType(user.getUserType().name());
            userDto.setOrderList(
                    user.getOrders() != null ?
                            user.getOrders().stream().map(Order::getOrder).collect(Collectors.toList())
                            : null);
            userDtoList.add(userDto);
        });
        return userDtoList;
    }

    @Override
    @Transactional
    public UserDto saveUser(UserDto userDto) {

        User user = User.builder()
                .name(userDto.getName())
                .password(userDto.getPassword())
                .userType(UserType.valueOf(userDto.getUserType()))
                .build();

        User savedUser = userRepository.save(user);
        userDto.setId(savedUser.getId());

        ArrayList<Order> orders = new ArrayList<>();
        userDto.getOrderList().forEach(item -> {
            Order savedOrder = Order.builder()
                    .createdAt(new Date())
                    .order(item)
                    .user(savedUser)
                    .build();
            orders.add(savedOrder);
        });
        orderRepository.saveAll(orders);
        return userDto;
    }
}
