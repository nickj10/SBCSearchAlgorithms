import algorithm.AlgorithmManager;
import model.Routes;
import utils.JSONReader;
import utils.Menu;

public class Main {
    public static final String PATH = "resources/dades_routes_1.json";

    public static void main(String[] args) {
        JSONReader jsonReader = new JSONReader();

        // Get routes
        jsonReader.getDadesRoutes(PATH);
        Routes routes = new Routes(jsonReader.getCities(), jsonReader.getConnections());

        // Create menu and start the program
        Menu menu = new Menu();
        AlgorithmManager algoManager = new AlgorithmManager();
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
