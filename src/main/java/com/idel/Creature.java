package com.idel;

abstract public class Creature extends Entity {
    int speed = 1;
    int hp = 10;

    public Creature(Coordinates coordinates) {
        super(coordinates);
    }

    public abstract void makeMove();
}
