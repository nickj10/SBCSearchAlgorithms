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

    public AStarSolution findShortestPath(City orig, City dest) {
        return aStarAlgorithm(orig, dest);
    }

    private AStarSolution aStarAlgorithm(City orig, City dest) {
        PriorityQueue<AStarNode> open = new PriorityQueue<>(routes.getConnections().size(), new AStarNodeComparator());
        ArrayList<AStarNode> closed = new ArrayList<>();

        // Add initial node to open
        open.add(new AStarNode(null, orig, null, 0));
        while (!open.isEmpty()) {
            AStarNode node = open.poll();
            if (isDestination(node, dest)) {
                closed.add(new AStarNode(null, node.getCurrent(), node.getConnection(), node.getCost()));
                break;
            } else {
                ArrayList<Connection> connections = routes.getConnectionsByOrigin(node.getCurrent().getName());
                for (Connection conn : connections) {
                    if (isVisited(conn, closed) || toBeVisited(conn, open)) {
                        continue;
                    } else {
                        // Calculate f(n) = g(n) + h(n), where h(n) is the heuristic
                        long cost = node.getCost() + conn.getDistance();
                        if (conn.getTo().equals(conn.getFrom())) {
                            closed.add(new AStarNode(node, routes.getCity(conn.getTo()), conn, cost));
                        } else {
                            open.add(new AStarNode(node, routes.getCity(conn.getTo()), conn, cost));
                        }
                    }
                }
            }
        }
        return new AStarSolution(aStarNodeToCities(closed), getTotalCost(closed));
    }

    private long getTotalCost(ArrayList<AStarNode> nodes) {
        return nodes.get(nodes.size() - 1).getCost();
    }

    private boolean isDestination(AStarNode node, City dest) {
        return node.getCurrent().getName().equals(dest.getName());
    }

    private boolean toBeVisited(Connection conn, PriorityQueue<AStarNode> open) {
        AStarNode[] nodes = open.toArray(new AStarNode[open.size()]);
        for(AStarNode node : nodes) {
            if (node.getConnection().getTo().equals(conn.getTo()) && node.getConnection().getFrom().equals(conn.getFrom())) {
                return true;
            }
        }
        return false;
    }

    private boolean isVisited(Connection conn, ArrayList<AStarNode> closed) {
        for(AStarNode node : closed) {
            if (conn.getTo().equals(node.getConnection().getTo())) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<City> aStarNodeToCities(ArrayList<AStarNode> nodes) {
        ArrayList<City> cities = new ArrayList<>();
        for (AStarNode n : nodes) {
            cities.add(n.getCurrent());
        }
        return cities;
    }
}
