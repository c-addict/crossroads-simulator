package com.zelenev.data.dto;

public class CarDto {

    private int speed;

    private int roadId;

    public CarDto() {
    }

    public CarDto(int speed, int roadId) {
        this.speed = speed;
        this.roadId = roadId;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getRoadId() {
        return roadId;
    }

    public void setRoadId(int roadId) {
        this.roadId = roadId;
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "speed=" + speed +
                ", roadId=" + roadId +
                '}';
    }
}