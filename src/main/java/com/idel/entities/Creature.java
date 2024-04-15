package com.idel.entities;

import com.idel.Coordinates;

abstract public class Creature extends Entity {
    private int speed = 1;
    private int hp = 10;

    public Creature(Coordinates coordinates) {
        super(coordinates);
    }

    protected void changeSpeed(int speed) {
        this.speed = speed;
    }

    public abstract void makeMove();
}
