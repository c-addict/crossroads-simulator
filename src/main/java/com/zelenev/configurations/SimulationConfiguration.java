package com.zelenev.configuration;

import com.zelenev.bpp.InjectRandomCarDirectionAnnotationBeanPostProcessor;
import com.zelenev.bpp.InjectRandomIntAnnotationBeanPostProcessor;
import com.zelenev.data.entities.Car;
import com.zelenev.data.entities.TrafficLight;
import com.zelenev.data.states.CarDirection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public List<CarDirection> directions() {
        return Arrays.asList(
                CarDirection.FORWARD,
                CarDirection.LEFT,
                CarDirection.RIGHT
        );
    }

    @Bean
    public InjectRandomIntAnnotationBeanPostProcessor injectRandomIntAnnotationBeanPostProcessor() {
        return new InjectRandomIntAnnotationBeanPostProcessor();
    }

    @Bean
    public InjectRandomCarDirectionAnnotationBeanPostProcessor injectRandomDirectionAnnotationBeanPostProcessor() {
        return new InjectRandomCarDirectionAnnotationBeanPostProcessor();
    }

}
