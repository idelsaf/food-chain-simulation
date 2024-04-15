package com.idel.entities;

import com.idel.Coordinates;
import com.idel.entities.Entity;

public class Dirt extends Entity {
    public Dirt(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String toString() {
        return "\uD83D\uDFEB";
    }
}
