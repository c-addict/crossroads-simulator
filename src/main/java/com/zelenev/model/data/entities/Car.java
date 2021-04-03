package com.zelenev.model.data.entities;

import com.zelenev.annotations.InjectRandomCarDirection;
import com.zelenev.annotations.InjectRandomInt;
import com.zelenev.model.data.physics.TwoDimensionsPhysicalObject;
import com.zelenev.model.data.physics.size.TwoDimensionsSize;
import com.zelenev.model.data.physics.move.IMovableObject;
import com.zelenev.model.data.physics.position.Point;
import com.zelenev.model.data.physics.position.TwoDimensionsPoint;
import com.zelenev.model.data.states.CarDirection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity(
        name = "Car"
)
@Table(
        name = "car",
        schema = "public"
)
@NoArgsConstructor
public class Car extends TwoDimensionsPhysicalObject implements IMovableObject, Runnable {

    @Id
    @SequenceGenerator(
            name = "car_sequence",
            sequenceName = "car_sequence",
            schema = "public",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "car_sequence"
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
    @Getter
    @Setter
    @Column(
            name = "speed"
    )
    private Integer speed;

    @InjectRandomCarDirection
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(
            name = "direction",
            columnDefinition = "VARCHAR",
            length = 7
    )
    private CarDirection direction;

    public Car(int width, int height, int startX, int startY) {
        this.size = new TwoDimensionsSize(width, height);
        this.position = new TwoDimensionsPoint(startX, startY);
    }

    @Override
    public void run() {

    }

    @Override
    public void move(Point newPosition) {
        //TODO: car movement
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(speed, car.speed) && direction == car.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, speed, direction);
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", speed=" + speed +
                ", direction=" + direction +
                ", position=" + position +
                ", size=" + size +
                '}';
    }
}
