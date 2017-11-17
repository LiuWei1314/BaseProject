package com.kemai.basemodule.di.component;

import android.app.Application;

import com.kemai.basemodule.db.DBManager;
import com.kemai.basemodule.di.module.ApiModule;
import com.kemai.basemodule.di.module.BaseModule;
import com.kemai.basemodule.di.module.DBModule;
import com.kemai.basemodule.net.Api;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author mark.liu
 *         Created by mark on 2017/05/08.
 */
@Singleton
@Component(modules = {BaseModule.class, ApiModule.class, DBModule.class})
public interface BaseComponent {
    /**
     * Application
     *
     * @return
     */
    Application application();

    /**
     * 网络请求
     *
     * @return
     */
    Api api();

    /**
     * 数据库管理类
     *
     * @return
     */
    DBManager dbManager();
}
