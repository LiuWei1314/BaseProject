package com.kemai.basemodule.di.module;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.github.yuweiguocn.library.greendao.MigrationHelper;
import com.kemai.basemodule.BuildConfig;
import com.kemai.basemodule.db.DBManager;
import com.kemai.basemodule.db.DBOpenHelper;
import com.kemai.basemodule.db.gen.DaoMaster;
import com.kemai.basemodule.db.gen.DaoSession;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 数据库管理类
 *
 * @author mark.liu
 *         Created by mark.liu on 2017-7-20.
 */
@Module
public class DBModule {
    private static final String DB_NAME = "BaseProject.db";// 数据库名称

    @Provides
    @Singleton
    DBOpenHelper provideDBOpenHelper(Application application) {
        // 查看日志信息
        MigrationHelper.DEBUG = BuildConfig.DEBUG;
        return new DBOpenHelper(application, DB_NAME, null);
    }

    @Provides
    @Singleton
    SQLiteDatabase provideSQLiteDatabase(DBOpenHelper dbOpenHelper) {
        return dbOpenHelper.getWritableDatabase();
    }

    @Provides
    @Singleton
    DaoMaster provideDaoMaster(SQLiteDatabase sqLiteDatabase) {
        return new DaoMaster(sqLiteDatabase);
    }

    @Provides
    @Singleton
    DaoSession provideDaoSession(DaoMaster daoMaster) {
        return daoMaster.newSession();
    }

    @Singleton
    @Provides
    DBManager provideDBManager(SQLiteDatabase sqLiteDatabase, DaoMaster daoMaster, DaoSession daoSession) {
        return new DBManager(sqLiteDatabase, daoMaster, daoSession);
    }
}
