package com.Goals.Test.DataClasses;

/**
 * Created by Drew on 1/14/14.
 */
public class Note {
    private int pkNote;
    private int fkTask;
    private int fkUser;
    private String Text;
    private String dateCreated;
    private String lastUpdated;

    public Note(int pkNote, int fkTask, int fkUser, String noteText, String dateCreated, String lastUpdated)
    {
        this.pkNote = pkNote;
        this.fkTask = fkTask;
        this.fkUser = fkUser;
        this.Text = noteText;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }

    public int getFkUser() {
        return fkUser;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setFkTask(int fkGoal) {
        this.fkTask = fkGoal;
    }

    public void setFkUser(int fkUser) {
        this.fkUser = fkUser;
    }

    public void setNoteText(String noteText) {
        this.Text = noteText;
    }

    public void setPkNote(int pkNote) {
        this.pkNote = pkNote;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public int getFkTask() {
        return fkTask;
    }

    public int getPkNote() {
        return pkNote;
    }

    public String getNoteText() {
        return Text;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }
}
