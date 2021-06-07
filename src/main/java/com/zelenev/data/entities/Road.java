package com.zelenev.data.entities;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity(name = "road")
@Table(
        name = "road",
        schema = "public"
)
public class Road {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    private Integer id;

    @OneToMany(
            mappedBy = "road",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private List<Car> cars = new LinkedList<>();

    @ManyToOne
    @JoinColumn(
            name = "crossroad_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "road_crossroad_id_fk"
            )
    )
    private Crossroad crossroad;

    public Road() {
    }

    public Road(List<Car> cars, Crossroad crossroad) {
        this.cars = cars;
        this.crossroad = crossroad;
    }

    public Road(Integer id, List<Car> cars, Crossroad crossroad) {
        this.id = id;
        this.cars = cars;
        this.crossroad = crossroad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Crossroad getCrossroad() {
        return crossroad;
    }

    public void setCrossroad(Crossroad crossroad) {
        this.crossroad = crossroad;
    }

    public void addCar(Car car) {
        if (!cars.contains(car)) {
            this.cars.add(car);
            car.setRoad(this);
        }
    }

    public void removeCar(Car car) {
        if (this.cars.contains(car)) {
            this.cars.remove(car);
            car.setRoad(null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return Objects.equals(id, road.id) && Objects.equals(cars, road.cars) && Objects.equals(crossroad, road.crossroad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cars, crossroad);
    }

    @Override
    public String toString() {
        return "Road{" +
                "id=" + id +
                ", cars=" + cars +
                ", crossroad=" + crossroad +
                '}';
    }
}
