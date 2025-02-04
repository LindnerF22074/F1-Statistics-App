package htl.gkr.f1statistics.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import htl.gkr.f1statistics.MainViewModel;
import htl.gkr.f1statistics.R;
import htl.gkr.f1statistics.databinding.FragmentStartBinding;

public class StartFragment extends Fragment {
    FragmentStartBinding binding;
    public StartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStartBinding.inflate(inflater, container, false);
        MainViewModel viewModel=new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        binding.buttonSeasons.setOnClickListener(v-> {
            viewModel.showSeasonList();
        });

        binding.buttonDrivers.setOnClickListener(v -> {
            viewModel.showDriverList();
        });

        binding.buttonCircuits.setOnClickListener(v -> {
            viewModel.showCircuitList();
        });



        return binding.getRoot();
    }
}