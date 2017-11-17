package com.kemai.kmcyselftablet.mvp.di.component;

import com.kemai.basemodule.di.component.BaseComponent;
import com.kemai.basemodule.di.scope.ActivityScope;
import com.kemai.kmcyselftablet.mvp.di.module.MainModule;
import com.kemai.kmcyselftablet.mvp.ui.activity.MainActivity;

import dagger.Component;

/**
 * @author mark.liu
 *         Created by mark.liu on 2017-8-22.
 */
@ActivityScope
@Component(modules = MainModule.class, dependencies = BaseComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);
}