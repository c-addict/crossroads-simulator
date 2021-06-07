package com.zelenev.data.entities;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity(name = "crossroad")
@Table(
        name = "crossroad",
        schema = "public"
)
public class Crossroad {

    @Id

    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    private Integer id;

    @Column(
            name = "city",
            length = 200,
            nullable = false
    )
    private String city;

    @OneToMany(
            mappedBy = "crossroad",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private List<Road> roads = new LinkedList<>();

    @OneToMany(
            mappedBy = "crossroad",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private List<TrafficLight> trafficLights = new LinkedList<>();

    public Crossroad() {
    }

    public Crossroad(String city) {
        this.city = city;
    }

    public Crossroad(Integer id, String city) {
        this.id = id;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Road> getRoads() {
        return roads;
    }

    public void setRoads(List<Road> roads) {
        this.roads = roads;
    }

    public List<TrafficLight> getTrafficLights() {
        return trafficLights;
    }

    public void setTrafficLights(List<TrafficLight> trafficLights) {
        this.trafficLights = trafficLights;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void addRoad(Road road) {
        if (!this.roads.contains(road)) {
            this.roads.add(road);
            road.setCrossroad(this);
        }
    }

    public void removeRoad(Road road) {
        if (this.roads.contains(road)) {
            this.roads.remove(road);
            road.setCrossroad(null);
        }
    }

    public void addTrafficLight(TrafficLight trafficLight) {
        if (!this.trafficLights.contains(trafficLight)) {
            this.trafficLights.add(trafficLight);
            trafficLight.setCrossroad(this);
        }
    }

    public void removeTrafficLight(TrafficLight trafficLight) {
        if (this.trafficLights.contains(trafficLight)) {
            this.trafficLights.remove(trafficLight);
            trafficLight.setCrossroad(null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crossroad crossroad = (Crossroad) o;
        return Objects.equals(id, crossroad.id) && Objects.equals(roads, crossroad.roads) && Objects.equals(trafficLights, crossroad.trafficLights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roads, trafficLights);
    }

    @Override
    public String toString() {
        return "Crossroad{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", roads=" + roads +
                ", trafficLights=" + trafficLights +
                '}';
    }
}
