package htl.gkr.f1statistics.fragments.listCircuits;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import htl.gkr.f1statistics.API.APIViewModel;
import htl.gkr.f1statistics.API.HttpListener;
import htl.gkr.f1statistics.R;
import htl.gkr.f1statistics.objects.Circuit;

/**
 * A fragment representing a list of Items.
 */
public class CircuitsFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CircuitsFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CircuitsFragment newInstance(int columnCount) {
        CircuitsFragment fragment = new CircuitsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_circuits_list, container, false);




        APIViewModel apiViewModel = new APIViewModel();
        apiViewModel.init(requireContext());
        apiViewModel.requestString("https://api.jolpi.ca/ergast/f1/circuits/", new HttpListener<String>() {
            @Override
            public void onSuccess(String response) {
                System.out.println(response);
                Circuit.handleCircuitsJson(response);
                System.out.println("Circuits: " + Circuit.CIRCUITS);
            }

            @Override
            public void onError(String error) {
                System.out.println(error);
            }
        });
        System.out.println("Circuits: " + Circuit.CIRCUITS);





        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyCircuitsRecyclerViewAdapter(Circuit.CIRCUITS));
        }
        return view;
    }
}