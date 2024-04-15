package com.idel.entities;

import com.idel.Coordinates;

public class Grass extends Entity {
    public Grass(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String toString() {
        return "\uD83C\uDF3F";
    }
}
