package com.idel;

import java.util.HashMap;

public class Map {
    HashMap<Coordinates, Entity> entities = new HashMap<>();

    public void setEntity(Entity entity, Coordinates coordinates) {
        entity.coordinates = coordinates;
        entities.put(coordinates, entity);
    }
}
