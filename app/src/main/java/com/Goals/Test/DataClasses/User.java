package com.Goals.Test.DataClasses;

import java.util.Calendar;

/**
 * Created by Drew on 1/14/14.
 */
public class User {
    private int pkUser;
    private String firstName;
    private String lastName;
    private	String imageLocation;
    private String username;
    private String password;
    private String email;
    private int starCount;
    private int starsEarned;
    private int starsSpent;
    private String dateCreated;
    private String lastUpdated;

    public User()
    {
        this.firstName = "Test";
        this.lastName = "Dummy";
        this.imageLocation = "user/local/files";
        this.username = "fancyPants1989";
        this.password = "underoath1";
        this.email = "aer10f.ar@gmail.com";
        this.starCount = 5;
        this.starsEarned = 30;
        this.starsSpent = 10;
        this.dateCreated = Calendar.getInstance().getTime().toString();
        this.lastUpdated = Calendar.getInstance().getTime().toString();
    }

    public User(int pkUser, String firstName, String lastName, String imageLocation, String username, String password, String email, int starCount, int starsEarned, int starsSpent, String dateCreated, String lastUpdated)
    {
        this.pkUser = pkUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageLocation = imageLocation;
        this.username = username;
        this.password = password;
        this.email = email;
        this.starCount = starCount;
        this.starsEarned =starsEarned;
        this.starsSpent = starsSpent;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }

    public User(String firstName, String lastName, String imageLocation, String username, String password, String email, int starCount, int starsEarned, int starsSpent, String dateCreated, String lastUpdated)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageLocation = imageLocation;
        this.username = username;
        this.password = password;
        this.email = email;
        this.starCount = starCount;
        this.starsEarned =starsEarned;
        this.starsSpent = starsSpent;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }

    public void setPkUser(int pkUser) {
        this.pkUser = pkUser;
    }

    public int getPkUser() {
        return pkUser;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public void setStarsEarned(int starsEarned) {
        this.starsEarned = starsEarned;
    }

    public void setStarsSpent(int starsSpent) {
        this.starsSpent = starsSpent;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public int getStarCount() {
        return starCount;
    }

    public int getStarsEarned() {
        return starsEarned;
    }

    public int getStarsSpent() {
        return starsSpent;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }
}
