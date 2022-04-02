package com.muratcanabay.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    @NotNull(message = "Username field can not be empty!")
    @Size(min = 4, max = 20, message = "Username field must be 4-20 characters long!")
    private String username;

    @Column(name = "created_at")
    @Past(message = "Creation date cannot be later than current time!")
    private Date createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 7)
    private Status status;

    private enum Status {
        ACTIVE,
        PASSIVE
    }
}
