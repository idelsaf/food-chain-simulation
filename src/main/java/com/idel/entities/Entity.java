package com.idel.entities;

import com.idel.Coordinates;

abstract public class Entity {
    private Coordinates coordinates;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
