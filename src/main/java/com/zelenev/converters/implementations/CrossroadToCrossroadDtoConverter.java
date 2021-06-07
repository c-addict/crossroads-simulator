package com.zelenev.converters.implementations;

import com.zelenev.converters.BaseObjectConverter;
import com.zelenev.data.dto.CrossroadDto;
import com.zelenev.data.entities.Crossroad;
import org.springframework.stereotype.Component;

@Component
public class CrossroadToCrossroadDtoConverter extends BaseObjectConverter<Crossroad, CrossroadDto> {

    @Override
    public CrossroadDto convert(Crossroad obj) {
        return new CrossroadDto(obj.getCity());
    }

    @Override
    public Class<Crossroad> getInClass() {
        return Crossroad.class;
    }

    @Override
    public Class<CrossroadDto> getOutClass() {
        return CrossroadDto.class;
    }
}
