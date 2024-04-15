package com.idel.entities;

import com.idel.Coordinates;
import com.idel.entities.Entity;

public class Rock extends Entity {
    public Rock(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String toString() {
        return "\uD83E\uDEA8";
    }
}
