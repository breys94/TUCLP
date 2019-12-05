package com.bastou.tuclp.controller;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bastou.tuclp.CallApi;
import com.bastou.tuclp.CallUrlResponse;
import com.bastou.tuclp.MainActivity;
import com.bastou.tuclp.R;
import com.bastou.tuclp.api.LoaderAmiibo;
import com.bastou.tuclp.model.Amiibo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class LoaderFragment extends Fragment implements IProgressInfo{

    private ProgressBar progressBar;
    private TextView info;
    private IOnLoadEnd onLoadEnd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.loading_layout, container, false);
        progressBar = view.findViewById(R.id.load_pb);
        info = view.findViewById(R.id.load_text_info);
        setMax(1);
        update(0);
        init();
        return view;
    }

    private void init(){
        final LoaderFragment l = this;
        new CallApi().execute("https://www.amiiboapi.com/api/amiibo", new CallUrlResponse() {
            @Override
            public void urlResult(String res) {
                try {
                    JSONObject json = new JSONObject(res);
                    final ArrayList<Amiibo> amiibos = LoaderAmiibo.loadAmiibo(json, l);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setOnLoadEnd(IOnLoadEnd onLoadEnd) {
        this.onLoadEnd = onLoadEnd;
    }

    @Override
    public void setMax(int max) {
        progressBar.setMax(max);
    }

    @Override
    public void update(final int per) {

        final String s = getResources().getString(R.string.text_info_load).replace("%p", ""+per).replace("%m", ""+progressBar.getMax());
        info.post(new Runnable() {
            @Override
            public void run() {
                info.setText(s);
                info.setVisibility(progressBar.getMax() == 1 ? View.INVISIBLE : View.VISIBLE);
                progressBar.setProgress(per);
            }
        });
    }

    @Override
    public void end() {
        onLoadEnd.onLoadEnd();
    }
}
