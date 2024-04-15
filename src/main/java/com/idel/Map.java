package com.idel;

import com.idel.entities.Entity;

import java.util.HashMap;

public class Map {
    private final int width;
    private final int height;
    private HashMap<Coordinates, Entity> entities = new HashMap<>();

    public Map(int width, int height) {
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
        entities.remove(entity.getCoordinates());
        setEntity(entity, newCoordinates);
    }

    public void removeEntity(Coordinates coordinates) {
        entities.remove(coordinates);
    }

    public boolean isCoordinateEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
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
