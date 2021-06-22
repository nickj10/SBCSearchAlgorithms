package com.sbc.search.algorithm;

import com.sbc.search.model.City;
import com.sbc.search.model.Connection;
import com.sbc.search.model.Routes;

import java.util.ArrayList;

public class CSP {

    private final Routes routes;

    public CSP(Routes routes) {
        this.routes = routes;
    }

    public MainSolution findShortestPath(City orig, City dest, CSPHeuristic heuristic) {
        MainSolution solution = new MainSolution();
        CSPNode node = new CSPNode(orig, null, 0);
        solution.addCityToPath(orig, 0, 0);
        MainSolution best = new MainSolution();
        best.addCityToPath(orig, Long.MAX_VALUE, Long.MAX_VALUE);
        CSPAlgorithm(orig, dest, node, 0, solution, best, heuristic);
        return solution;
    }

    public void CSPAlgorithm(City orig, City dest, CSPNode current, int i, MainSolution solution, MainSolution best, CSPHeuristic heuristic) {
        while (!routes.getConnectionsByOrigin(current.getCity().getName()).isEmpty()) {
            ArrayList<Connection> connections = routes.getConnectionsByOrigin(current.getCity().getName());
            //Connection next = getBestConnection(current, connections);
            Connection next = connections.get(i);
            solution.addCityToPath(routes.getCity(next.getTo()), next.getDistance(), next.getDuration());
            i++;
            if (current.getCity().getName().equals(dest.getName())) { // Solution found
                if (solution.getCost() < best.getCost()) { // check if it's the best solution
                    // Update the best solution
                    best.setPath(new ArrayList<>(solution.getPath()));
                    best.setCost(solution.getCost());
                } // else we just discard the solution
            } else {
                // check if it's still factible
                if (completable(heuristic, solution)) {
                    CSPNode nextNode = new CSPNode(routes.getCity(next.getTo()), next, next.getDistance());
                    CSPAlgorithm(orig, dest, nextNode, i, best, solution, heuristic);
                }

            }
            solution.removeLastCity(next.getDistance(), next.getDistance());
            i--;
        }
    }

    private boolean completable(CSPHeuristic heuristic, MainSolution solution) {
        if (heuristic == CSPHeuristic.DEGREE) {
            // Use the duration as heuristic
            return true;
        }
        return false;
    }

    private Connection getBestConnection(CSPNode current, ArrayList<Connection> connections) {
        Connection best = connections.get(0);
        for (Connection c : connections) {
            long cost = current.getDistance() + c.getDistance();
            if (cost < best.getDistance()) {
                best = c;
            }
        }
        return best;
    }
}
