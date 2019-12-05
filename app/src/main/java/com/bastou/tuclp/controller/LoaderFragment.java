package com.bastou.tuclp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bastou.tuclp.api.LoaderAmiibo;
import com.bastou.tuclp.model.Amiibo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class LoaderFragment extends Fragment {

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.loading_layout, container, false);

        new CallApi().execute("https://www.amiiboapi.com/api/amiibo", new CallUrlResponse() {
            @Override
            public void urlResult(String res) {
                try {
                    JSONObject json = new JSONObject(res);
                    final ArrayList<Amiibo> amiibos = LoaderAmiibo.loadAmiibo(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        return view;
    }

}
