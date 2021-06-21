package com.sbc.search.algorithm;

import com.sbc.search.model.City;

import java.util.ArrayList;

public class MainSolution {
    private ArrayList<City> path;
    private long cost;

    public MainSolution(ArrayList<City> path, long cost) {
        this.path = path;
        this.cost = cost;
    }

    public MainSolution() {
        this.path = new ArrayList<City>();
        this.cost = 0;
    }

    public void addCityToPath(City city, long cost) {
        this.path.add(city);
        this.cost += cost;
    }

    public void printSolution() {
        System.out.println("Path:");
        for(City c : this.path) {
            System.out.print(c.getName() + ", ");
        }
        System.out.println("\nDistance: " + this.cost + "m");
    }

    public ArrayList<City> getPath() {
        return path;
    }

    public void setPath(ArrayList<City> path) {
        this.path = path;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }
}
