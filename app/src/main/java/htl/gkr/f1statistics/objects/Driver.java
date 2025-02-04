package htl.gkr.f1statistics.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import htl.gkr.f1statistics.API.APIViewModel;
import htl.gkr.f1statistics.API.HttpListener;

public class Driver {
    public static final List<Driver> DRIVERS = new ArrayList<Driver>();

    private int driverId;
    private String driverName;
    private int age;
    private String nationality;
    private String abbreviation;
    private int carNumber;
    private String team;

    public Driver(int driverId, String driverName, int age, String nationality, String abbreviation, int carNumber, String team) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.age = age;
        this.nationality=nationality;
        this.abbreviation = abbreviation;
        this.carNumber = carNumber;
        this.team = team;
    }

    public static void getDriversFromAPI(){
        APIViewModel apiViewModel = new APIViewModel();
        apiViewModel.requestString("https://api.jolpi.ca/ergast/f1/drivers/", new HttpListener<String>() {
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

    public String getDriverName() {
        return driverName;
    }
}