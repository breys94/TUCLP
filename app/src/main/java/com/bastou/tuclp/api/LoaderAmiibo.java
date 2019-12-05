package com.bastou.tuclp.api;

import com.bastou.tuclp.model.Amiibo;
import com.bastou.tuclp.model.AmiiboSeries;
import com.bastou.tuclp.model.Character;
import com.bastou.tuclp.model.GameSeries;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LoaderAmiibo {

    private static final String KEY_NAME = "name";
    private static final String KEY_CHAR = "character";
    private static final String KEY_ASER = "amiiboSeries";
    private static final String KEY_GSER = "gameSeries";
    private static final String KEY_AIMG = "image";
    private static final String KEY_AREL = "release";


    public static ArrayList<Amiibo> loadAmiibo(JSONObject info) throws JSONException {
        ArrayList<Amiibo> amiibos = new ArrayList<>();
        Character.clear();
        GameSeries.clear();
        AmiiboSeries.clear();
        Amiibo.clear();

        JSONArray array = info.getJSONArray("amiibo");
        for(int i = 0 ; i < array.length(); i++){
            JSONObject ami = array.getJSONObject(i);

            String name = ami.getString(KEY_NAME);
            Character character = Character.getCharacter(ami.getString(KEY_CHAR));
            AmiiboSeries amiiboSeries = AmiiboSeries.getAmiiboSeries(ami.getString(KEY_ASER));
            GameSeries gameSeries = GameSeries.getGameSeries(ami.getString(KEY_GSER));
            String imgUrl = ami.getString(KEY_AIMG);
            String release = ami.getString(KEY_AREL);

            Amiibo amiibo = new Amiibo(name, character, amiiboSeries, gameSeries);
            character.addAmiibo(amiibo);
            amiiboSeries.addAmiibo(amiibo);
            gameSeries.addAmiibo(amiibo);

            amiibos.add(amiibo);
        }

        return amiibos;
    }

}
