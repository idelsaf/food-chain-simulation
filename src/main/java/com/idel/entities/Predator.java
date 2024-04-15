package com.idel.entities;

import com.idel.Coordinates;
import com.idel.entities.Creature;

public class Predator extends Creature {
    public Predator(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public void makeMove() {

    }

    @Override
    public String toString() {
        return "\uD83D\uDC2F";
    }
}
