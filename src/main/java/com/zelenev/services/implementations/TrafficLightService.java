package com.zelenev.services.implementations;

import com.zelenev.converters.implementations.TrafficLightToTrafficLightDtoConverter;
import com.zelenev.data.dto.TrafficLightDto;
import com.zelenev.data.entities.Crossroad;
import com.zelenev.data.entities.TrafficLight;
import com.zelenev.exceptions.TrafficLightDoesNotExistsException;
import com.zelenev.repositories.CrossroadRepository;
import com.zelenev.repositories.TrafficLightRepository;
import com.zelenev.services.ICrudService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service("trafficLightService")
public class TrafficLightService implements ICrudService<TrafficLightDto> {

    private final TrafficLightRepository trafficLightRepository;
    private final CrossroadRepository crossroadRepository;
    private final TrafficLightToTrafficLightDtoConverter trafficLightConverter;

    public TrafficLightService(TrafficLightRepository trafficLightRepository, CrossroadRepository crossroadRepository, TrafficLightToTrafficLightDtoConverter trafficLightConverter) {
        this.trafficLightRepository = trafficLightRepository;
        this.crossroadRepository = crossroadRepository;
        this.trafficLightConverter = trafficLightConverter;
    }

    @Override
    public TrafficLightDto read(Integer id) {
        Optional<TrafficLight> trafficLightOptional = trafficLightRepository.findById(id);
        if (trafficLightOptional.isPresent()) {
            return trafficLightConverter.convert(trafficLightOptional.get());
        } else
            throw new TrafficLightDoesNotExistsException("Traffic light does not exists.");
    }

    @Override
    public List<TrafficLightDto> readAll() {
        Iterable<TrafficLight> trafficLightIterable = trafficLightRepository.findAll();
        List<TrafficLight> trafficLights = new LinkedList<>();
        trafficLightIterable.forEach(trafficLights::add);
        return trafficLightConverter.convertList(trafficLights);
    }

    @Override
    public void create(TrafficLightDto trafficLightDto) {
        TrafficLight trafficLight = new TrafficLight();
        Crossroad crossroad = crossroadRepository.findById(trafficLightDto.getCrossroadId()).get();
        trafficLight.setCrossroad(crossroad);
        trafficLightRepository.save(trafficLight);
    }

    @Override
    public void update(TrafficLightDto trafficLightDto, TrafficLightDto newT) {

    }

    @Override
    public void delete(TrafficLightDto trafficLightDto) {

    }
}
