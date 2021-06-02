package com.sbc.search;

import com.sbc.search.algorithm.AlgorithmManager;
import com.sbc.search.model.Routes;
import com.sbc.search.utils.JSONReader;
import com.sbc.search.utils.Menu;

public class Main {
    public static final String PATH = "resources/spain_routes.json";

    public static void main(String[] args) {
        JSONReader jsonReader = new JSONReader();

        // Get routes
        jsonReader.getDadesRoutes(PATH);
        Routes routes = new Routes(jsonReader.getCities(), jsonReader.getConnections());

        // Create menu and start the program
        Menu menu = new Menu();
        AlgorithmManager algoManager = new AlgorithmManager(routes);
        menu.showStartingMessage();
        do {
            do {
                menu.showMainMenu();
                menu.getOptionInput();
            } while (!menu.checkMainOption());
            algoManager.start(menu.getOptionA());
        } while (!menu.exitProgram());
    }
}
