package htl.gkr.f1statistics.objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import htl.gkr.f1statistics.API.APIViewModel;
import htl.gkr.f1statistics.API.HttpListener;
import htl.gkr.f1statistics.R;

public class Race {
    public static final List<Race> RACES = new ArrayList<Race>();

    private int raceId;
    private String raceName;
    private Date raceDate;
    private boolean cancelled;
    private Driver winner;

    public Race(int raceId, String raceName, Date raceDate, boolean cancelled, Driver winner) {
        this.raceId = raceId;
        this.raceName = raceName;
        this.raceDate = raceDate;
        this.cancelled = cancelled;
        this.winner = winner;
    }

    public static void getRacesFromAPI() {
        APIViewModel apiViewModel = new APIViewModel();
        apiViewModel.requestString("https://api.jolpi.ca/ergast/f1/races/", new HttpListener<String>() {
            @Override
            public void onSuccess(String response) {
                // Parse JSON response
            }

            @Override
            public void onError(String error) {
                // Handle error
            }
        });
    }

    public String getRaceName() {
        return raceName;
    }
}