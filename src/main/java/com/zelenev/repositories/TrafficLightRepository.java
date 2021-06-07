package com.zelenev.repositories;

import com.zelenev.data.entities.TrafficLight;
import org.springframework.data.repository.CrudRepository;

public interface TrafficLightRepository extends CrudRepository<TrafficLight, Integer> {
}
