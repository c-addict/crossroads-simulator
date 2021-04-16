package com.zelenev.repositories;

import com.zelenev.data.entities.Crossroad;
import org.springframework.data.repository.CrudRepository;

public interface TrafficLightRepository extends CrudRepository<Crossroad, Integer> {
}
