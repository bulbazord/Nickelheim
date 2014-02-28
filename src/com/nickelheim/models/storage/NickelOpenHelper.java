package com.nickelheim.model.db;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

/**
 * This class sets up the SQLite database in persistent phone memory.
 *
 * I expect this code will likely end up being moved into a private class inside
 * something else. But that's just my present guess.
 *
 * @author matthugs
 */
public class NickelOpenHelper extends SQLiteOpenHelper {

    /**
     * I expect these shouldn't be defined here.
     *
     * They should probably be defined in some Presenter class?
     *
     * Version number used for updating the database schema (unambiguously
     * not our problem if we don't want to try to deploy).
     */
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "nickelheim";
    /**
     * The name of a table containing users.
     */
    private static final String USER_TABLE_NAME = "users";
    private static final String[] USER_TABLE_COLUMNS = {"username TEXT", 
                                                        "password TEXT"};
    /**
     * The SQLite query used to create the user table.
     *
     * This is definitely silly
     */
    private static final String CREATE_USER_TABLE;
    static {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE " + USER_TABLE_NAME + " (");
        appendColumns(sb, USER_TABLE_COLUMNS);
        sb.append(");");
        CREATE_USER_TABLE = sb.toString();
    }

    /*
     * Appends all the columns for the sake of building a CREATE TABLE query
     */
    private static StringBuilder appendColumns(StringBuilder sb,
                                               String[] columns) {
        for(int i = 0; i < columns.length; i++) {
            sb.append(columns[i]);
            if(i < columns.length - 1) {
                sb.append(", ");
            }
        }
        return sb;
    }

    /**
     * Obligatory constructor
     *
     * Copy/pasta'd from the Android tutorial on the subject
     *
     * @param Context
     */
    public NickelOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Sets up the table.
     *
     * This method is run automagically when you use getWriteableDatabase() or
     * getReadableDatabase() and we haven't made it before.
     *
     * @param SQLiteDatabase the Database in which the table is created
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }


    /**
     * Upgrades the table from an older schema version.
     *
     * I'm not sure what I'd actually like to do with this, so I followed the
     * example code's lead to begin with.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE_NAME); // I expect this
        // is super destructive
        onCreate(db);
    }
}
