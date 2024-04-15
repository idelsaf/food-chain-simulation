package com.idel.actions;

import com.idel.*;
import com.idel.entities.*;

import java.util.Random;

public class initAction {
    private Map map;
    private final int width = 10;
    private final int height = 5;

    public void initSpawn() {
        map = new Map(width, height);

        setCreatures();
        setStaticEntities();
        setDirtInEmpty();

        System.out.println(map);
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
            } while (!map.isCoordinateEmpty(coordinates));

            int typeOfStaticEntity = random.nextInt(2);
            switch (typeOfStaticEntity) {
                case 0:
                    map.setEntity(new Herbivore(coordinates), coordinates);
                    break;
                case 1:
                    map.setEntity(new Predator(coordinates), coordinates);
                    break;
            }
        }
    }

    private void setStaticEntities() {
        Random random = new Random();
        int numberOfStatics = (int) (width * height * 0.6);
        int x, y;
        for (int i = 0; i < numberOfStatics; i++) {
            Coordinates coordinates;
            do {
                x = random.nextInt(width);
                y = random.nextInt(height);
                coordinates = new Coordinates(x, y);
            } while (!map.isCoordinateEmpty(coordinates));

            int typeOfStaticEntity = random.nextInt(3);
            switch (typeOfStaticEntity) {
                case 0:
                    map.setEntity(new Tree(coordinates), coordinates);
                    break;
                case 1:
                    map.setEntity(new Rock(coordinates), coordinates);
                    break;
                case 2:
                    map.setEntity(new Grass(coordinates), coordinates);
                    break;
            }
        }
    }

    private void setDirtInEmpty() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Coordinates coordinates = new Coordinates(x, y);
                if (map.isCoordinateEmpty(coordinates))
                    map.setEntity(new Dirt(coordinates), coordinates);
            }
        }
    }
}
