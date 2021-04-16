package com.zelenev.services;

import com.zelenev.data.dto.CarDto;
import com.zelenev.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carService")
public class CarService implements ICrudService<CarDto> {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CarDto read(Integer id) {
        return null;
    }

    @Override
    public List<CarDto> readAll() {
        return null;
    }

    @Override
    public void create(CarDto carDto) {

    }

    @Override
    public void update(CarDto carDto, CarDto newT) {

    }

    @Override
    public void delete(CarDto carDto) {

    }
}


