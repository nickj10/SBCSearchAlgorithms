package com.sbc.search.algorithm;

import java.util.Comparator;

public class AStarNodeComparator implements Comparator<AStarNode> {
    @Override
    public int compare(AStarNode o1, AStarNode o2) {
        //return Long.compare(o1.getConnection().getDistance(), o2.getConnection().getDistance());
        return Long.compare(o1.getCost(), o2.getCost());
    }
}
