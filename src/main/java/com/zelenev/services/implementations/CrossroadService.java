package com.zelenev.services.implementations;

import com.zelenev.data.dto.CrossroadDto;
import com.zelenev.services.ICrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("crossroadService")
public class CrossroadService implements ICrudService<CrossroadDto> {

    @Override
    public CrossroadDto read(Integer id) {
        return null;
    }

    @Override
    public List<CrossroadDto> readAll() {
        return null;
    }

    @Override
    public void create(CrossroadDto crossroadDto) {

    }

    @Override
    public void update(CrossroadDto crossroadDto, CrossroadDto newT) {

    }

    @Override
    public void delete(CrossroadDto crossroadDto) {

    }
}
