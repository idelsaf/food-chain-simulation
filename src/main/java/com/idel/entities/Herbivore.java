package com.idel.entities;

import com.idel.Coordinates;
import com.idel.PathFinder;
import com.idel.WorldMap;

import java.util.List;

public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public boolean makeMove(WorldMap worldMap) {
        PathFinder pathFinder = new PathFinder(worldMap, this);
        List<Coordinates> path = pathFinder.findPath();
        if (path != null && !path.isEmpty()) {
            if (path.size() == 1) {
                Entity target = worldMap.getEntityByCoordinates(path.getFirst());
                eat(target, worldMap);
            } else {
                move(path.getLast(), worldMap);
            }
            return true;
        } else {
            return false;
        }
    }

    protected void eat(Entity target, WorldMap worldMap) {
        worldMap.removeEntity(target);
        replenishHealth();
        move(target.getCoordinates(), worldMap);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC2D";
    }
}
