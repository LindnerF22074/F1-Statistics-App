package htl.gkr.f1statistics;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import htl.gkr.f1statistics.fragments.CircuitInfoFragment;
import htl.gkr.f1statistics.fragments.DriverInfoFragment;
import htl.gkr.f1statistics.fragments.FilterFragment;
import htl.gkr.f1statistics.fragments.RaceInfoFragment;
import htl.gkr.f1statistics.fragments.StartFragment;
import htl.gkr.f1statistics.fragments.listCircuits.CircuitsFragment;
import htl.gkr.f1statistics.fragments.listDrivers.DriversFragment;
import htl.gkr.f1statistics.fragments.listRace.RacesFragment;
import htl.gkr.f1statistics.fragments.listSeason.SeasonsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MainViewModel viewModel= new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.showStart();
        viewModel.state.observe(this,state->{
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            switch (state){
                case MainViewModel.START:{
                    fragmentTransaction.replace(R.id.main,new StartFragment());
                    break;
                }
                case MainViewModel.SEASONLIST:{
                    fragmentTransaction.replace(R.id.main,new SeasonsFragment());
                    fragmentTransaction.addToBackStack("SeasonListFragment");
                    break;
                }
                case MainViewModel.DRIVERLIST:{
                    fragmentTransaction.replace(R.id.main,new DriversFragment());
                    fragmentTransaction.addToBackStack("DriverListFragment");
                    break;
                }
                case MainViewModel.CIRCUITLIST:{
                    fragmentTransaction.replace(R.id.main,new CircuitsFragment());
                    fragmentTransaction.addToBackStack("CircuitListFragment");
                    break;
                }
                case MainViewModel.RACELIST:{
                    fragmentTransaction.replace(R.id.main,new RacesFragment());
                    fragmentTransaction.addToBackStack("RaceListFragment");
                    break;
                }
                case MainViewModel.FILTER:{
                    fragmentTransaction.replace(R.id.main,new FilterFragment());
                    fragmentTransaction.addToBackStack("FilterFragment");
                    break;
                }
                case MainViewModel.DRIVERINFO:{
                    fragmentTransaction.replace(R.id.main,new DriverInfoFragment());
                    fragmentTransaction.addToBackStack("DriverInfoFragment");
                    break;
                }
                case MainViewModel.RACEINFO: {
                    fragmentTransaction.replace(R.id.main, new RaceInfoFragment());
                    fragmentTransaction.addToBackStack("RaceInfoFragment");
                    break;
                }
                case MainViewModel.CIRCUITINFO:{
                    fragmentTransaction.replace(R.id.main,new CircuitInfoFragment());
                    fragmentTransaction.addToBackStack("CircuitInfoFragment");
                    break;
                }
            }
            fragmentTransaction.commit();
        });
    }
}