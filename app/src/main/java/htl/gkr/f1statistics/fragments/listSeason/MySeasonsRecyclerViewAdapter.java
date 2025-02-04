package htl.gkr.f1statistics.fragments.listSeason;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import htl.gkr.f1statistics.databinding.FragmentSeasonsBinding;
import htl.gkr.f1statistics.objects.Season;

import java.util.List;


public class MySeasonsRecyclerViewAdapter extends RecyclerView.Adapter<MySeasonsRecyclerViewAdapter.ViewHolder> {

    private final List<Season> mValues;

    public MySeasonsRecyclerViewAdapter(List<Season> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentSeasonsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).getSeasonYear());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mContentView;
        public Season mItem;

        public ViewHolder(FragmentSeasonsBinding binding) {
            super(binding.getRoot());
            mContentView = binding.textViewYear;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}