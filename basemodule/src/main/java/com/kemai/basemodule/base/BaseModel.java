package com.kemai.basemodule.base;


import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

/**
 * @author mark.liu
 *         Created by mark on 2017/05/08.
 */
public class BaseModel implements IModel, LifecycleObserver {

    public BaseModel() {
    }

    @Override
    public void onDestroy() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy(LifecycleOwner owner) {
        owner.getLifecycle().removeObserver(this);
    }
}
