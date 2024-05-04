package com.idel;

import com.idel.entities.Creature;
import com.idel.entities.Dirt;
import com.idel.entities.Entity;

import java.util.*;

public class PathFinder {
    private final Creature creature;
    private final Class<? extends Entity> victim;
    private final WorldMap worldMap;

    public PathFinder(WorldMap worldMap, Creature creature) {
        this.worldMap = worldMap;
        this.creature = creature;
        this.victim = creature.getVictim();

    }

    public List<Coordinates> findPath() {
        Queue<Node> queue = new LinkedList<>();
        Set<Coordinates> explored = new HashSet<>();
        List<Coordinates> path = new ArrayList<>();

        Coordinates startCoordinates = creature.getCoordinates();
        queue.add(new Node(startCoordinates, null));
        explored.add(startCoordinates);

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            Coordinates currCoordinates = currNode.coordinates;

            if (isVictim(currCoordinates)) {
                while (currNode.parent != null) {
                    path.add(currNode.coordinates);
                    currNode = currNode.parent;
                }
                break;
            }

            List<Coordinates> neighbors = getNeighbors(currCoordinates);
            for (Coordinates neighbor : neighbors) {
                if (!explored.contains(neighbor) && (isMovePossible(neighbor) || isVictim(neighbor))) {
                    queue.add(new Node(neighbor, currNode));
                    explored.add(neighbor);
                }
            }
        }

        return path;
    }

    private boolean isVictim(Coordinates coordinates) {
        Entity entity = worldMap.getEntityByCoordinates(coordinates);
        return entity != null && entity.getClass() == victim;
    }

    private static List<Coordinates> getNeighbors(Coordinates coordinates) {
        List<Coordinates> neighbors = new ArrayList<>();
        int x = coordinates.getX();
        int y = coordinates.getY();

        neighbors.add(new Coordinates(x - 1, y + 1));
        neighbors.add(new Coordinates(x, y + 1));
        neighbors.add(new Coordinates(x + 1, y + 1));
        neighbors.add(new Coordinates(x - 1, y));
        neighbors.add(new Coordinates(x + 1, y));
        neighbors.add(new Coordinates(x - 1, y - 1));
        neighbors.add(new Coordinates(x, y - 1));
        neighbors.add(new Coordinates(x + 1, y - 1));

        return neighbors;
    }

    private boolean isMovePossible(Coordinates coordinates) {
        Entity entity = worldMap.getEntityByCoordinates(coordinates);
        return entity instanceof Dirt;
    }

    private static class Node {
        Coordinates coordinates;
        Node parent;

        Node(Coordinates coordinates, Node parent) {
            this.coordinates = coordinates;
            this.parent = parent;
        }
    }
}
