package htl.gkr.f1statistics.fragments.listDrivers;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import htl.gkr.f1statistics.databinding.FragmentDriversBinding;
import htl.gkr.f1statistics.objects.Driver;


public class MyDriversRecyclerViewAdapter extends RecyclerView.Adapter<MyDriversRecyclerViewAdapter.ViewHolder> {

    private final List<Driver> mValues;

    public MyDriversRecyclerViewAdapter(List<Driver> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentDriversBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.mContentView.setText(mValues.get(position).getDriverName());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mContentView;
        public Driver mItem;

        public ViewHolder(FragmentDriversBinding binding) {
            super(binding.getRoot());
            mContentView = binding.textViewName2;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}