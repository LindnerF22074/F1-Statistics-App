package htl.gkr.f1statistics.objects;

import java.util.ArrayList;
import java.util.List;

import htl.gkr.f1statistics.API.APIViewModel;
import htl.gkr.f1statistics.API.HttpListener;


public class Circuit {
    public static List<Circuit> CIRCUITS =new ArrayList<Circuit>();

    private int circuitId;
    private String circuitName;
    private String circuitLocation;
    private String circuitCountry;
    private String circuitAltitude;

    public Circuit(int circuitId, String circuitName, String circuitLocation, String circuitCountry, String circuitAltitude) {
        this.circuitId = circuitId;
        this.circuitName = circuitName;
        this.circuitLocation = circuitLocation;
        this.circuitCountry = circuitCountry;
        this.circuitAltitude = circuitAltitude;
    }


    public static void handleCircuitsJson(String json) {
        CIRCUITS.clear();
        String[] lines = json.split("\n");
        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length == 5) {
                CIRCUITS.add(new Circuit(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4]));
            }
        }
    }


    public int getCircuitId() {
        return circuitId;
    }

    public String  getCircuitName() {
        return circuitName;
    }

    public static List<Circuit> getCircuits() {
        return CIRCUITS;
    }
    public static void setCircuits(List<Circuit> circuits) {
        CIRCUITS = circuits;
    }
}