package com.idel.entities;

import com.idel.Coordinates;

public class Predator extends Creature {
    private int damage = 2;

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
