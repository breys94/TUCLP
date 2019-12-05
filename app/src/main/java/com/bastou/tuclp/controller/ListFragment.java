package com.bastou.tuclp.controller;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bastou.tuclp.R;
import com.bastou.tuclp.model.Amiibo;
import com.bastou.tuclp.view.ListAmiiboAdapter;

import java.util.ArrayList;


public class ListFragment extends Fragment{

    private ListAmiiboAdapter listAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_layout, container, false);

        listAdapter = new ListAmiiboAdapter(Amiibo.getList());
        RecyclerView list = view.findViewById(R.id.listview);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        list.setLayoutManager(mLayoutManager);
        list.setAdapter(listAdapter);
        return view;
    }

    public void updateList(){
        this.getView().post(new Runnable() {
            @Override
            public void run() {
                listAdapter.setValues(Amiibo.getList());
                RecyclerView list = getView().findViewById(R.id.listview);
                list.setAdapter(listAdapter);
                listAdapter.notifyDataSetChanged();
                Log.e("test", "nb ami : "+listAdapter.getItemCount());
            }
        });
    }


}
