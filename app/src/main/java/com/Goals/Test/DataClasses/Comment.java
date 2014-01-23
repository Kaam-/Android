package com.Goals.Test.DataClasses;

/**
 * Created by Drew on 1/14/14.
 */
public class Comment {

    private int pkComment;
    private int fkGoal;
    private int fkUser;
    private String Text;
    private String dateCreated;
    private String lastUpdated;

    public Comment(int pkComment, int fkGoal, int fkUser, String commentText, String dateCreated, String lastUpdated)
    {
        this.pkComment = pkComment;
        this.fkGoal = fkGoal;
        this.fkUser = fkUser;
        this.Text = commentText;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }

    public int getFkGoal() {
        return fkGoal;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setCommentText(String commentText) {
        this.Text = commentText;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setFkGoal(int fkGoal) {
        this.fkGoal = fkGoal;
    }

    public void setFkUser(int fkUser) {
        this.fkUser = fkUser;
    }

    public void setPkComment(int pkComment) {
        this.pkComment = pkComment;
    }

    public int getFkUser() {
        return fkUser;
    }

    public int getPkComment() {
        return pkComment;
    }

    public String getCommentText() {
        return Text;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
