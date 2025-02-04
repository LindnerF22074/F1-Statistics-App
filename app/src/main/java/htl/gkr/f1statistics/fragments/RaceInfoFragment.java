package htl.gkr.f1statistics.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import htl.gkr.f1statistics.R;
import htl.gkr.f1statistics.databinding.FragmentRaceInfoBinding;

public class RaceInfoFragment extends Fragment {
    FragmentRaceInfoBinding binding;


    public RaceInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRaceInfoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}