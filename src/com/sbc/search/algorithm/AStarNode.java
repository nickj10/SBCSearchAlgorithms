package com.sbc.search.algorithm;

import com.sbc.search.model.City;
import com.sbc.search.model.Connection;

public class AStarNode {
    private AStarNode parent;
    private City current;
    private Connection connection;

    public AStarNode(AStarNode parent, City current, Connection connection) {
        this.parent = parent;
        this.current = current;
        this.connection = connection;
    }

    public AStarNode getParent() {
        return parent;
    }

    public void setParent(AStarNode parent) {
        this.parent = parent;
    }

    public City getCurrent() {
        return current;
    }

    public void setCurrent(City current) {
        this.current = current;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
