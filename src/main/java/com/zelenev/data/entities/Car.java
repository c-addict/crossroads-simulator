package com.zelenev.data.entities;

import com.zelenev.annotations.InjectRandomInt;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "car")
@Table()
public class Car implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Integer id;

    @InjectRandomInt(
            minValue = 30,
            maxValue = 120
    )
    @Column(

            name = "speed"
    )
    private int speed;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    @JoinColumn(
            name = "road_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "car_road_id_fk"
            )
    )
    private Road road;


    public Car() {
    }

    public Car(int speed, Road road) {
        this.speed = speed;
        this.road = road;
    }

    public Car(Integer id, int speed, Road road) {
        this.id = id;
        this.speed = speed;
        this.road = road;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Road getRoad() {
        return road;
    }

    public void setRoad(Road road) {
        this.road = road;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return speed == car.speed && Objects.equals(id, car.id) && Objects.equals(road, car.road);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, speed, road);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", speed=" + speed +
                ", road=" + road +
                '}';
    }
}
