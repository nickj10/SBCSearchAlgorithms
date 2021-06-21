package com.sbc.search.algorithm;

import com.sbc.search.model.City;

public class CSP {

    public MainSolution findShortestPath(City orig, City dest, CSPHeuristic heuristic) {
        return CSPAlgorithm(orig, dest, heuristic);
    }

    public MainSolution CSPAlgorithm(City orig, City dest, CSPHeuristic heuristic) {
        return null;
    }
}
