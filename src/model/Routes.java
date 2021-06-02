package model;

import java.util.ArrayList;

public class Routes {
    private ArrayList<City> cities;
    private ArrayList<Connection> connections;

    public Routes(ArrayList<City> cities, ArrayList<Connection> connections) {
        this.cities = cities;
        this.connections = connections;
    }
}
