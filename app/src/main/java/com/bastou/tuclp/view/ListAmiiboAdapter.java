package com.bastou.tuclp.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bastou.tuclp.R;
import com.bastou.tuclp.model.Amiibo;

import java.util.ArrayList;
import java.util.List;

public class ListAmiiboAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Amiibo> values;
    private List<Amiibo> base;
    private Activity act;

    public void setValues(List<Amiibo> values) {
        this.values = values;
        this.base = values;
    }

    public void search(String search){
        this.values = new ArrayList<>();
        for(Amiibo a : base){
            if(a.getName().toLowerCase().contains(search.toLowerCase())){
                values.add(a);
            }
        }
        notifyDataSetChanged();
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListAmiiboAdapter(List<Amiibo> myDataset, Activity act) {
        this.setValues(myDataset);
        this.act = act;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_list_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v, act);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Amiibo amiibo = values.get(position);
        holder.setOnclick(amiibo.getId());
        holder.name_field.setText(amiibo.getName());
        holder.game_field.setText(amiibo.getGameSeries().toString());
        holder.img_field.setImageBitmap(amiibo.getImage());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}