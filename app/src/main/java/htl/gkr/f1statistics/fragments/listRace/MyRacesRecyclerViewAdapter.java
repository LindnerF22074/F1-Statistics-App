package htl.gkr.f1statistics.fragments.listRace;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import htl.gkr.f1statistics.databinding.FragmentRacesBinding;
import htl.gkr.f1statistics.objects.Race;

import java.util.List;

public class MyRacesRecyclerViewAdapter extends RecyclerView.Adapter<MyRacesRecyclerViewAdapter.ViewHolder> {

    private final List<Race> mValues;

    public MyRacesRecyclerViewAdapter(List<Race> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentRacesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).getRaceName());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mContentView;
        public Race mItem;

        public ViewHolder(FragmentRacesBinding binding) {
            super(binding.getRoot());

            mContentView = binding.textViewName;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}