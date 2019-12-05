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

public class ViewHolderRelease extends RecyclerView.ViewHolder {

    public TextView flag;
    public TextView time;

    public ViewHolderRelease(@NonNull View itemView) {
        super(itemView);
        flag = itemView.findViewById(R.id.flag);
        time = itemView.findViewById(R.id.time);
    }
}
