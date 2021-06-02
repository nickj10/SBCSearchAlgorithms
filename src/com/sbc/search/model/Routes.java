package com.sbc.search.model;

import java.util.ArrayList;

public class Routes {
    private ArrayList<City> cities;
    private ArrayList<Connection> connections;

    public Routes(ArrayList<City> cities, ArrayList<Connection> connections) {
        this.cities = cities;
        this.connections = connections;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public ArrayList<Connection> getConnections() {
        return connections;
    }

    public ArrayList<Connection> getConnectionsByOrigin(String city) {
        ArrayList<Connection> connections = new ArrayList<>();
        for (Connection c : this.connections) {
            if (c.getFrom().equals(city)) {
                connections.add(c);
            }
        }
        return connections;
    }
    public City getCity(String cityName) {
        for(City c : cities) {
            if (c.getName().equals(cityName)) {
                return c;
            }
        }
        return null;
    }
}
