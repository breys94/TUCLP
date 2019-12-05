package com.bastou.tuclp.model;

import java.util.ArrayList;
import java.util.HashMap;

public class GameSeries {

    private static HashMap<String, GameSeries> gameSeries = new HashMap<>();

    private String name;
    private ArrayList<Amiibo> amiibos;

    private GameSeries(String name){
        this.name = name;
        this.amiibos = new ArrayList<>();
    }

    public void addAmiibo(Amiibo a){
        this.amiibos.add(a);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Amiibo> getAmiibos() {
        return amiibos;
    }

    public static GameSeries getGameSeries(String name){
        if(!gameSeries.containsKey(name)) gameSeries.put(name, new GameSeries(name));
        return gameSeries.get(name);
    }

    public static void clear(){
        gameSeries.clear();
    }

    @Override
    public String toString() {
        return name;
    }
}
