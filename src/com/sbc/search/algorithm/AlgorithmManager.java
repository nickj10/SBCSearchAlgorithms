package com.sbc.search.algorithm;

import com.sbc.search.model.City;
import com.sbc.search.model.Routes;

import java.util.Scanner;

public class AlgorithmManager {
    private Routes routes;
    private AStar astar;
    private CSP csp;
    private Scanner scanner;

    public AlgorithmManager(Routes routes) {
        this.routes = routes;
        this.astar = new AStar(routes);
        this.csp = new CSP(routes);
        this.scanner = new Scanner(System.in);
    }

    public void start(int opt, int optB) {
        if (opt != 3) {
            System.out.print("Enter origin: ");
            String origin = scanner.nextLine();
            System.out.print("Enter destination: ");
            String destination = scanner.nextLine();
            City orgCity = routes.getCity(origin);
            City destCity = routes.getCity(destination);
            if (orgCity == null) {
                System.out.println("ERROR: City " + origin + " not found.");
            } else if (destCity == null) {
                System.out.println("ERROR: City " + destination + " not found.");
            } else {
                switch (opt) {
                    case 1:
                        MainSolution solution = astar.findShortestPath(orgCity, destCity);
                        solution.printSolution();
                        break;
                    case 2:
                        MainSolution cspSol = null;
                        if (optB == 'a') {
                            csp.findShortestPath(orgCity, destCity, CSPHeuristic.MOST_CONSTRAINING_VARIABLE);
                        } else if (optB == 'b') {
                            cspSol = csp.findShortestPath(orgCity, destCity, CSPHeuristic.LEAST_CONSTRAINING_VALUE);
                        } else if (optB == 'c') {
                            cspSol = csp.findShortestPath(orgCity, destCity, CSPHeuristic.DEGREE);
                        }
                        if (cspSol != null) {
                            cspSol.printSolution();
                        } else {
                            System.out.println("No solution was found for the given origin and destination.");
                        }
                        break;
                }
            }
        }

    }
}
