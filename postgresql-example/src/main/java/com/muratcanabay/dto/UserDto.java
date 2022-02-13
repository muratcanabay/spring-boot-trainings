package com.muratcanabay.dto;

import com.sun.istack.NotNull;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class UserDto {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String password;

    private String userType;

    private List<String> orderList;
}
