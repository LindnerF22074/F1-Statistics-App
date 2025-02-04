package htl.gkr.f1statistics;



import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import htl.gkr.f1statistics.objects.Circuit;

public class MainViewModel extends ViewModel {
    public static final int START = 0;
    public static final int SEASONLIST = 1;
    public static final int DRIVERLIST = 2;
    public static final int CIRCUITLIST = 3;
    public static final int RACELIST = 4;
    public static final int FILTER = 5;
    public static final int DRIVERINFO = 6;
    public static final int RACEINFO = 7;
    public static final int CIRCUITINFO = 8;







    private MutableLiveData<Integer> _state = new MutableLiveData<>(START);
    public MutableLiveData<Integer> state = _state;

    public void showStart() {_state.postValue(START);}
    public void showSeasonList() {_state.postValue(SEASONLIST);}
    public void showDriverList() {_state.postValue(DRIVERLIST);}
    public void showCircuitList() {_state.postValue(CIRCUITLIST);}
    public void showRaceList() {_state.postValue(RACELIST);}
    public void showFilter() {_state.postValue(FILTER);}
    public void showDriverInfo() {_state.postValue(DRIVERINFO);}
    public void showRaceInfo() {_state.postValue(RACEINFO);}
    public void showCircuitInfo() {_state.postValue(CIRCUITINFO);}


}
