package com.sbc.search.algorithm;

import com.sbc.search.model.City;
import com.sbc.search.model.Connection;
import com.sbc.search.model.Routes;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class AStar {
    private Routes routes;
    /*
    def heuristic(a: GridLocation, b: GridLocation) -> float:
    (x1, y1) = a
    (x2, y2) = b
    return abs(x1 - x2) + abs(y1 - y2)
     */

    public AStar(Routes routes) {
        this.routes = routes;
    }

    private void heuristic(long a, long b) {
        // TODO: Determine the heuristic
    }

    public ArrayList<City> findShortestPath(City orig, City dest) {
        return aStarAlgorithm(orig, dest);
    }

    private ArrayList<City> aStarAlgorithm(City orig, City dest) {
        PriorityQueue<AStarNode> open = new PriorityQueue<>(routes.getConnections().size(), new AStarNodeComparator());
        ArrayList<AStarNode> closed = new ArrayList<>();

        // Add initial node to open
        ArrayList<Connection> connections = routes.getConnectionsByOrigin(orig.getName());
        open.add(new AStarNode(null, orig, connections.get(0)));
        while (!open.isEmpty()) {
            AStarNode node = open.poll();
            if (node.getCurrent().getName().equals(dest.getName())) {
                closed.add(new AStarNode(null, node.getCurrent(), node.getConnection()));
                break;
            } else {

            }
        }
        return aStarNodeToCities(closed);
    }

    private ArrayList<City> aStarNodeToCities(ArrayList<AStarNode> nodes) {
        ArrayList<City> cities = new ArrayList<>();
        for (AStarNode n : nodes) {
            cities.add(n.getCurrent());
        }
        return cities;
    }
}
