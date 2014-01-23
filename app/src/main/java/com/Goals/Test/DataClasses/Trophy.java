package com.Goals.Test.DataClasses;

/**
 * Created by Drew on 1/14/14.
 */
public class Trophy {
    private int pkTrophy;
    private String name;
    private String trophyUrl;
    private String dateEarned;

    public Trophy(int pkTrophy, String name, String trophyUrl, String dateEarned)
    {
        this.pkTrophy = pkTrophy;
        this.name = name;
        this.trophyUrl = trophyUrl;
        this.dateEarned = dateEarned;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPkTrophy(int pkTrophy) {
        this.pkTrophy = pkTrophy;
    }

    public void setTropyUrl(String tropyUrl) {
        this.trophyUrl = tropyUrl;
    }

    public int getPkTrophy() {
        return pkTrophy;
    }

    public String getTropyUrl() {
        return trophyUrl;
    }

    public void setDateEarned(String dateEarned) {
        this.dateEarned = dateEarned;
    }

    public void setTrophyUrl(String trophyUrl) {
        this.trophyUrl = trophyUrl;
    }

    public String getDateEarned() {
        return dateEarned;
    }

    public String getTrophyUrl() {
        return trophyUrl;
    }
}
