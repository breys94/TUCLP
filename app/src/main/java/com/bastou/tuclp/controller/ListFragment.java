package com.bastou.tuclp.controller;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ListView;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bastou.tuclp.R;
import com.bastou.tuclp.model.Amiibo;
import com.bastou.tuclp.view.ListAmiiboAdapter;

import java.util.ArrayList;


public class ListFragment extends Fragment{

    private ListAmiiboAdapter listAdapter;
    private EditText search_field;
    private Animation slide_down;
    private Animation slide_up;
    private View search_content;
    private RecyclerView list;
    private boolean searchActivate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_layout, container, false);
        listAdapter = new ListAmiiboAdapter(Amiibo.getList(), this.getActivity());
        list = view.findViewById(R.id.listview);
        search_field = view.findViewById(R.id.search_field);
        slide_up = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        slide_down = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down);
        search_content = view.findViewById(R.id.search_content);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        list.setLayoutManager(mLayoutManager);
        list.setAdapter(listAdapter);
        search_content.setVisibility(View.INVISIBLE);
        slide_up.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //empty
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                search_content.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //empty
            }
        });
        slide_down.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                search_content.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //empty
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //empty
            }
        });
        search_field.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //empty
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                listAdapter.search(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //empty
            }
        });

        return view;
    }

    public void updateSearchField(){
        search_content.startAnimation(searchActivate ? slide_up : slide_down);
        searchActivate = !searchActivate;
    }

    public void updateList(){
        this.getView().post(new Runnable() {
            @Override
            public void run() {
                listAdapter.setValues(Amiibo.getList());
                list.setAdapter(listAdapter);
                listAdapter.notifyDataSetChanged();
            }
        });
    }


}
