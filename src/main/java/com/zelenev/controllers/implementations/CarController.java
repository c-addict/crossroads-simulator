package com.zelenev.controllers.implementations;

import com.zelenev.controllers.ICrudController;
import com.zelenev.data.dto.CarDto;
import com.zelenev.services.ICrudService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        path = "/car"
)
@CrossOrigin("*")
public class CarController implements ICrudController<CarDto> {

    @Qualifier("carService")
    private final ICrudService<CarDto> carService;

    public CarController(ICrudService<CarDto> carService) {
        this.carService = carService;
    }

    @Override
    @GetMapping(
            path = "/{id}"
    )
    public CarDto read(@PathVariable Integer id) {
        return carService.read(id);
    }

    @Override
    @GetMapping(
            path = "/all"
    )
    public List<CarDto> readAll() {
        return carService.readAll();
    }

    @Override
    @PostMapping
    public void create(@RequestBody CarDto carDto) {
        carService.create(carDto);
    }

    @Override
    @PutMapping
    public void update(@RequestBody CarDto carDto, @RequestBody CarDto newT) {
        carService.update(carDto, newT);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody CarDto carDto) {
        carService.delete(carDto);
    }
}
