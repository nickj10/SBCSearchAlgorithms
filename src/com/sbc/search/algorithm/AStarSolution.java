package com.sbc.search.algorithm;

import com.sbc.search.model.City;

import java.util.ArrayList;

public class AStarSolution {
    private ArrayList<City> path;
    private long cost;

    public AStarSolution(ArrayList<City> path, long cost) {
        this.path = path;
        this.cost = cost;
    }

    public void printSolution() {
        System.out.println("Path:");
        for(City c : this.path) {
            System.out.print(c.getName() + ", ");
        }
        System.out.println("\nDistance: " + this.cost + "m");
    }
}
