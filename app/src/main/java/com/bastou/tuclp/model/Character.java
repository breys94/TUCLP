package com.bastou.tuclp.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Character {

    private static HashMap<String,Character> characters = new HashMap<>();

    private String name;
    private ArrayList<Amiibo> amiibos;

    private Character(String name){
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

    public static Character getCharacter(String name){
        if(!characters.containsKey(name)) characters.put(name, new Character(name));
        return characters.get(name);
    }

    public static void clear(){
        characters.clear();
    }

    @Override
    public String toString() {
        return name;
    }
}
