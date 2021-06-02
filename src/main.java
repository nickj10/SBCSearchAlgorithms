import model.Routes;
import utils.JSONReader;

public class main {
    public static final String PATH = "resources/dades_routes_1.json";

    public static void main(String[] args) {
        JSONReader jsonReader = new JSONReader();

        // Get routes
        jsonReader.getDadesRoutes(PATH);
        Routes routes = new Routes(jsonReader.getCities(), jsonReader.getConnections());

        System.out.println("Start the program");
    }
}
