package utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.City;
import model.Connection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class JSONReader {
    private final Gson gson;
    private JsonArray cities;
    private JsonArray connections;

    public JSONReader() {
        this.gson = new Gson();
    }

    public void getDadesRoutes(String path) {
        try {
            Path p = Paths.get(path);

            if (!Files.exists(p)) {
                Files.createFile(p);

                this.cities = new JsonArray();
                this.connections = new JsonArray();
            } else {
                JsonObject jobject = JsonParser.parseString(Files.readString(p)).getAsJsonObject();
                this.cities = jobject.getAsJsonArray("cities");
                this.connections = jobject.getAsJsonArray("connections");
            }
        } catch (IOException e) {
            System.out.println("ERROR: There has been an error reading the file.");
            e.printStackTrace();
        }
    }

    public ArrayList<City> getCities() {
        ArrayList<City> cities = new ArrayList<>();
        for (int i = 0; i < this.cities.size(); i++) {
            City city = gson.fromJson(this.cities.get(i), City.class);
            cities.add(city);
        }
        return cities;
    }

    public ArrayList<Connection> getConnections() {
        ArrayList<Connection> connections = new ArrayList<>();
        for (int i = 0; i < this.connections.size(); i++) {
            Connection conn = gson.fromJson(this.connections.get(i), Connection.class);
            connections.add(conn);
        }
        return connections;
    }
}
