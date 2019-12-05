package com.bastou.tuclp.view;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bastou.tuclp.DisplayActivity;
import com.bastou.tuclp.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    private Activity act;
    public TextView name_field;
    public TextView game_field;
    public ImageView img_field;

    public ViewHolder(@NonNull View itemView, Activity act) {
        super(itemView);
        this.act = act;
        img_field = itemView.findViewById(R.id.img_item);
        name_field = itemView.findViewById(R.id.name_item);
        game_field = itemView.findViewById(R.id.game_item);
    }

    public void setOnclick(final int id){
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(act, DisplayActivity.class);
                i.putExtra(DisplayActivity.KEY_ID, id);
                act.startActivity(i);
            }
        });
    }
}
