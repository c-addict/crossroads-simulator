package com.zelenev.configuration;

import com.zelenev.model.data.entities.Car;
import com.zelenev.model.data.entities.TrafficLight;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SimulationConfiguration {

    @Bean("car")
    @Scope("prototype")
    public Car car() {
        //TODO: complete car bean creation
        Car car = new Car(100, 250, 0, 0);
        return car;
    }

    @Bean("trafficLight")
    @Scope("prototype")
    public TrafficLight trafficLight() {
        //TODO: complete traffic light bean creation
        return null;
    }

}
