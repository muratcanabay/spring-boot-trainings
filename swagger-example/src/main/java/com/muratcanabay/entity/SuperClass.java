package com.muratcanabay.entity;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@SuperBuilder
@NoArgsConstructor
public abstract class SuperClass implements Serializable {

    private Long id;
}
