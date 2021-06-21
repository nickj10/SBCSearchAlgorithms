package com.sbc.search.algorithm;

import com.sbc.search.model.City;
import com.sbc.search.model.Connection;

public class CSPNode {
    private City city;
    private Connection connection;
    private long distance;

    public CSPNode(City city, Connection connection, long distance) {
        this.city = city;
        this.connection = connection;
        this.distance = distance;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City current) {
        this.city = current;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }
}
