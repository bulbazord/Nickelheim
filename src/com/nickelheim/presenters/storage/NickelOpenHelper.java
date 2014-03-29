package com.nickelheim.presenters.storage;

import android.util.Log;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import android.content.Context;
import com.j256.ormlite.table.TableUtils;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import com.nickelheim.models.User;

/**
 * This class sets up the SQLite database in persistent phone memory.
 *
 * I expect this code will likely end up being moved into a private class inside
 * something else. But that's just my present guess.
 *
 * @author matthugs
 */
public class NickelOpenHelper extends OrmLiteSqliteOpenHelper {

    /**
     * I expect these shouldn't be defined here.
     *
     * They should probably be defined in some Presenter class?
     *
     * Version number used for updating the database schema (unambiguously
     * not our problem if we don't want to try to deploy).
     */
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "nickelheim.db";
    

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
     * getReadableDatabase(), if we haven't made it before.
     *
     * @param SQLiteDatabase the Database in which the table is created
     */
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            Log.i(NickelOpenHelper.class.getName(),
                  "onCreate making User table");
            TableUtils.createTable(connectionSource, User.class);
        } catch (SQLException e) {
            Log.e(NickelOpenHelper.class.getName(),
                  "User table creation issue");
            throw new RuntimeException(e);
        }
    }


    /**
     * Upgrades the table from an older schema version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource cs,
                          int oldVersion, int newVersion) {
        try {
            Log.i(NickelOpenHelper.class.getName(),
                  "onUpgrade droppin' tables");
            TableUtils.dropTable(cs, User.class, true);
            onCreate(db, cs);
        } catch(SQLException e) {
            Log.e(NickelOpenHelper.class.getName(),
                  "Derp while droppin' tables");
            throw new RuntimeException(e);
        }
    }
}
