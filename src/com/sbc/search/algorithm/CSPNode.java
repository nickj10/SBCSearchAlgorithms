package com.sbc.search.algorithm;

import com.sbc.search.model.City;
import com.sbc.search.model.Connection;

public class CSPNode {
    private City city;
    private Connection connection;
    private long distance;
    private long duration;

    public CSPNode(City city, Connection connection, long distance, long duration) {
        this.city = city;
        this.connection = connection;
        this.distance = distance;
        this.duration = duration;
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

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
