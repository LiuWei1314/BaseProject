package com.kemai.basemodule.base;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.kemai.basemodule.BuildConfig;
import com.kemai.basemodule.di.component.BaseComponent;
import com.kemai.basemodule.di.component.DaggerBaseComponent;
import com.kemai.basemodule.di.module.ApiModule;
import com.kemai.basemodule.di.module.BaseModule;
import com.kemai.basemodule.di.module.DBModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * @author mark.liu
 *         Created by mark.liu on 2017-5-9.
 */
public class BaseApplication extends Application {
    private static BaseComponent mBaseComponent;
    private static BaseApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplication = this;
        initLeakCanary();
        initBaseComponent();
        initUtils();
    }

    private void initBaseComponent() {
        mBaseComponent = DaggerBaseComponent
                .builder()
                // 提供application
                .baseModule(new BaseModule(this))
                .apiModule(new ApiModule())
                .dBModule(new DBModule())
                .build();
    }

    private void initUtils() {
        // 工具类初始化
        Utils.init(this);
        LogUtils.getConfig()
                .setLogHeadSwitch(false)
                .setBorderSwitch(false)
                // 日志开关
                .setLogSwitch(BuildConfig.LOG_DEBUG)
                // 设置TAG
                .setGlobalTag("BaseProject");
    }

    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    public static BaseComponent getBaseComponent() {
        return mBaseComponent;
    }

    /**
     * 返回上下文
     */
    public static Context getContext() {
        return mApplication.getApplicationContext();
    }

    public static BaseApplication getBaseApplication() {
        return mApplication;
    }
}
