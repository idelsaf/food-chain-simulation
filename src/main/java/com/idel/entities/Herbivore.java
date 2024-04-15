package com.idel.entities;

import com.idel.Coordinates;

public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public void makeMove() {
    }

    @Override
    public String toString() {
        return "\uD83D\uDC30";
    }
}
