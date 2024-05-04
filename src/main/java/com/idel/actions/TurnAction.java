package com.idel.actions;

import com.idel.Coordinates;
import com.idel.WorldMap;
import com.idel.entities.Creature;
import com.idel.entities.Entity;

import java.util.ArrayList;

public class TurnAction {
    public boolean makeCreaturesMoves(WorldMap worldMap) {
        int height = worldMap.getHeight();
        int width = worldMap.getWidth();
        int movesCounter = 0;
        ArrayList<Creature> creatures = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Entity entity = worldMap.getEntityByCoordinates(new Coordinates(j, i));
                if (entity instanceof Creature creature) {
                    creatures.add(creature);
                }
            }
        }

        StringBuilder movesStat = new StringBuilder("=== Moves ===\n");
        for (Creature creature : creatures) {
            if (!creature.isDead()) {
                Coordinates oldCoordinates = creature.getCoordinates();
                if (creature.makeMove(worldMap)) {
                    Coordinates newCoordinates = creature.getCoordinates();
                    movesStat.append(creature + " " + oldCoordinates + " -> " + newCoordinates + "\n");

                    movesCounter++;
                }
            }
        }

        if (movesCounter > 0) {
            movesStat.append("=============");
            System.out.println(movesStat);
            return true;
        }

        return false;
    }
}
