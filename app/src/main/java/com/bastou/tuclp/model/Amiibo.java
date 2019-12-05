package com.bastou.tuclp.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Amiibo {

    private static ArrayList<Amiibo> amiibos = new ArrayList<>();

    private int id;
    private String name;
    private Character character;
    private AmiiboSeries amiiboSeries;
    private GameSeries gameSeries;
    private Bitmap image;
    private List<Release> releases;

    public Amiibo(String name, Character character, AmiiboSeries amiiboSeries, GameSeries gameSeries) {
        this.name = name;
        this.character = character;
        this.amiiboSeries = amiiboSeries;
        this.gameSeries = gameSeries;
        this.id = amiibos.size();
        this.releases = new ArrayList<>();
        amiibos.add(this);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Character getCharacter() {
        return character;
    }

    public AmiiboSeries getAmiiboSeries() {
        return amiiboSeries;
    }

    public GameSeries getGameSeries() {
        return gameSeries;
    }

    public Bitmap getImage() {
        return image;
    }

    public void addRelease(Release r){
        this.releases.add(r);
    }

    public List<Release> getReleases() {
        return releases;
    }

    public void loadImage(String path) throws IOException {
        URL url = new URL(path);
        image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
    }

    public static ArrayList<Amiibo> getList(){
        return amiibos;
    }

    public static void clear(){
        amiibos.clear();
    }

    @Override
    public String toString() {
        return name;
    }
}
