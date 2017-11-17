package com.kemai.kmcyselftablet.mvp.presenter;

import android.app.Application;

import com.kemai.basemodule.base.BasePresenter;
import com.kemai.basemodule.di.scope.ActivityScope;
import com.kemai.kmcyselftablet.mvp.contract.MainContract;

import javax.inject.Inject;

/**
 * Created by mark.liu on 2017-5-24.
 */
@ActivityScope
public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View> {
    private Application mApplication;

    @Inject
    public MainPresenter(MainContract.Model model, MainContract.View rootView,
                         Application application) {
        super(model, rootView);
        this.mApplication = application;
    }
}
