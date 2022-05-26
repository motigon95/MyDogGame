package com.example.juegodeturinoposta.model;

import java.util.ArrayList;

public class PlayableCharacter extends Character {



    private ArrayList<Consumables> backPack;

    public PlayableCharacter(String name, int atkPoints, int dfdPoints, int agilityPoints) {
        super(name, atkPoints, dfdPoints, agilityPoints);
        this.setInitialStats();
    }


    protected void setInitialStats(){
        this.setMaxHP(50);
        this.setCurrentHP(50);
        this.setLvl(1);
        this.setXp(0);
    }





    public void useConsumable(Consumables consumables){

    }
}
