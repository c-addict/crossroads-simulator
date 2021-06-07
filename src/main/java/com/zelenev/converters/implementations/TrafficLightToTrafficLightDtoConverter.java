package com.zelenev.converters.implementations;

import com.zelenev.converters.BaseObjectConverter;
import com.zelenev.data.dto.TrafficLightDto;
import com.zelenev.data.entities.TrafficLight;
import org.springframework.stereotype.Component;

@Component
public class TrafficLightToTrafficLightDtoConverter extends BaseObjectConverter<TrafficLight, TrafficLightDto> {

    @Override
    public TrafficLightDto convert(TrafficLight obj) {
        return new TrafficLightDto(obj.getCrossroad().getId());
    }

    @Override
    public Class<TrafficLight> getInClass() {
        return null;
    }

    @Override
    public Class<TrafficLightDto> getOutClass() {
        return null;
    }
}
