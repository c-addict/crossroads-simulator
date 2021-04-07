package com.zelenev.model.data.entities;

import com.zelenev.model.data.physics.TwoDimensionsPhysicalObject;
import com.zelenev.model.data.states.TrafficLightMode;
import com.zelenev.model.data.states.TrafficLightState;

public class TrafficLight extends TwoDimensionsPhysicalObject {

    private TrafficLightMode mode;

    private TrafficLightState forwardDirectionState;
    private TrafficLightState leftTurnState;
    private TrafficLightState rightTurnState;

}
