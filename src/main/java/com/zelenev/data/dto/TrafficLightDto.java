package com.zelenev.data.dto;

public class TrafficLightDto {

    private int crossroadId;

    public TrafficLightDto() {
    }

    public TrafficLightDto(int crossroadId) {
        this.crossroadId = crossroadId;
    }

    public int getCrossroadId() {
        return crossroadId;
    }

    public void setCrossroadId(int crossroadId) {
        this.crossroadId = crossroadId;
    }

    @Override
    public String toString() {
        return "TrafficLightDto{" +
                "crossroadId=" + crossroadId +
                '}';
    }
}
