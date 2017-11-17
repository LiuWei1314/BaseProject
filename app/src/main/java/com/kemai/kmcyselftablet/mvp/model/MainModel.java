package com.kemai.kmcyselftablet.mvp.model;

import com.kemai.basemodule.base.BaseModel;
import com.kemai.basemodule.di.scope.ActivityScope;
import com.kemai.basemodule.net.Api;
import com.kemai.kmcyselftablet.mvp.contract.MainContract;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author mark.liu
 *         Created by mark.liu on 2017-5-24.
 */
@ActivityScope
public class MainModel extends BaseModel implements MainContract.Model {
    @Inject Api mApi;

    @Inject
    public MainModel() {
        super();
    }

    @Override
    public Observable test() {
        return null;
    }
}