package com.sbc.search.algorithm;

import com.sbc.search.model.City;
import com.sbc.search.model.Routes;

import java.util.ArrayList;
import java.util.Scanner;

public class AlgorithmManager {
    private Routes routes;
    private AStar astar;
    private CSP csp;
    private Scanner scanner;

    public AlgorithmManager(Routes routes) {
        this.routes = routes;
        this.astar = new AStar(routes);
        this.csp = new CSP();
        this.scanner = new Scanner(System.in);
    }

    public void start(int opt) {
        switch (opt) {
            case 1:
                System.out.println("A-star selected.");
                System.out.print("Enter origin: ");
                String origin = scanner.nextLine();
                System.out.print("Enter destination: ");
                String destination = scanner.nextLine();
                City orgCity = routes.getCity(origin);
                City destCity = routes.getCity(destination);
                if (orgCity == null) {
                    System.out.println("ERROR: City " + origin + " not found.");
                    break;
                } else if(destCity == null) {
                    System.out.println("ERROR: City " + destination + " not found.");
                    break;
                } else {
                    AStarSolution solution = astar.findShortestPath(orgCity, destCity);
                    solution.printSolution();
                }
                break;
            case 2:
                System.out.println("CSP selected.");
                break;
        }
    }
}
