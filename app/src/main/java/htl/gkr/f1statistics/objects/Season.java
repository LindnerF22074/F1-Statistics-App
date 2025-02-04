package htl.gkr.f1statistics.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Season {
    public static List<Season> SEASONS = new ArrayList<Season>();

    private int seasonId;
    private int year;

    public int getSeasonYear() {
        return year;
    }
}