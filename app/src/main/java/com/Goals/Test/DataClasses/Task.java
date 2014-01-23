package com.Goals.Test.DataClasses;

import java.util.Calendar;

/**
 * Created by Drew on 1/14/14.
 */
public class Task {
    private int pkTask;
    private int fkGoal;
    private int fkUser;
    private int fkParentTask;
    private int recurringTask;
    private String dateCreated;
    private String dateCompleted;
    private String name;
    private String lastUpdated;

    public Task(){
        this.pkTask = 1;
        this.fkGoal = 1;
        this.fkUser = 1;
        this.fkParentTask = 1;
        this.recurringTask = 1;
        this.dateCreated = Calendar.getInstance().getTime().toString();
        this.dateCompleted = Calendar.getInstance().getTime().toString();
        this.name = "Testing task";
        this.lastUpdated = Calendar.getInstance().getTime().toString();
    }

    public Task(int pkTask, int fkGoal, int fkUser, int fkParentTask, int recurringTask, String dateCreated, String dateCompleted, String name, String lastUpdated)
    {
        this.pkTask = pkTask;
        this.fkGoal = fkGoal;
        this.fkUser = fkUser;
        this.fkParentTask = fkParentTask;
        this.recurringTask = recurringTask;
        this.dateCreated = dateCreated;
        this.dateCompleted = dateCompleted;
        this.name = name;
        this.lastUpdated = lastUpdated;
    }

    public String getName() {
        return name;
    }

    public void setDateCompleted(String dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setFkGoal(int fkGoal) {
        this.fkGoal = fkGoal;
    }

    public void setFkParentTask(int fkParentTask) {
        this.fkParentTask = fkParentTask;
    }

    public void setFkUser(int fkUser) {
        this.fkUser = fkUser;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPkTask(int pkTask) {
        this.pkTask = pkTask;
    }

    public void setRecurringTask(int recurringTask) {
        this.recurringTask = recurringTask;
    }

    public String getDateCompleted() {
        return dateCompleted;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public int getFkGoal() {
        return fkGoal;
    }

    public int getFkParentTask() {
        return fkParentTask;
    }

    public int getFkUser() {
        return fkUser;
    }

    public int getPkTask() {
        return pkTask;
    }

    public int getRecurringTask() {
        return recurringTask;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
