package com.kemai.basemodule.base;

import android.content.Intent;

/**
 * @author mark.liu
 *         Created by mark on 2017/05/08.
 */
public interface IView {
    /**
     * 跳转activity
     *
     * @param intent
     */
    void launchActivity(Intent intent);

    /**
     * 杀死自己
     */
    void killMyself();
}
