package com.Goals.Test.DataClasses;

import java.util.Calendar;
import java.util.Random;

/**
 * Created by Drew on 1/14/14.
 */
public class Goal {
    private int pkGoal;
    private int fkUser;
    private String name;
    private String dateCreated;
    private String dateCompleted;
    private String endDate;
    private String lastUpdated;
    private int groupGoal;
    private int eventOrtime;
    private int numOfSubTasks;
    private int numOfCompletedTasks;
    private int numOfIncompleteTasks;
    private int stars;
    private int numOfEvents;

    public Goal()
    {
        //this.fkUser = user.getPkUser();
        this.name = "Lose weight";
        this.dateCreated = Calendar.getInstance().getTime().toString();
        this.dateCompleted = Calendar.getInstance().getTime().toString();
        this.endDate = Calendar.getInstance().getTime().toString();
        this.groupGoal = 0;
        this.eventOrtime = 1;
        this.numOfSubTasks = new Random(20).nextInt();
        this.numOfCompletedTasks = new Random(20).nextInt();
        this.numOfIncompleteTasks = new Random(20).nextInt();
        this.stars =  new Random(20).nextInt();
        this.numOfEvents =  new Random(20).nextInt();
        this.lastUpdated = Calendar.getInstance().getTime().toString();
    }

    public Goal(User user, String name, String dateCreated, String dateCompleted, String endDate, String lastUpdated, int groupGoal, int eventOrtime, int numOfSubTasks, int numOfCompletedTasks, int numOfIncompleteTasks, int stars, int numOfEvents)
    {
        this.fkUser = user.getPkUser();
        this.name = name;
        this.dateCreated = dateCreated;
        this.dateCompleted = dateCompleted;
        this.endDate = endDate;
        this.groupGoal = groupGoal;
        this.eventOrtime = eventOrtime;
        this.numOfSubTasks = numOfSubTasks;
        this.numOfCompletedTasks = numOfCompletedTasks;
        this.numOfIncompleteTasks = numOfIncompleteTasks;
        this.stars = stars;
        this.numOfEvents = numOfEvents;
        this.lastUpdated = lastUpdated;
    }

    public Goal(int fkUser, String name, String dateCreated, String dateCompleted, String endDate, String lastUpdated, int groupGoal, int eventOrtime, int numOfSubTasks, int numOfCompletedTasks, int numOfIncompleteTasks, int stars, int numOfEvents)
    {
        this.fkUser = fkUser;
        this.name = name;
        this.dateCreated = dateCreated;
        this.dateCompleted = dateCompleted;
        this.endDate = endDate;
        this.groupGoal = groupGoal;
        this.eventOrtime = eventOrtime;
        this.numOfSubTasks = numOfSubTasks;
        this.numOfCompletedTasks = numOfCompletedTasks;
        this.numOfIncompleteTasks = numOfIncompleteTasks;
        this.stars = stars;
        this.numOfEvents = numOfEvents;
        this.lastUpdated = lastUpdated;
    }

    public int getFkUser() {
        return fkUser;
    }

    public void setFkUser(int fkUser) {
        this.fkUser = fkUser;
    }

    public void setPkGoal(int pkGoal) {
        this.pkGoal = pkGoal;
    }

    public int getPkGoal() {
        return pkGoal;
    }

    public void setDateCompleted(String dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setEventOrtime(int eventOrtime) {
        this.eventOrtime = eventOrtime;
    }

    public void setGroupGoal(int groupGoal) {
        this.groupGoal = groupGoal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumOfCompletedTasks(int numOfCompletedTasks) {
        this.numOfCompletedTasks = numOfCompletedTasks;
    }

    public void setNumOfEvents(int numOfEvents) {
        this.numOfEvents = numOfEvents;
    }

    public void setNumOfIncompleteTasks(int numOfIncompleteTasks) {
        this.numOfIncompleteTasks = numOfIncompleteTasks;
    }

    public void setNumOfSubTasks(int numOfSubTasks) {
        this.numOfSubTasks = numOfSubTasks;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getDateCompleted() {
        return dateCompleted;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getEventOrtime() {
        return eventOrtime;
    }

    public int getGroupGoal() {
        return groupGoal;
    }

    public int getNumOfCompletedTasks() {
        return numOfCompletedTasks;
    }

    public int getNumOfEvents() {
        return numOfEvents;
    }

    public int getNumOfIncompleteTasks() {
        return numOfIncompleteTasks;
    }

    public int getNumOfSubTasks() {
        return numOfSubTasks;
    }

    public int getStars() {
        return stars;
    }

    public String getName() {
        return name;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }
}
