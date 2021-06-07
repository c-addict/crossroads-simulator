package com.zelenev.controllers.implementations;

import com.zelenev.controllers.ICrudController;
import com.zelenev.data.dto.TrafficLightDto;
import com.zelenev.services.implementations.TrafficLightService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        path = "/traffic-light"
)
@CrossOrigin("*")
public class TrafficLightController implements ICrudController<TrafficLightDto> {

    @Qualifier("trafficLightService")
    private final TrafficLightService trafficLightService;

    public TrafficLightController(TrafficLightService trafficLightService) {
        this.trafficLightService = trafficLightService;
    }

    @Override
    @GetMapping(
            path = "/{id}"
    )
    public TrafficLightDto read(@PathVariable Integer id) {
        return trafficLightService.read(id);
    }

    @Override
    @GetMapping(
            path = "/all"
    )
    public List<TrafficLightDto> readAll() {
        return trafficLightService.readAll();
    }

    @Override
    @PostMapping
    public void create(@RequestBody TrafficLightDto trafficLightDto) {
        trafficLightService.create(trafficLightDto);
    }

    @Override
    @PutMapping
    public void update(@RequestBody TrafficLightDto trafficLightDto, @RequestBody TrafficLightDto newT) {
        trafficLightService.update(trafficLightDto, newT);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody TrafficLightDto trafficLightDto) {
        trafficLightService.delete(trafficLightDto);
    }
}
