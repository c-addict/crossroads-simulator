package com.zelenev.data.dto;

public class RoadDto {

    private int crossroadId;

    public RoadDto() {
    }

    public RoadDto(int crossroadId) {
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
        return "RoadDto{" +
                "crossroadId=" + crossroadId +
                '}';
    }
}
