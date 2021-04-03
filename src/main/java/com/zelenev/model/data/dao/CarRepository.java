package com.zelenev.model.data.dao;

import com.zelenev.model.data.entities.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer> {

}
