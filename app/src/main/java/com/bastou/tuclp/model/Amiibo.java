package com.bastou.tuclp.model;

import java.util.ArrayList;

public class Amiibo {

    private static ArrayList<Amiibo> amiibos = new ArrayList<>();

    private int id;
    private String name;
    private Character character;
    private AmiiboSeries amiiboSeries;
    private GameSeries gameSeries;

    public Amiibo(String name, Character character, AmiiboSeries amiiboSeries, GameSeries gameSeries) {
        this.name = name;
        this.character = character;
        this.amiiboSeries = amiiboSeries;
        this.gameSeries = gameSeries;
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
