package com.idel;

import com.idel.entities.Dirt;
import com.idel.entities.Entity;

import java.util.HashMap;

public class WorldMap {
    private final int width;
    private final int height;
    private HashMap<Coordinates, Entity> entities = new HashMap<>();

    public WorldMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setEntity(Entity entity, Coordinates coordinates) {
        entity.setCoordinates(coordinates);
        entities.put(coordinates, entity);
    }

    public Entity getEntityByCoordinates(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public void moveEntity(Entity entity, Coordinates newCoordinates) {
        Coordinates oldCoordinates = entity.getCoordinates();
        entities.remove(oldCoordinates);
        setEntity(entity, newCoordinates);
        setEntity(new Dirt(oldCoordinates), oldCoordinates);
    }

    public void removeEntity(Entity entity) {
        Coordinates coordinates = entity.getCoordinates();
        entities.remove(coordinates);
        setEntity(new Dirt(coordinates), coordinates);
    }

    public boolean isCoordinateEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }

    public boolean isValidMove(Coordinates coordinates) {
        return getEntityByCoordinates(coordinates).getClass() == Dirt.class;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Coordinates coordinates = new Coordinates(j, i);
                string.append(entities.get(coordinates));
            }
            string.append("\n");
        }

        return string.toString();
    }
}
