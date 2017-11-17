package com.kemai.basemodule.di.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author mark.liu
 *         Created by mark.liu on 2017-5-8.
 */
@Module
public class BaseModule {
    private Application mApplication;

    public BaseModule(Application application) {
        this.mApplication = application;
    }

    @Singleton
    @Provides
    public Application provideApplication() {
        return mApplication;
    }
}
