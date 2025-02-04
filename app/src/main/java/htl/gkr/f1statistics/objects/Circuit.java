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

    public static void getCircuitsFromAPI(){
        APIViewModel apiViewModel = new APIViewModel();
        apiViewModel.requestString("https://api.jolpi.ca/ergast/f1/circuits/", new HttpListener<String>() {
            @Override
            public void onSuccess(String response) {
                System.out.println(response);
            }

            @Override
            public void onError(String error) {
                System.out.println(error);
            }
        });
    }

    public int getCircuitId() {
        return circuitId;
    }

    public String  getCircuitName() {
        return circuitName;
    }
}