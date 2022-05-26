package com.example.juegodeturinoposta.model;

import android.net.Uri;
import android.widget.ImageView;

public abstract class Character {

    private String name;
    private Uri charImg;
    private int maxHP;
    private int currentHP;
    private int lvl;
    private int xp;
    private int atkPoints;
    private int dfdPoints;
    private int agilityPoints;



    public Character (String name, int atkPoints, int dfdPoints, int agilityPoints ){

        this.name = name;
        this.atkPoints =atkPoints;
        this.dfdPoints = dfdPoints;
        this.agilityPoints = agilityPoints;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uri getCharImg() {
        return charImg;
    }

    public void setCharImg(Uri charImg) {
        this.charImg = charImg;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getAtkPoints() {
        return atkPoints;
    }

    public void setAtkPoints(int atkPoints) {
        this.atkPoints = atkPoints;
    }

    public int getDfdPoints() {
        return dfdPoints;
    }

    public void setDfdPoints(int dfdPoints) {
        this.dfdPoints = dfdPoints;
    }

    public int getAgilityPoints() {
        return agilityPoints;
    }

    public void setAgilityPoints(int agilityPoints) {
        this.agilityPoints = agilityPoints;
    }
}
