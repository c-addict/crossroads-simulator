package com.zelenev.data.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "traffic_light")
@Table(
        name = "traffic_light",
        schema = "public"
)
public class TrafficLight {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(
            name = "crossroad_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "traffic_light_crossroad_id"
            )
    )
    private Crossroad crossroad;

    public TrafficLight() {
    }

    public TrafficLight(Crossroad crossroad) {
        this.crossroad = crossroad;
    }

    public TrafficLight(Integer id, Crossroad crossroad) {
        this.id = id;
        this.crossroad = crossroad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Crossroad getCrossroad() {
        return crossroad;
    }

    public void setCrossroad(Crossroad crossroad) {
        this.crossroad = crossroad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrafficLight that = (TrafficLight) o;
        return Objects.equals(id, that.id) && Objects.equals(crossroad, that.crossroad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, crossroad);
    }

    @Override
    public String toString() {
        return "TrafficLight{" +
                "id=" + id +
                ", crossroad=" + crossroad +
                '}';
    }
}
