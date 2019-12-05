package com.bastou.tuclp.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bastou.tuclp.R;
import com.bastou.tuclp.model.Amiibo;
import com.bastou.tuclp.model.Release;

import java.util.List;

public class ListReleaseAdapter extends RecyclerView.Adapter<ViewHolderRelease> {

    private List<Release> values;
    private Activity act;

    public void setValues(List<Release> values) {
        this.values = values;
    }

    public void add(int position, Release item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListReleaseAdapter(List<Release> myDataset) {
        values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolderRelease onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_release_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolderRelease vh = new ViewHolderRelease(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolderRelease holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Release r = values.get(position);
        holder.flag.setText(r.getPays());
        holder.time.setText(r.getDate());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}