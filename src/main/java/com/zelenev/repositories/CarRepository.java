package com.zelenev.repositories;

import com.zelenev.data.entities.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CarRepository extends CrudRepository<Car, Integer> {

    public Optional<Car> getById(Integer id);
}
