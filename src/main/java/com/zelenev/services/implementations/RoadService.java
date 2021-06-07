package com.zelenev.services.implementations;

import com.zelenev.converters.implementations.RoadToRoadDtoConverter;
import com.zelenev.data.dto.RoadDto;
import com.zelenev.data.entities.Crossroad;
import com.zelenev.data.entities.Road;
import com.zelenev.exceptions.RoadDoesNotExistsException;
import com.zelenev.repositories.CrossroadRepository;
import com.zelenev.repositories.RoadRepository;
import com.zelenev.services.ICrudService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service("roadService")
public class RoadService implements ICrudService<RoadDto> {

    private final RoadRepository roadRepository;
    private final CrossroadRepository crossroadRepository;
    private final RoadToRoadDtoConverter roadConverter;

    public RoadService(RoadRepository roadRepository, CrossroadRepository crossroadRepository, RoadToRoadDtoConverter roadConverter) {
        this.roadRepository = roadRepository;
        this.crossroadRepository = crossroadRepository;
        this.roadConverter = roadConverter;

    }

    @Override
    public RoadDto read(Integer id) {
        Optional<Road> roadOptional = roadRepository.findById(id);
        if (roadOptional.isPresent()) {
            Road road = roadOptional.get();
            return new RoadDto(road.getCrossroad().getId());
        } else
            throw new RoadDoesNotExistsException("Road does not exists.");
    }

    @Override
    public List<RoadDto> readAll() {
        Iterable<Road> roadIterable = roadRepository.findAll();
        List<Road> roads = new LinkedList<>();
        roadIterable.forEach(roads::add);
        return roadConverter.convertList(roads);
    }

    @Override
    public void create(RoadDto roadDto) {
        Road road = new Road();
        Crossroad crossroad = crossroadRepository.findById(roadDto.getCrossroadId()).get();
        road.setCrossroad(crossroad);
        roadRepository.save(road);

    }

    @Override
    public void update(RoadDto roadDto, RoadDto newT) {

    }

    @Override
    public void delete(RoadDto roadDto) {

    }
}
