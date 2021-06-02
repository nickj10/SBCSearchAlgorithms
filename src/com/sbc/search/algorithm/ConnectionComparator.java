package com.sbc.search.algorithm;

import com.sbc.search.model.Connection;

import java.util.Comparator;

public class ConnectionComparator implements Comparator<Connection> {
    @Override
    public int compare(Connection o1, Connection o2) {
        return Long.compare(o1.getDistance(), o2.getDistance());
    }
}
