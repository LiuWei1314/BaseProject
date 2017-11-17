package com.kemai.basemodule.net;

/**
 * 网络请求回调
 *
 * @param <T> 回调数据的泛型
 * @author mark.liu
 */
public abstract class AbstractOnNextListener<T> {
    /**
     * 回调所调用的方法
     *
     * @param t 回调的数据
     */
    protected abstract void onNext(T t);

    public void onError(Throwable e) {
    }
}