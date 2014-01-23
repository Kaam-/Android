package com.Goals.Test.DatabaseClasses;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import com.Goals.Test.DataClasses.User;
import com.Goals.Test.DataClasses.Goal;
import com.Goals.Test.DataClasses.Note;
import com.Goals.Test.DataClasses.Sticker;
import com.Goals.Test.DataClasses.Task;
import com.Goals.Test.DataClasses.Trophy;
import com.Goals.Test.DataClasses.Comment;


/**
 * Created by Drew on 1/14/14.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "TaskAppDatabase";

    // Table names
    private static final String TABLE_USERS = "Users";
    private static final String TABLE_GOALS = "Goals";
    private static final String TABLE_TASKS = "Tasks";
    private static final String TABLE_COMMENTS = "Comments";
    private static final String TABLE_NOTES = "Notes";
    private static final String TABLE_TROPHIES = "Trophies";
    private static final String TABLE_STICKER = "Stickers";
    private static final String TABLE_TROPHYTOGOAL = "TrophyToGoal";
    private static final String TABLE_STICKERTOUSER = "StickerToUser";

    // Users Table Columns names
    private static final String[] PKUSER = {"pkUser", " INTEGER PRIMARY KEY,"};
    private static final String[] USERSFIRSTNAME = {"FirstName", " TEXT,"};
    private static final String[] USERSLASTNAME = {"LastName", " TEXT,"};
    private static final String[] USERSAVATARURL = {"AvatarURL", " TEXT,"};
    private static final String[] USERSUSERNAME = {"Username", " TEXT,"};
    private static final String[] USERSPASSWORD = {"Password", " TEXT,"};
    private static final String[] USERSEMAIL = {"Email", " TEXT"};
    private static final String[] USERSSTARCOUNT = {"StarCount", " INTEGER,"};
    private static final String[] USERSSTARSEARNED = {"StarsEarned", " INTEGER,"};
    private static final String[] USERSSTARSSPENT = {"StarsSpent", " INTEGER,"};
    private static final String[] USERSDATECREATED = {"DateCreated", " TEXT,"};
    private static final String[] USERSLASTUPDATED = {"LastUpdated", " TEXT"};

    // Goals Table Columns names
    private static final String[] PKGOAL = {"pkGoal", " INTEGER PRIMARY KEY,"};
    private static final String[] GOALFKUSER = {"fkUser", " INTEGER,"};
    private static final String[] GOALNAME = {"Name", " TEXT"};
    private static final String[] GOALDATECREATED = {"DateCreated", " TEXT,"};
    private static final String[] GOALENDDATE = {"EndDate", " TEXT,"};
    private static final String[] GOALDATECOMPLETED = {"DateCompleted", " TEXT,"};
    private static final String[] GROUPGOAL = {"GroupGoal", " INTEGER,"};
    private static final String[] GOALEVENTORTIME = {"EventOrTime", " INTEGER,"};
    private static final String[] GOALNUMOFSUBTASKS = {"NumOfSubTasks", " INTEGER,"};
    private static final String[] GOALCOMPLETEDTASKS = {"CompletedTasks", " INTEGER,"};
    private static final String[] GOALINCOMPLETETASKS = {"IncompleteTasks", " INTEGER,"};
    private static final String[] GOALSTARS = {"Stars", " INTEGER,"};
    private static final String[] GOALNUMOFEVENTS = {"NumOfEvents", " INTEGER,"};
    private static final String[] GOALLASTUPDATED = {"LastUpdated", " TEXT,"};

    // Tasks Table Columns names
    private static final String[] PKTASK = {"pkTask", " INTEGER PRIMARY KEY,"};
    private static final String[] TASKFKGOAL = {"fkGoal", " INTEGER,"};
    private static final String[] TASKFKUSER = {"fkUser", " INTEGER,"};
    private static final String[] TASKFKPARENTTASK = {"fkParentTask", " INTEGER,"};
    private static final String[] TASKNAME = {"Name", " TEXT,"};
    private static final String[] TASKRECURRINGTASK = {"RecurringTask", " INTEGER,"};
    private static final String[] TASKDATECREATED = {"DateCreated", " TEXT,"};
    private static final String[] TASKDATECOMPLETED = {"DateCompleted", " TEXT,"};
    private static final String[] TASKLASTUPDATED = {"LastUpdated", " TEXT,"};

    // Comments Table Columns names
    private static final String[] PKCOMMENT = {"pkComment", " INTEGER PRIMARY KEY,"};
    private static final String[] COMMENTFKGOAL = {"fkGoal", " INTEGER,"};
    private static final String[] COMMENTFKUSER = {"fkUser", " INTEGER,"};
    private static final String[] COMMENTTEXT = {"CommentText", " TEXT,"};
    private static final String[] COMMENTDATECREATED = {"DateCreated", " TEXT,"};
    private static final String[] COMMENTLASTUPDATED = {"LastUpdated", " TEXT,"};

    // Notes Table Columns names
    private static final String[] PKNOTE = {"pkNote", " INTEGER PRIMARY KEY,"};
    private static final String[] NOTEFKTASK = {"fkTask", " INTEGER,"};
    private static final String[] NOTEFKUSER = {"fkUser", " INTEGER,"};
    private static final String[] NOTETEXT = {"NoteText", " TEXT,"};
    private static final String[] NOTEDATECREATED = {"DateCreated", " TEXT,"};
    private static final String[] NOTELASTUPDATED = {"LastUpdated", " TEXT,"};

    // Trophies Table Columns names
    private static final String[] PKTROPHY = {"pkTrophy", " INTEGER PRIMARY KEY,"};
    private static final String[] TROPHYNAME = {"Name", " TEXT,"};
    private static final String[] TROPHYURL = {"TrophyURL", " TEXT"};

    // Stickers Table Columns names
    private static final String[] PKSTICKER = {"pkSticker", " INTEGER PRIMARY KEY,"};
    private static final String[] STICKERNAME = {"Name", " TEXT,"};
    private static final String[] STICKERURL = {"StickerURL", " TEXT"};

    // TrophyToGoal Table Columns names
    private static final String[] TTGFKTROPHY = {"fkTrophy", " INTEGER,"};
    private static final String[] TTGFKGOAL = {"fkGoal", " INTEGER,"};
    private static final String[] TTGFKUSER = {"fkUser", " INTEGER,"};
    private static final String[] TTGDATEEARNED = {"DateEarned", " TEXT,"};

    // StickerToUser Table Columns names
    private static final String[] STUFKSTICKER = {"fkSticker", " INTEGER,"};
    private static final String[] STUFKGIVINGUSER = {"fkGivingUser", " INTEGER,"};
    private static final String[] STUFKRECEIVINGUSER = {"fkReceivingUser", " INTEGER,"};
    private static final String[] STUDATERECEIVED = {"DateReceived", " TEXT,"};

    // Create User Table String
    private String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
            + PKUSER[0] + PKUSER[1]
            + USERSFIRSTNAME[0] + USERSFIRSTNAME[1]
            + USERSLASTNAME[0] + USERSLASTNAME[1]
            + USERSAVATARURL[0] + USERSAVATARURL[1]
            + USERSUSERNAME[0] + USERSUSERNAME[1]
            + USERSPASSWORD[0] + USERSPASSWORD[1]
            + USERSEMAIL[0] + USERSEMAIL[1] + " UNIQUE,"
            + USERSSTARCOUNT[0] + USERSSTARCOUNT[1]
            + USERSSTARSEARNED[0] + USERSSTARSEARNED[1]
            + USERSSTARSSPENT[0] + USERSSTARSSPENT[1]
            + USERSDATECREATED[0] + USERSDATECREATED[1]
            + USERSLASTUPDATED[0] + USERSLASTUPDATED[1] + ")";

    // Create Goals Table String
    private String CREATE_GOALS_TABLE = "CREATE TABLE " + TABLE_GOALS + "("
            + PKGOAL[0] + PKGOAL[1]
            + GOALFKUSER[0] + GOALFKUSER[1]
            + GOALNAME[0] + GOALNAME[1] + " UNIQUE,"
            + GOALDATECREATED[0] + GOALDATECREATED[1]
            + GOALENDDATE[0] + GOALENDDATE[1]
            + GOALDATECOMPLETED[0] + GOALDATECOMPLETED[1]
            + GROUPGOAL[0] + GROUPGOAL[1]
            + GOALEVENTORTIME[0] + GOALEVENTORTIME[1]
            + GOALNUMOFSUBTASKS[0] + GOALNUMOFSUBTASKS[1]
            + GOALCOMPLETEDTASKS[0] + GOALCOMPLETEDTASKS[1]
            + GOALINCOMPLETETASKS[0] + GOALINCOMPLETETASKS[1]
            + GOALSTARS[0] + GOALSTARS[1]
            + GOALNUMOFEVENTS[0] + GOALNUMOFEVENTS[1]
            + GOALLASTUPDATED[0] + GOALLASTUPDATED[1]
            + " FOREIGN KEY(" + GOALFKUSER[0] + ") REFERENCES " + TABLE_USERS + "(" + PKUSER[0] + ")" + ")";

    // Create Tasks Table String
    private String CREATE_TASKS_TABLE = "CREATE TABLE " + TABLE_TASKS + "("
            + PKTASK[0] + PKTASK[1]
            + TASKFKGOAL[0] + TASKFKGOAL[1]
            + TASKFKUSER[0] + TASKFKUSER[1]
            + TASKFKPARENTTASK[0] + TASKFKPARENTTASK[1]
            + TASKNAME[0] + TASKNAME[1]
            + TASKRECURRINGTASK[0] + TASKRECURRINGTASK[1]
            + TASKDATECREATED[0] + TASKDATECREATED[1]
            + TASKDATECOMPLETED[0] + TASKDATECOMPLETED[1]
            + TASKLASTUPDATED[0] + TASKLASTUPDATED[1]
            + " FOREIGN KEY(" + TASKFKGOAL[0] + ") REFERENCES " + TABLE_GOALS + "(" + PKGOAL[0] + ")"
            + " FOREIGN KEY(" + TASKFKUSER[0] + ") REFERENCES " + TABLE_USERS + "(" + PKUSER[0] + ")" + ")";

    // Create Comments Table String
    private String CREATE_COMMENTS_TABLE = "CREATE TABLE " + TABLE_COMMENTS + "("
            + PKCOMMENT[0] + PKCOMMENT[1]
            + COMMENTFKGOAL[0] + COMMENTFKGOAL[1]
            + COMMENTFKUSER[0] + COMMENTFKUSER[1]
            + COMMENTTEXT[0] + COMMENTTEXT[1]
            + COMMENTDATECREATED[0] + COMMENTDATECREATED[1]
            + COMMENTLASTUPDATED[0] + COMMENTLASTUPDATED[1]
            + "FOREIGN KEY(" + COMMENTFKGOAL[0] + ") REFERENCES " + TABLE_GOALS + "(" + PKGOAL[0] + ")"
            + "FOREIGN KEY(" + COMMENTFKUSER[0] + ") REFERENCES " + TABLE_USERS + "(" + PKUSER[0] + ")" + ")";

    // Create Notes Table String
    private String CREATE_NOTES_TABLE = "CREATE TABLE " + TABLE_NOTES + "("
            + PKNOTE[0] + PKNOTE[1]
            + NOTEFKTASK[0] + NOTEFKTASK[1]
            + NOTEFKUSER[0] + NOTEFKUSER[1]
            + NOTETEXT[0] + NOTETEXT[1]
            + NOTEDATECREATED[0] + NOTEDATECREATED[1]
            + NOTELASTUPDATED[0] + NOTELASTUPDATED[1]
            + " FOREIGN KEY(" + NOTEFKTASK[0] + ") REFERENCES " + TABLE_TASKS + "(" + PKTASK[0] + ")"
            + " FOREIGN KEY(" + NOTEFKUSER[0] + ") REFERENCES " + TABLE_USERS + "(" + PKUSER[0] + ")" + ")";

    // Create Trophies Table String
    private String CREATE_TROPHIES_TABLE = "CREATE TABLE " + TABLE_TROPHIES + "("
            + PKTROPHY[0] + PKTROPHY[1]
            + TROPHYNAME[0] + TROPHYNAME[1]
            + TROPHYURL[0] + TROPHYURL[1] + ")";

    // Create Stickers Table String
    private String CREATE_STICKERS_TABLE = "CREATE TABLE " + TABLE_STICKER + "("
            + PKSTICKER[0] + PKSTICKER[1]
            + STICKERNAME[0] + STICKERNAME[1]
            + STICKERURL[0] + STICKERURL[1] + ")";

    // Create Trophy to Goal Table String
    private String CREATE_TROPHYTOGOAL_TABLE = "CREATE TABLE " + TABLE_TROPHYTOGOAL + "("
            + TTGFKTROPHY[0] + TTGFKTROPHY[1]
            + TTGFKGOAL[0] + TTGFKGOAL[1]
            + TTGFKUSER[0] + TTGFKUSER[1]
            + TTGDATEEARNED[0] + TTGDATEEARNED[1]
            + " FOREIGN KEY(" + TTGFKTROPHY[0] + ") REFERENCES " + TABLE_TROPHIES + "(" + PKTROPHY[0] + ")"
            + " FOREIGN KEY(" + TTGFKGOAL[0] + ") REFERENCES " + TABLE_GOALS + "(" + PKGOAL[0] + ")"
            + " FOREIGN KEY(" + TTGFKUSER[0] + ") REFERENCES " + TABLE_USERS + "(" + PKUSER[0] + ")" + ")";

    // Create Sticker to User Table String
    private String CREATE_STICKERTOUSER_TABLE = "CREATE TABLE " + TABLE_STICKERTOUSER + "("
            + STUFKSTICKER[0] + STUFKSTICKER[1]
            + STUFKGIVINGUSER[0] + STUFKGIVINGUSER[1]
            + STUFKRECEIVINGUSER[0] + STUFKRECEIVINGUSER[1]
            + STUDATERECEIVED[0] + STUDATERECEIVED[1]
            + " FOREIGN KEY(" + STUFKSTICKER[0] + ") REFERENCES " + TABLE_STICKER + "(" + PKSTICKER[0] + ")"
            + " FOREIGN KEY(" + STUFKGIVINGUSER[0] + ") REFERENCES " + TABLE_USERS + "(" + PKUSER[0] + ")"
            + " FOREIGN KEY(" + STUFKRECEIVINGUSER[0] + ") REFERENCES " + TABLE_USERS + "(" + PKUSER[0] + ")" + ")";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();
        try{
            Log.d("Database", "Creating Databases: " + db.toString());
            db.execSQL(CREATE_USERS_TABLE);
            db.execSQL(CREATE_GOALS_TABLE);
            db.execSQL(CREATE_TASKS_TABLE);
            db.execSQL(CREATE_COMMENTS_TABLE);
            db.execSQL(CREATE_NOTES_TABLE);
            db.execSQL(CREATE_TROPHIES_TABLE);
            db.execSQL(CREATE_STICKERS_TABLE);
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
        }
        finally{
            db.endTransaction();
        }
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.beginTransaction();
        try{
            Log.d("Database", "Dropping tables for update");
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_GOALS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_TROPHIES);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_STICKER);

            // Create tables again
            Log.d("Database", "Recreating tables again for upgrade");
            onCreate(db);
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            db.endTransaction();
        }
    }

    /*
    * USER DATABASE FUNCTIONS
    */
    public User addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try{
            Log.d("Database", "Adding user");
            ContentValues values = new ContentValues();
            values.put(USERSFIRSTNAME[0], user.getFirstName());
            values.put(USERSLASTNAME[0], user.getLastName());
            values.put(USERSAVATARURL[0], user.getImageLocation());
            values.put(USERSUSERNAME[0], user.getUsername());
            values.put(USERSPASSWORD[0], user.getPassword());
            values.put(USERSEMAIL[0], user.getEmail());
            values.put(USERSSTARCOUNT[0], user.getStarCount());
            values.put(USERSSTARSEARNED[0], user.getStarsEarned());
            values.put(USERSSTARSSPENT[0], user.getStarsSpent());
            values.put(USERSDATECREATED[0], user.getDateCreated().toString());
            values.put(USERSLASTUPDATED[0], user.getLastUpdated().toString());

            db.insert(TABLE_USERS, null, values);
            db.setTransactionSuccessful();
        }
        catch (Exception e){
            Log.e("Database", "Error: " + e.toString());
            return null;
        }
        finally {
            db.endTransaction();
            return getUserByEmail(user.getEmail());
        }
    }

    public boolean updateUser(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try{
            Log.d("Database", "Updating user: " + user.getPkUser());
            ContentValues values = new ContentValues();
            values.put(USERSFIRSTNAME[0], user.getFirstName());
            values.put(USERSLASTNAME[0], user.getLastName());
            values.put(USERSAVATARURL[0], user.getImageLocation());
            values.put(USERSUSERNAME[0], user.getUsername());
            values.put(USERSPASSWORD[0], user.getPassword());
            values.put(USERSEMAIL[0], user.getEmail());
            values.put(USERSSTARCOUNT[0], user.getStarCount());
            values.put(USERSSTARSEARNED[0], user.getStarsEarned());
            values.put(USERSSTARSSPENT[0], user.getStarsSpent());
            values.put(USERSDATECREATED[0], user.getDateCreated().toString());
            values.put(USERSLASTUPDATED[0], user.getLastUpdated().toString());

            db.update(TABLE_USERS, values, USERSEMAIL[0] + " =? ", new String[] { String.valueOf(user.getEmail()) });
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return false;
        }
        finally{
            db.endTransaction();
            return true;
        }
    }

    public boolean deleteUser(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try{
            Log.d("Database", "Deleting user: " + user.getPkUser());
            db.delete(TABLE_USERS, USERSEMAIL[0] + " = ?",
                    new String[] { String.valueOf(user.getEmail()) });

            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return false;
        }
        finally{
            db.endTransaction();
            return true;
        }
    }

    public User getUser(String username)
    {
        String getUserQuery = "SELECT * FROM " + TABLE_USERS + " WHERE " + USERSUSERNAME[0] + " = " + "'" + username + "'";
        List<User> users = new ArrayList<User>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try{
            Log.d("Database", "Getting user with username: " + username);
            Cursor cursor = db.rawQuery(getUserQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    User user = new User(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                            cursor.getString(5), cursor.getString(6), Integer.parseInt(cursor.getString(7)), Integer.parseInt(cursor.getString(8)),
                            Integer.parseInt(cursor.getString(9)), cursor.getString(10), cursor.getString(11));

                    // Adding contact to list
                    users.add(user);
                } while (cursor.moveToNext());
            }
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return null;
        }
        finally{
            db.endTransaction();
            return users.get(0);
        }
    }

    public User getUserByEmail(String email)
    {
        String getUserQuery = "SELECT * FROM " + TABLE_USERS + " WHERE " + USERSEMAIL[0] + " = " + "'" + email + "'";
        List<User> users = new ArrayList<User>();
        SQLiteDatabase db = this.getReadableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Getting user with email: " + email);
            Cursor cursor = db.rawQuery(getUserQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    User user = new User(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                            cursor.getString(5), cursor.getString(6), Integer.parseInt(cursor.getString(7)), Integer.parseInt(cursor.getString(8)),
                            Integer.parseInt(cursor.getString(9)), cursor.getString(10), cursor.getString(11));

                    // Adding contact to list
                    users.add(user);
                } while (cursor.moveToNext());
            }
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return null;
        }
        finally{
            db.endTransaction();
            return users.get(0);
        }
    }

    public List<User> getAllUsers()
    {
        String getAllUsersQuery = "SELECT * FROM " + TABLE_USERS;
        List<User> users = new ArrayList<User>();
        SQLiteDatabase db = this.getReadableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Getting all users");
            Cursor cursor = db.rawQuery(getAllUsersQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    User user = new User(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                            cursor.getString(5), cursor.getString(6), Integer.parseInt(cursor.getString(7)), Integer.parseInt(cursor.getString(8)),
                            Integer.parseInt(cursor.getString(9)), cursor.getString(10), cursor.getString(11));

                    // Adding contact to list
                    users.add(user);
                } while (cursor.moveToNext());
            }
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return null;
        }
        finally{
            db.endTransaction();
            return users;
        }
    }

    /*
    * GOALS DATABASE FUNCTIONS
    */
    public Goal addGoal(Goal goal, User user){
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Adding Goal for user: " + user.getPkUser());
            ContentValues values = new ContentValues();
            values.put(GOALFKUSER[0], user.getPkUser());
            values.put(GOALNAME[0], goal.getName());
            values.put(GOALDATECREATED[0], goal.getDateCreated());
            values.put(GOALENDDATE[0], goal.getEndDate());
            values.put(GOALDATECOMPLETED[0], goal.getDateCompleted());
            values.put(GROUPGOAL[0], goal.getGroupGoal());
            values.put(GOALEVENTORTIME[0], goal.getEventOrtime());
            values.put(GOALNUMOFSUBTASKS[0], goal.getNumOfSubTasks());
            values.put(GOALCOMPLETEDTASKS[0], goal.getNumOfCompletedTasks());
            values.put(GOALINCOMPLETETASKS[0], goal.getNumOfIncompleteTasks());
            values.put(GOALSTARS[0], goal.getStars());
            values.put(GOALNUMOFEVENTS[0], goal.getNumOfEvents());
            values.put(GOALLASTUPDATED[0], goal.getLastUpdated());

            db.insert(TABLE_GOALS, null, values);
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return null;
        }
        finally{
            db.endTransaction();
            return getGoal(goal);
        }
    }

    public boolean updateGoal(Goal goal)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Updating Goal: " + goal.getPkGoal());
            ContentValues values = new ContentValues();
            values.put(GOALFKUSER[0], goal.getFkUser());
            values.put(GOALNAME[0], goal.getName());
            values.put(GOALDATECREATED[0], goal.getDateCreated().toString());
            values.put(GOALENDDATE[0], goal.getEndDate().toString());
            values.put(GOALDATECOMPLETED[0], goal.getDateCompleted().toString());
            values.put(GROUPGOAL[0], goal.getGroupGoal());
            values.put(GOALEVENTORTIME[0], goal.getEventOrtime());
            values.put(GOALNUMOFSUBTASKS[0], goal.getNumOfSubTasks());
            values.put(GOALCOMPLETEDTASKS[0], goal.getNumOfCompletedTasks());
            values.put(GOALINCOMPLETETASKS[0], goal.getNumOfIncompleteTasks());
            values.put(GOALSTARS[0], goal.getStars());
            values.put(GOALNUMOFEVENTS[0], goal.getNumOfEvents());
            values.put(GOALLASTUPDATED[0], goal.getLastUpdated().toString());

            db.update(TABLE_GOALS, values, GOALNAME[0] + " =? ", new String[] { String.valueOf(goal.getName()) });
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return false;
        }
        finally{
            db.endTransaction();
            return true;
        }
    }

    public boolean deleteGoal(Goal goal)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Deleting Goal: " + goal.getPkGoal());
            db.delete(TABLE_GOALS, PKGOAL[0] + " = ?",
                    new String[] { String.valueOf(goal.getPkGoal()) });

            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return false;
        }
        finally{
            db.endTransaction();
            return true;
        }
    }

    public Goal getGoal(Goal goal)
    {
        String getGoalQuery = "SELECT * FROM " + TABLE_GOALS + " WHERE " + GOALNAME[0] + " = " + "'" + goal.getName() + "'" + " ORDER BY " + GOALDATECREATED[0] + " DESC";
        List<Goal> goals = new ArrayList<Goal>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Getting goal with name: " + goal.getName());
            Cursor cursor = db.rawQuery(getGoalQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    Goal goalFound = new Goal(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                            cursor.getString(5), Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)), Integer.parseInt(cursor.getString(8)),
                            Integer.parseInt(cursor.getString(9)), Integer.parseInt(cursor.getString(10)), Integer.parseInt(cursor.getString(11)), Integer.parseInt(cursor.getString(12)));

                    // Adding contact to list
                    goals.add(goalFound);
                } while (cursor.moveToNext());
            }
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return null;
        }
        finally{
            db.endTransaction();
            return goals.get(0);
        }
    }

    public List<Goal> getAllGoalsForUser(User user)
    {
        String getAllGoalsQuery = "SELECT * FROM " + TABLE_GOALS + " WHERE " + GOALFKUSER[0] + " = " + "'" + user.getPkUser() + "'";
        List<Goal> goals = new ArrayList<Goal>();
        SQLiteDatabase db = this.getReadableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Getting all goals for user: " + user.getPkUser());
            Cursor cursor = db.rawQuery(getAllGoalsQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    Goal goal = new Goal(user, cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                            cursor.getString(5), Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)), Integer.parseInt(cursor.getString(8)),
                            Integer.parseInt(cursor.getString(9)), Integer.parseInt(cursor.getString(10)), Integer.parseInt(cursor.getString(11)), Integer.parseInt(cursor.getString(12)));

                    // Adding contact to list
                    goals.add(goal);
                } while (cursor.moveToNext());
            }
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return null;
        }
        finally{
            db.endTransaction();
            return goals;
        }
    }

    /*
    * TASKS DATABASE FUNCTIONS
    */
    public Task addTask(Task task){
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Adding a task");
            ContentValues values = new ContentValues();
            values.put(TASKFKGOAL[0], task.getFkGoal());
            values.put(TASKFKUSER[0], task.getFkUser());
            values.put(TASKFKPARENTTASK[0], task.getFkParentTask());
            values.put(TASKRECURRINGTASK[0], task.getRecurringTask());
            values.put(TASKDATECREATED[0], task.getDateCreated().toString());
            values.put(TASKDATECOMPLETED[0], task.getDateCompleted().toString());
            values.put(TASKNAME[0], task.getName());
            values.put(TASKLASTUPDATED[0], task.getLastUpdated().toString());

            db.insert(TABLE_TASKS, null, values);
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return null;
        }
        finally{
            db.endTransaction();
            return getTask(task);
        }
    }

    public boolean updateTask(Task task)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Updating task: " + task.getPkTask());
            ContentValues values = new ContentValues();
            values.put(PKTASK[0], task.getPkTask());
            values.put(TASKFKGOAL[0], task.getFkGoal());
            values.put(TASKFKUSER[0], task.getFkUser());
            values.put(TASKFKPARENTTASK[0], task.getFkParentTask());
            values.put(TASKRECURRINGTASK[0], task.getRecurringTask());
            values.put(TASKDATECREATED[0], task.getDateCreated().toString());
            values.put(TASKDATECOMPLETED[0], task.getDateCompleted().toString());
            values.put(TASKNAME[0], task.getName());
            values.put(TASKLASTUPDATED[0], task.getLastUpdated().toString());

            db.update(TABLE_TASKS, values, PKTASK[0] + " =? ", new String[] { String.valueOf(task.getPkTask()) });
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return false;
        }
        finally{
            db.endTransaction();
            return true;
        }
    }

    public boolean deleteTask(Task task)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try{
            Log.d("Database", "Deleting task: " + task.getPkTask());
            db.delete(TABLE_TASKS, PKTASK[0] + " =?",
                    new String[] { String.valueOf(task.getPkTask()) });

            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return false;
        }
        finally{
            db.endTransaction();
            return true;
        }
    }

    public Task getTask(Task task)
    {
        String getAllTasksQuery = "SELECT * FROM " + TABLE_TASKS + " WHERE " + TASKNAME[0] + " = " + task.getName() + " ORDER BY " + TASKDATECREATED[0] + " DESC";
        List<Task> tasks = new ArrayList<Task>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Getting task with name: " + task.getName());
            Cursor cursor = db.rawQuery(getAllTasksQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    Task taskNew = new Task(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)),
                            Integer.parseInt(cursor.getString(4)), cursor.getString(5), cursor.getString(6), cursor.getString(7),
                            cursor.getString(8));

                    // Adding contact to list
                    tasks.add(taskNew);
                } while (cursor.moveToNext());
            }
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return null;
        }
        finally {
            db.endTransaction();
            return tasks.get(0);
        }
    }

    public List<Task> getAllTasks(Goal goal)
    {
        String getAllTasksQuery = "SELECT * FROM " + TABLE_TASKS + " WHERE " + TASKFKGOAL[0] + " = " + goal.getPkGoal();
        List<Task> tasks = new ArrayList<Task>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Getting all tasks");
            Cursor cursor = db.rawQuery(getAllTasksQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    Task task = new Task(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)),
                            Integer.parseInt(cursor.getString(4)), cursor.getString(5), cursor.getString(6), cursor.getString(7),
                            cursor.getString(8));

                    // Adding contact to list
                    tasks.add(task);
                } while (cursor.moveToNext());
            }
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return null;
        }
        finally {
            db.endTransaction();
            return tasks;
        }
    }

    /*
    * COMMENTS DATABASE FUNCTIONS
    */
    public boolean addComment(Comment comment){
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Adding a comment to goal: " + comment.getFkGoal());
            ContentValues values = new ContentValues();
            values.put(PKCOMMENT[0], comment.getPkComment());
            values.put(COMMENTFKGOAL[0], comment.getFkGoal());
            values.put(COMMENTFKUSER[0], comment.getFkUser());
            values.put(COMMENTTEXT[0], comment.getCommentText());
            values.put(COMMENTDATECREATED[0], comment.getDateCreated().toString());
            values.put(COMMENTLASTUPDATED[0], comment.getLastUpdated().toString());

            db.insert(TABLE_COMMENTS, null, values);
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return false;
        }
        finally{
            db.endTransaction();
            return true;
        }
    }

    public boolean updateComment(Comment comment)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Updating comment: " + comment.getPkComment());
            ContentValues values = new ContentValues();
            values.put(PKCOMMENT[0], comment.getPkComment());
            values.put(COMMENTFKGOAL[0], comment.getFkGoal());
            values.put(COMMENTFKUSER[0], comment.getFkUser());
            values.put(COMMENTTEXT[0], comment.getCommentText());
            values.put(COMMENTDATECREATED[0], comment.getDateCreated().toString());
            values.put(COMMENTLASTUPDATED[0], comment.getLastUpdated().toString());

            db.update(TABLE_COMMENTS, values, PKCOMMENT[0] + " =? ", new String[] { String.valueOf(comment.getPkComment()) });
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return false;
        }
        finally{
            db.endTransaction();
            return true;
        }
    }

    public boolean deleteComment(Comment comment)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try{
            Log.d("Database", "Deteling comment: " + comment.getPkComment());
            db.delete(TABLE_COMMENTS, PKCOMMENT[0] + " =? ",
                    new String[] { String.valueOf(comment.getPkComment()) });

            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return false;
        }
        finally{
            db.endTransaction();
            return true;
        }
    }

    public Comment getComment(Comment comment)
    {
        String getAllCommentsQuery = "SELECT * FROM " + TABLE_COMMENTS + " WHERE " + COMMENTTEXT[0] + " = " + comment.getCommentText() + " ORDER BY " + COMMENTDATECREATED[0] + " DESC";
        List<Comment> comments = new ArrayList<Comment>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Getting comment with text: " + comment.getCommentText());
            Cursor cursor = db.rawQuery(getAllCommentsQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    Comment commentNew = new Comment(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)), cursor.getString(3),
                            cursor.getString(4), cursor.getString(5));

                    // Adding contact to list
                    comments.add(commentNew);
                } while (cursor.moveToNext());
            }
            db.setTransactionSuccessful();
        }
        catch (Exception e){
            Log.e("Database", "Error: " + e.toString());
            return null;
        }
        finally{
            db.endTransaction();
            return comments.get(0);
        }
    }

    public List<Comment> getAllComments(Goal goal)
    {
        String getAllCommentsQuery = "SELECT * FROM " + TABLE_COMMENTS + " WHERE " + COMMENTFKGOAL[0] + " = " + goal.getPkGoal();
        List<Comment> comments = new ArrayList<Comment>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Getting all comments for goal: " + goal.getPkGoal());
            Cursor cursor = db.rawQuery(getAllCommentsQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    Comment comment = new Comment(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)), cursor.getString(3),
                            cursor.getString(4), cursor.getString(5));

                    // Adding contact to list
                    comments.add(comment);
                } while (cursor.moveToNext());
            }
            db.setTransactionSuccessful();
        }
        catch (Exception e){
            Log.e("Database", "Error: " + e.toString());
            return null;
        }
        finally{
            db.endTransaction();
            return comments;
        }
    }

    /*
    * NOTES DATABASE FUNCTIONS
    */
    public boolean addNote(Note note){
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Adding note to task: " + note.getFkTask());
            ContentValues values = new ContentValues();
            values.put(NOTEFKTASK[0], note.getFkTask());
            values.put(NOTEFKUSER[0], note.getFkUser());
            values.put(NOTETEXT[0], note.getNoteText());
            values.put(NOTEDATECREATED[0], note.getDateCreated().toString());
            values.put(NOTELASTUPDATED[0], note.getLastUpdated().toString());

            db.insert(TABLE_NOTES, null, values);
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return false;
        }
        finally{
            db.endTransaction();
            return true;
        }
    }

    public boolean updateNote(Note note)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Updating note: " + note.getPkNote());
            ContentValues values = new ContentValues();
            values.put(PKNOTE[0], note.getPkNote());
            values.put(NOTEFKTASK[0], note.getFkTask());
            values.put(NOTEFKUSER[0], note.getFkUser());
            values.put(NOTETEXT[0], note.getNoteText());
            values.put(NOTEDATECREATED[0], note.getDateCreated().toString());
            values.put(NOTELASTUPDATED[0], note.getLastUpdated().toString());

            db.update(TABLE_NOTES, values, PKNOTE[0] + " =? ", new String[] { String.valueOf(note.getPkNote()) });
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return false;
        }
        finally{
            db.endTransaction();
            return true;
        }
    }

    public boolean deleteNote(Note note)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Deleting note: " + note.getPkNote());
            db.delete(TABLE_NOTES, PKNOTE[0] + " =?",
                    new String[] { String.valueOf(note.getPkNote()) });

            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return false;
        }
        finally{
            db.endTransaction();
            return true;
        }
    }

    public List<Note> getAllNotes(Task task)
    {
        String getAllNotesQuery = "SELECT * FROM " + TABLE_NOTES + " WHERE " + NOTEFKTASK[0] + " = " + task.getPkTask();
        List<Note> notes = new ArrayList<Note>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.e("Database", "Returning all notes for task: " + task.getPkTask());
            Cursor cursor = db.rawQuery(getAllNotesQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    Note note = new Note(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)), cursor.getString(3),
                            cursor.getString(4), cursor.getString(5));

                    // Adding contact to list
                    notes.add(note);
                } while (cursor.moveToNext());
            }
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return null;
        }
        finally{
            db.endTransaction();
            return notes;
        }
    }

    /*
    * TROPHIES DATABASE FUNCTIONS
    */
    private boolean addTrophy(Trophy trophy){
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            ContentValues values = new ContentValues();
            values.put(TROPHYNAME[0], trophy.getName());
            values.put(TROPHYURL[0], trophy.getTropyUrl());

            db.insert(TABLE_TROPHIES, null, values);
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return false;
        }
        finally{
            db.endTransaction();
            return true;
        }
    }

    public boolean deleteTrophy(Trophy trophy)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Deleting trophy: " + trophy.getPkTrophy());
            db.delete(TABLE_TROPHIES, PKTROPHY[0] + " = ?",
                    new String[] { String.valueOf(trophy.getPkTrophy()) });
            deleteTrophyToGoal(trophy);
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return false;
        }
        finally{
            db.endTransaction();
            return true;
        }
    }

    public List<Trophy> getAllTrophies(User user)
    {
        String getAllTrophiesQuery = "SELECT * FROM " + TABLE_TROPHIES;
        List<Trophy> trophies = new ArrayList<Trophy>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Getting all trophies for user: " + user.getPkUser());
            Cursor cursor = db.rawQuery(getAllTrophiesQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    Trophy trophy = new Trophy(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3));

                    // Adding contact to list
                    trophies.add(trophy);
                } while (cursor.moveToNext());
            }
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return null;
        }
        finally{
            db.endTransaction();
            return trophies;
        }
    }

    /*
    * STICKERS DATABASE FUNCTIONS
    */
    public boolean addSticker(Sticker sticker){
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Adding sticker: " + sticker.getPkSticker());
            ContentValues values = new ContentValues();
            values.put(PKSTICKER[0], sticker.getPkSticker());
            values.put(STICKERNAME[0], sticker.getName());
            values.put(STICKERURL[0], sticker.getStickerUrl());

            db.insert(TABLE_STICKER, null, values);
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", e.toString());
            return false;
        }
        finally{
            db.endTransaction();
            return true;
        }
    }

    private boolean deleteSticker(Sticker sticker)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Deleting sticker: " + sticker.getPkSticker());
            db.delete(TABLE_STICKER, PKSTICKER[0] + " = ?",
                    new String[] { String.valueOf(sticker.getPkSticker()) });

            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return false;
        }
        finally {
            db.endTransaction();
            return true;
        }
    }

    public List<Sticker> getAllStickers(User user)
    {
        String getAllStickersQuery = "SELECT * FROM " + TABLE_STICKER;
        List<Sticker> stickers = new ArrayList<Sticker>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Getting all stickers for user: " + user.getPkUser());
            Cursor cursor = db.rawQuery(getAllStickersQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    Sticker sticker = new Sticker(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3));

                    // Adding contact to list
                    stickers.add(sticker);
                } while (cursor.moveToNext());
            }
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return null;
        }
        finally{
            db.endTransaction();
            return stickers;
        }
    }

    /*
    * TROPHYTOGOAL DATABASE FUNCTIONS
    * Can only have one of each type of trophy
    */
    public boolean addTrophyToGoal(Trophy trophy, Goal goal, User user){
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Adding trophy: " + trophy.getPkTrophy() + " to user: " + user.getPkUser() + " for goal: " + goal.getPkGoal());
            ContentValues values = new ContentValues();
            values.put(TTGFKTROPHY[0], trophy.getPkTrophy());
            values.put(TTGFKGOAL[0], goal.getPkGoal());
            values.put(TTGFKUSER[0], user.getPkUser());
            values.put(TTGDATEEARNED[0], trophy.getDateEarned());

            db.insert(TABLE_TROPHYTOGOAL, null, values);
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return false;
        }
        finally {
            db.endTransaction();
            addTrophy(trophy);
            return true;
        }
    }

    private boolean deleteTrophyToGoal(Trophy trophy)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Deleting trophy: " + trophy.getPkTrophy());
            db.delete(TABLE_TROPHYTOGOAL, TTGFKTROPHY[0] + " = ?",
                    new String[] { String.valueOf(trophy.getPkTrophy()) });
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return false;
        }
        finally{
            db.endTransaction();
            return true;
        }
    }

    /*
    * STICKERTOUSER DATABASE FUNCTIONS
    * Can have MORE THAN one of each type
    * delete statement must look for exact match
    */
    public boolean addStickerToUser(Sticker sticker, User givingUser, User receivingUser){
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        try{
            Log.d("Database", "Adding sticker: " + sticker.getPkSticker() + " to user: " + receivingUser.getPkUser());
            ContentValues values = new ContentValues();
            values.put(STUFKSTICKER[0], sticker.getPkSticker());
            values.put(STUFKGIVINGUSER[0], givingUser.getPkUser());
            values.put(STUFKRECEIVINGUSER[0], receivingUser.getPkUser());
            values.put(STUDATERECEIVED[0], sticker.getDateReceived().toString());

            db.insert(TABLE_STICKERTOUSER, null, values);
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return false;
        }
        finally{
            db.endTransaction();
            addSticker(sticker);
            return true;
        }

    }

    private boolean deleteStickerToUser(Sticker sticker, User receivingUser)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String deleteQuery = "DELETE FROM " + TABLE_STICKERTOUSER + "WHERE "
                + STUFKSTICKER[0] + " = " + sticker.getPkSticker() + " AND "
                + STUFKRECEIVINGUSER[0] + " = " + receivingUser.getPkUser();
        db.beginTransaction();

        try{
            Log.d("Database", "Deleting sticker: " + sticker.getPkSticker() + " from user: " + receivingUser.getPkUser());
            db.rawQuery(deleteQuery, null);
            db.setTransactionSuccessful();
        }
        catch(Exception e){
            Log.e("Database", "Error: " + e.toString());
            return false;
        }
        finally{
            db.endTransaction();
            deleteSticker(sticker);
            return true;
        }


    }
}
