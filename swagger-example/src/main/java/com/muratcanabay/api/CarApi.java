package com.muratcanabay.api;

import com.muratcanabay.entity.Car;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/api/v1/car")
@Api(value = "Car Api Documentation")
public class CarApi {

    private final List<Car> carList = new ArrayList<>();

    @GetMapping
    @ApiOperation(value = "List all cars")
    public List<Car> getAllCars() {
        return carList;
    }

    @PostMapping
    @ApiOperation(value = "Save a car")
    public Car saveCar(@RequestBody @ApiParam(value = "Car to save") Car car) {
        carList.add(car);
        return car;
    }

}
