package com.muratcanabay.repository;

import com.muratcanabay.domain.Car;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CarRepository extends ElasticsearchRepository<Car, String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"brand\": \"?0\"}}]}}")
    List<Car> findCarByBrand(String brand);

}
