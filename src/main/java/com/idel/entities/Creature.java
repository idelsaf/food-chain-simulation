package com.idel.entities;

import com.idel.Coordinates;
import com.idel.PathFinder;
import com.idel.WorldMap;

import java.util.List;

abstract public class Creature extends Entity {
    private final int speed;
    private int healthPoints;
    private final Class<? extends Entity> victim;

    public Creature(Coordinates coordinates) {
        super(coordinates);
        speed = 1;
        healthPoints = 5;
        victim = this.getClass() == Predator.class ? Herbivore.class : Grass.class;
    }

    public Class<? extends Entity> getVictim() {
        return victim;
    }

    public abstract boolean makeMove(WorldMap worldMap);

    protected void move(Coordinates newCoordinates, WorldMap worldMap) {
        if (worldMap.isValidMove(newCoordinates)) {
            worldMap.moveEntity(this, newCoordinates);
            this.setCoordinates(newCoordinates);
        }
    }

    protected void takeDamage(int damage, WorldMap worldMap) {
        healthPoints -= damage;
        if (isDead()) {
            worldMap.removeEntity(this);
        }
    }

    public boolean isDead() {
        return healthPoints <= 0;
    }

    protected void replenishHealth() {
        healthPoints++;
    }
}
