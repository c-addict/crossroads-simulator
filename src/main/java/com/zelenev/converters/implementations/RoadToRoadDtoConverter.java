package com.zelenev.converters.implementations;

import com.zelenev.converters.BaseObjectConverter;
import com.zelenev.data.dto.RoadDto;
import com.zelenev.data.entities.Road;
import org.springframework.stereotype.Component;

@Component
public class RoadToRoadDtoConverter extends BaseObjectConverter<Road, RoadDto> {

    @Override
    public RoadDto convert(Road obj) {
        return new RoadDto(obj.getCrossroad().getId());
    }

    @Override
    public Class<Road> getInClass() {
        return Road.class;
    }

    @Override
    public Class<RoadDto> getOutClass() {
        return RoadDto.class;
    }
}
