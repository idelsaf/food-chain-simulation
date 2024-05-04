package com.idel;

import com.idel.actions.InitAction;
import com.idel.actions.TurnAction;

public class Simulation {
    private final WorldMap worldMap;
    public int iterationCounter = 0;

    public Simulation() {
        worldMap = new WorldMap(8, 5);
        startSimulation(worldMap);
    }

    public void startSimulation(WorldMap worldMap) {
        InitAction initAction = new InitAction(worldMap);
        outputMap(worldMap);
        makeTurns(worldMap);
    }

    private void makeTurns(WorldMap worldMap) {
        TurnAction turnAction = new TurnAction();

        while (turnAction.makeCreaturesMoves(worldMap)) {
            iterationCounter++;
            outputMap(worldMap);
        }
    }

    private void outputMap(WorldMap worldMap) {
        System.out.println("Number of iteration: " + iterationCounter);
        for (int i = 0; i < worldMap.getWidth() * 3; i++)
            System.out.print("=");
        System.out.println();
        System.out.print(worldMap);
        for (int i = 0; i < worldMap.getWidth() * 3; i++)
            System.out.print("=");
        System.out.println("\n");
    }

    public WorldMap getMap() {
        return worldMap;
    }

}
