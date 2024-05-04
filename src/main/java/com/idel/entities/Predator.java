package com.idel.entities;

import com.idel.Coordinates;
import com.idel.PathFinder;
import com.idel.WorldMap;

import java.util.List;

public class Predator extends Creature {
    private final int damage = 6;

    public Predator(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public boolean makeMove(WorldMap worldMap) {
        PathFinder pathFinder = new PathFinder(worldMap, this);
        List<Coordinates> path = pathFinder.findPath();
        if (path != null && !path.isEmpty()) {
            if (path.size() == 1) {
                Creature target = (Creature) worldMap.getEntityByCoordinates(path.getFirst());
                attack(target, worldMap);
            } else {
                move(path.getLast(), worldMap);
            }

            return true;
        } else {
            // stay in the same place or make random move (?)
            return false;
        }
    }

    protected void attack(Creature target, WorldMap worldMap) {
        target.takeDamage(this.damage, worldMap);
        replenishHealth();
        if (target.isDead()) {
            move(target.getCoordinates(), worldMap);
        }
    }

    @Override
    public String toString() {
        return "\uD83D\uDC2F";
    }
}
