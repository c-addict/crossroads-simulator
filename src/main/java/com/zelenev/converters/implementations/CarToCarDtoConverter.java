package com.zelenev.converters.implementations;

import com.zelenev.converters.BaseObjectConverter;
import com.zelenev.data.dto.CarDto;
import com.zelenev.data.entities.Car;
import org.springframework.stereotype.Component;

@Component
public class CarToCarDtoConverter extends BaseObjectConverter<Car, CarDto> {

    @Override
    public CarDto convert(Car obj) {
        return new CarDto(obj.getSpeed(), obj.getRoad().getId());
    }

    @Override
    public Class<Car> getInClass() {
        return Car.class;
    }

    @Override
    public Class<CarDto> getOutClass() {
        return CarDto.class;
    }
}
