package com.bastou.tuclp.api;

import android.util.JsonReader;
import android.util.Log;

import com.bastou.tuclp.controller.IProgressInfo;
import com.bastou.tuclp.model.Amiibo;
import com.bastou.tuclp.model.AmiiboSeries;
import com.bastou.tuclp.model.Character;
import com.bastou.tuclp.model.GameSeries;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class LoaderAmiibo {

    private static final String KEY_NAME = "name";
    private static final String KEY_CHAR = "character";
    private static final String KEY_ASER = "amiiboSeries";
    private static final String KEY_GSER = "gameSeries";
    private static final String KEY_AIMG = "image";
    private static final String KEY_AREL = "release";

    private static final int MAX_LOAD = 100;

    public static ArrayList<Amiibo> loadAmiibo(JSONObject info, IProgressInfo progress) throws JSONException, IOException {
        ArrayList<Amiibo> amiibos = new ArrayList<>();
        Character.clear();
        GameSeries.clear();
        AmiiboSeries.clear();
        Amiibo.clear();

        JSONArray array = info.getJSONArray("amiibo");
        if(progress != null)
            progress.setMax(Math.min(array.length(), MAX_LOAD));
        for(int i = 0 ; i < array.length() && i < MAX_LOAD; i++){
            Log.e("info", "nb : "+i+" / "+array.length());
            if(progress != null)
                progress.update(i);
            JSONObject ami = array.getJSONObject(i);

            String name = ami.getString(KEY_NAME);
            Character character = Character.getCharacter(ami.getString(KEY_CHAR));
            AmiiboSeries amiiboSeries = AmiiboSeries.getAmiiboSeries(ami.getString(KEY_ASER));
            GameSeries gameSeries = GameSeries.getGameSeries(ami.getString(KEY_GSER));
            String imgUrl = ami.getString(KEY_AIMG);
            JSONObject release = ami.getJSONObject(KEY_AREL);

            Amiibo amiibo = new Amiibo(name, character, amiiboSeries, gameSeries);
            amiibo.loadImage(imgUrl);

            character.addAmiibo(amiibo);
            amiiboSeries.addAmiibo(amiibo);
            gameSeries.addAmiibo(amiibo);

            amiibos.add(amiibo);
        }
        progress.update(Math.min(array.length(), MAX_LOAD));
        progress.end();
        return amiibos;
    }

}
