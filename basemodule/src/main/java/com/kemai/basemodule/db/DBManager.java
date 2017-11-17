package com.kemai.basemodule.db;

import android.database.sqlite.SQLiteDatabase;

import com.kemai.basemodule.db.gen.DaoMaster;
import com.kemai.basemodule.db.gen.DaoSession;
import com.kemai.basemodule.di.module.DBModule;

import javax.inject.Inject;

/**
 * 数据库管理类
 *
 * @author mark.liu
 * @see DBModule 数据库配置
 */
public class DBManager {
    private SQLiteDatabase mSQLiteDatabase;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    @Inject
    public DBManager(SQLiteDatabase sqLiteDatabase, DaoMaster daoMaster, DaoSession daoSession) {
        this.mSQLiteDatabase = sqLiteDatabase;
        this.mDaoMaster = daoMaster;
        this.mDaoSession = daoSession;
    }

    public DaoMaster getMaster() {
        return mDaoMaster;
    }

    public DaoSession getSession() {
        return mDaoSession;
    }

    public DaoSession getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }

    public SQLiteDatabase getSQLiteDatabase() {
        return mSQLiteDatabase;
    }
}