package com.bastou.tuclp.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bastou.tuclp.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView name_field;
    public TextView game_field;
    public ImageView img_field;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        img_field = itemView.findViewById(R.id.img_item);
        name_field = itemView.findViewById(R.id.name_item);
        game_field = itemView.findViewById(R.id.game_item);
    }
}
