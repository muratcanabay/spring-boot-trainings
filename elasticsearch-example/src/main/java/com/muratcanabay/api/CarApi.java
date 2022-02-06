package com.muratcanabay.api;

import com.muratcanabay.domain.Car;
import com.muratcanabay.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
@AllArgsConstructor
public class CarApi {

    private final CarRepository carRepository;

    @GetMapping("/{searchText}")
    public ResponseEntity<List<Car>> findCarByBrand(@PathVariable String searchText) {
        return ResponseEntity.ok(carRepository.findCarByBrand(searchText));
    }

    @PostMapping
    public ResponseEntity<Car> saveCar(@RequestBody Car car) {
        Car savedCar = Car.builder()
                .brand(car.getBrand())
                .gear(car.getGear())
                .createdAt(new Date())
                .build();
        return ResponseEntity.ok(carRepository.save(savedCar));
    }

}
