package com.nickelheim.presenters.storage;

import android.util.Log;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import android.content.Context;
import com.j256.ormlite.table.TableUtils;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import com.nickelheim.models.User;
import com.nickelheim.models.Portfolio;
import com.nickelheim.models.Account;
import com.nickelheim.models.Transaction;

import com.j256.ormlite.dao.Dao;

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
     * Data Access Objects, aka DAOs, are used to provide database functions for
     * a specific class.
     */
    private Dao<User, String> userDao = null;
    private Dao<Transaction, Long> transactionDao = null;


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
                  "onCreate making tables");
            TableUtils.createTable(connectionSource, User.class);
            TableUtils.createTable(connectionSource, Portfolio.class);
            TableUtils.createTable(connectionSource, Account.class);
            TableUtils.createTable(connectionSource, Transaction.class);
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

    /**
     * Returns the Dao object used to access User object database functions.
     *
     * We use <code>RuntimeExceptionDao</code>s, since they throw
     * RuntimeExceptions in lieu of SQLExceptions, which makes a bit more sense
     * for an Android application (or so I'm told).
     *
     * @return RuntimeExceptionDao<User, String> the Dao
     */
    public Dao<User, String> getUserDao() throws SQLException{
        if(userDao == null) {
            userDao = getDao(User.class);
        }
        return userDao;
    }

    private Dao<Portfolio, Integer> portfolioDao = null;
    public Dao<Portfolio, Integer> getPortfolioDao() throws SQLException {
        if(portfolioDao == null) {
            portfolioDao = getDao(Portfolio.class);
        }
        return portfolioDao;
    }

    private Dao<Account, Integer> accountDao = null;
    public Dao<Account, Integer> getAccountDao() throws SQLException {
        if(accountDao == null) {
            accountDao = getDao(Account.class);
        }
        return accountDao;
    }
}
