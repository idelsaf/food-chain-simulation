package com.idel.actions;

import com.idel.*;
import com.idel.entities.*;

import java.util.Random;

public class InitAction {
    private WorldMap worldMap;
    private final int width;
    private final int height;

    public InitAction(WorldMap worldMap) {
        this.worldMap = worldMap;
        this.width = worldMap.getWidth();
        this.height = worldMap.getHeight();

        setCreatures();
        setStaticEntities();
        setDirtInEmpty();
    }

    private void setCreatures() {
        Random random = new Random();
        int numberOfCreatures = (int) (width * height * 0.2);
        int x, y;
        for (int i = 0; i < numberOfCreatures; i++) {
            Coordinates coordinates;
            do {
                x = random.nextInt(width);
                y = random.nextInt(height);
                coordinates = new Coordinates(x, y);
            } while (!worldMap.isCoordinateEmpty(coordinates));

            int typeOfStaticEntity = random.nextInt(2);
            switch (typeOfStaticEntity) {
                case 0:
                    worldMap.setEntity(new Herbivore(coordinates), coordinates);
                    break;
                case 1:
                    worldMap.setEntity(new Predator(coordinates), coordinates);
                    break;
            }
        }
    }

    private void setStaticEntities() {
        Random random = new Random();
        int numberOfStatics = (int) (width * height * 0.4);
        int x, y;
        for (int i = 0; i < numberOfStatics; i++) {
            Coordinates coordinates;
            do {
                x = random.nextInt(width);
                y = random.nextInt(height);
                coordinates = new Coordinates(x, y);
            } while (!worldMap.isCoordinateEmpty(coordinates));

            int typeOfStaticEntity = random.nextInt(3);
            switch (typeOfStaticEntity) {
                case 0:
                    worldMap.setEntity(new Tree(coordinates), coordinates);
                    break;
                case 1:
                    worldMap.setEntity(new Rock(coordinates), coordinates);
                    break;
                case 2:
                    worldMap.setEntity(new Grass(coordinates), coordinates);
                    break;
            }
        }
    }

    private void setDirtInEmpty() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Coordinates coordinates = new Coordinates(x, y);
                if (worldMap.isCoordinateEmpty(coordinates))
                    worldMap.setEntity(new Dirt(coordinates), coordinates);
            }
        }
    }
}
