package com.bastou.tuclp.controller;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bastou.tuclp.R;
import com.bastou.tuclp.model.Amiibo;
import com.bastou.tuclp.view.ListAmiiboAdapter;


public class PhotoFragment extends Fragment{

    private ImageView photo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.photo_layout, container, false);
        photo = view.findViewById(R.id.photo_layout);
        return view;
    }

    public void updatePhoto(Bitmap bitmap){
        this.photo.setImageBitmap(bitmap);
    }


}
