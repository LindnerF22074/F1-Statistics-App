package htl.gkr.f1statistics.fragments.listCircuits;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import htl.gkr.f1statistics.objects.Circuit;
import htl.gkr.f1statistics.databinding.FragmentCircuitsBinding;

import java.util.List;

public class MyCircuitsRecyclerViewAdapter extends RecyclerView.Adapter<MyCircuitsRecyclerViewAdapter.ViewHolder> {

    private final List<Circuit> mValues;

    public MyCircuitsRecyclerViewAdapter(List<Circuit> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentCircuitsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).getCircuitName());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mContentView;
        public Circuit mItem;

        public ViewHolder(FragmentCircuitsBinding binding) {
            super(binding.getRoot());
            mContentView = binding.textViewName;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}