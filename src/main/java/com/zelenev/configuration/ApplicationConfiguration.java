package com.zelenev.configuration;

import com.zelenev.bpp.InjectRandomCarDirectionAnnotationBeanPostProcessor;
import com.zelenev.bpp.InjectRandomIntAnnotationBeanPostProcessor;
import com.zelenev.model.data.states.CarDirection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Configuration
public class ApplicationConfiguration {

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
