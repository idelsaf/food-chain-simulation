package com.idel.entities;

import com.idel.Coordinates;
import com.idel.entities.Entity;

public class Tree extends Entity {
    public Tree(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String toString() {
        return "\uD83C\uDF33";
    }
}
