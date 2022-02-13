package com.muratcanabay.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Year;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
@ApiModel(value = "Car Model", description = "Car Features", parent = SuperClass.class)
public class Car extends SuperClass {

    private String brand;

    private String model;

    @ApiModelProperty(value = "Year That Car Produced")
    private Year year;

}
