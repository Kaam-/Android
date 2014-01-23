package com.Goals.Test.SteveTheFetcher;

import android.content.Context;
import android.util.Log;

import com.Goals.Test.DataClasses.Goal;
import com.Goals.Test.DataClasses.User;
import com.Goals.Test.DatabaseClasses.DatabaseHandler;

/**
 * Created by Drew on 1/16/14.
 */
public class Fetcher {

    private DatabaseHandler db;

    public Fetcher(Context context){
        db = new DatabaseHandler(context);
    }

    public User setUser(User user){
        User returnUser = new User();
        try
        {
            returnUser = db.addUser(user);
        }
        catch (Exception e)
        {
            Log.e("Fetcher", "Error: " + e.toString());
            return null;
        }
        finally{
            return returnUser;
        }
    }

    public User getUser(String email)
    {
        return db.getUserByEmail(email);
    }
    /*public boolean setGoals(Goal[] goals)
    public boolean setTasks(Task[] tasks)
    public boolean setComments(Comment[] comments)
    public boolean setNotes(Note[] notes)
    public boolean setTrophies(Trophy[] trophies)
    public boolean setStickers(Sticker[] stickers)*/

    public boolean setGoal(Goal goal, User user)
    {
        try{
            db.addGoal(goal, user);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    /*public boolean setTask(Task task)
    public boolean setComment(Comment comment)
    public boolean setNote(Note note)
    public boolean setTrophy(Trophy trophy)
    public boolean setSticker(Sticker sticker)

    public boolean getUser()
    public boolean getGoal()
    public boolean getTask()
    public boolean getComment()
    public boolean getNote()
    public boolean getTrophie()
    public boolean getSticker()

    public boolean getGoals()
    public boolean getTasks()
    public boolean getComments()
    public boolean getNotes()
    public boolean getTrophies()
    public boolean getStickers()*/
}
