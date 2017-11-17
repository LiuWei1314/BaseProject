package com.kemai.basemodule.base;

/**
 * @author mark.liu
 *         Created by mark on 2017/05/08.
 */
public interface IPresenter {
    /**
     * Presenter初始化时的回调
     */
    void onStart();

    /**
     * Presenter销毁时的回调
     */
    void onDestroy();
}
