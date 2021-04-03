package com.zelenev.model.data.simulation;

import com.zelenev.model.data.entities.Car;
import org.springframework.context.ApplicationContext;

public class Simulator {

    private final ApplicationContext context;

    public Simulator(ApplicationContext context) {
        this.context = context;
    }

    public void simulate() {
        //TODO: simulation
        for (int i = 0; i < 10; i++) {
            System.out.println(context.getBean("car"));
        }
    }
}
