package com.zelenev.services.implementations;

import com.zelenev.converters.implementations.CrossroadToCrossroadDtoConverter;
import com.zelenev.data.dto.CrossroadDto;
import com.zelenev.data.entities.Crossroad;
import com.zelenev.exceptions.CrossroadDoesNotExistsException;
import com.zelenev.repositories.CrossroadRepository;
import com.zelenev.services.ICrudService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service("crossroadService")
public class CrossroadService implements ICrudService<CrossroadDto> {

    private final CrossroadRepository crossroadRepository;
    private final CrossroadToCrossroadDtoConverter crossroadConverter;

    public CrossroadService(CrossroadRepository crossroadRepository, CrossroadToCrossroadDtoConverter crossroadConverter) {
        this.crossroadRepository = crossroadRepository;
        this.crossroadConverter = crossroadConverter;
    }

    @Override
    public CrossroadDto read(Integer id) {
        Optional<Crossroad> crossroadOptional = crossroadRepository.findById(id);
        if (crossroadOptional.isPresent()) {
            Crossroad crossroad = crossroadOptional.get();
            return new CrossroadDto(crossroad.getCity());
        } else
            throw new CrossroadDoesNotExistsException("Crossroad does not exists.");
    }

    @Override
    public List<CrossroadDto> readAll() {
        Iterable<Crossroad> crossroadIterable = crossroadRepository.findAll();
        List<Crossroad> crossroads = new LinkedList<>();
        crossroadIterable.forEach(crossroads::add);
        return crossroadConverter.convertList(crossroads);
    }

    @Override
    public void create(CrossroadDto crossroadDto) {
        Crossroad crossroad = new Crossroad(crossroadDto.getCity());
        crossroadRepository.save(crossroad);
    }

    @Override
    public void update(CrossroadDto crossroadDto, CrossroadDto newT) {

    }

    @Override
    public void delete(CrossroadDto crossroadDto) {

    }
}
