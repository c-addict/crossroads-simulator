package com.zelenev.services.implementations;

import com.zelenev.converters.implementations.CarToCarDtoConverter;
import com.zelenev.data.dto.CarDto;
import com.zelenev.data.entities.Car;
import com.zelenev.data.entities.Road;
import com.zelenev.exceptions.CarDoesNotExistsException;
import com.zelenev.repositories.CarRepository;
import com.zelenev.repositories.RoadRepository;
import com.zelenev.services.ICrudService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service("carService")
public class CarService implements ICrudService<CarDto> {

    private final CarRepository carRepository;
    private final RoadRepository roadRepository;
    private final CarToCarDtoConverter carConverter;

    public CarService(CarRepository carRepository, RoadRepository roadRepository, CarToCarDtoConverter carConverter) {
        this.carRepository = carRepository;
        this.roadRepository = roadRepository;
        this.carConverter = carConverter;
    }

    @Override
    public CarDto read(Integer id) {
        Optional<Car> carOptional = carRepository.getById(id);

        if (carOptional.isPresent()) {
            Car car = carOptional.get();
            return carConverter.convert(car);
        } else
            throw new CarDoesNotExistsException("Car does not exists.");
    }

    @Override
    public List<CarDto> readAll() {
        Iterable<Car> carsIterable = carRepository.findAll();
        List<Car> cars = new LinkedList<>();
        carsIterable.forEach(cars::add);
        return carConverter.convertList(cars);
    }

    @Override
    public void create(CarDto carDto) {
        Car car = new Car();
        car.setSpeed(carDto.getSpeed());
        Road road = roadRepository.findById(carDto.getRoadId()).get();
        car.setRoad(road);
        carRepository.save(car);
    }

    @Override
    public void update(CarDto carDto, CarDto newT) {

    }

    @Override
    public void delete(CarDto carDto) {

    }
}


