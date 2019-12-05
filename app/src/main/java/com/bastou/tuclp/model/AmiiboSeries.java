package com.bastou.tuclp.model;

import java.util.ArrayList;
import java.util.HashMap;

public class AmiiboSeries {

    private static HashMap<String, AmiiboSeries> amiiboSeries = new HashMap<>();

    private String name;
    private ArrayList<Amiibo> amiibos;

    private AmiiboSeries(String name){
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

    public static AmiiboSeries getAmiiboSeries(String name){
        if(!amiiboSeries.containsKey(name)) amiiboSeries.put(name, new AmiiboSeries(name));
        return amiiboSeries.get(name);
    }

    public static void clear(){
        amiiboSeries.clear();
    }

    @Override
    public String toString() {
        return name;
    }
}
