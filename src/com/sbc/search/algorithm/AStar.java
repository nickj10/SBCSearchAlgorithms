package com.sbc.search.algorithm;

import com.sbc.search.model.City;
import com.sbc.search.model.Connection;
import com.sbc.search.model.Routes;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class AStar {
    private Routes routes;

    public AStar(Routes routes) {
        this.routes = routes;
    }

    public MainSolution findShortestPath(City orig, City dest) {
        return aStarAlgorithm(orig, dest);
    }

    private MainSolution aStarAlgorithm(City orig, City dest) {
        PriorityQueue<AStarNode> open = new PriorityQueue<>(routes.getConnections().size(), new AStarNodeComparator());
        ArrayList<AStarNode> closed = new ArrayList<>();

        // Add initial node to open
        open.add(new AStarNode(null, orig, null, 0, 0));
        while (!open.isEmpty()) {
            AStarNode node = open.poll();
            if (isDestination(node, dest)) {
                closed.add(new AStarNode(null, node.getCurrent(), node.getConnection(), node.getCost(), node.getDistance()));
                break;
            } else {
                AStarNode parent;
                if (!closed.isEmpty()) {
                    parent = closed.get(closed.size() - 1);
                } else {
                    parent = null;
                }
                closed.add(new AStarNode(parent, node.getCurrent(), node.getConnection(), node.getCost(), node.getDistance()));
                ArrayList<Connection> connections = routes.getConnectionsByOrigin(node.getCurrent().getName());
                for (Connection conn : connections) {
                    if (isVisited(conn, closed) || toBeVisited(conn, open)) {
                        continue;
                    } else {
                        long h = (long)(conn.getDistance() * 3); // variable heuristic
                        //long h = 0;
                        //long h = (long)(conn.getDistance() * 0.5);
                        //long h = (long)(conn.getDistance() * 1);

                        // Calculate f(n) = g(n) + h(n), where h(n) is the heuristic
                        long cost = node.getCost() + conn.getDistance() + h;
                        open.add(new AStarNode(node, routes.getCity(conn.getTo()), conn, cost, node.getCost() + conn.getDistance()));
                    }
                }
            }
        }
        return new MainSolution(aStarNodeToCities(closed), getTotalDistance(closed));
    }

    private long getTotalDistance(ArrayList<AStarNode> nodes) {
        return nodes.get(nodes.size() - 1).getDistance();
    }

    private boolean isDestination(AStarNode node, City dest) {
        return node.getCurrent().getName().equals(dest.getName());
    }

    private boolean toBeVisited(Connection conn, PriorityQueue<AStarNode> open) {
        AStarNode[] nodes = open.toArray(new AStarNode[open.size()]);
        for (AStarNode node : nodes) {
            if (node.getConnection().getTo().equals(conn.getTo()) && node.getConnection().getFrom().equals(conn.getFrom())) {
                return true;
            }
        }
        return false;
    }

    private boolean isVisited(Connection conn, ArrayList<AStarNode> closed) {
        for (AStarNode node : closed) {
            if (node.getConnection() != null) {
                if (conn.getTo().equals(node.getConnection().getTo())) {
                    return true;
                }
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
