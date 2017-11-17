package com.kemai.basemodule.net;

import android.content.Context;

import com.alibaba.fastjson.JSONPathException;
import com.blankj.utilcode.util.ToastUtils;
import com.kemai.basemodule.net.progress.ProgressCancelListener;
import com.kemai.basemodule.net.progress.ProgressDialogHandler;

import org.json.JSONException;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public class ProgressSubscriber<T> implements ProgressCancelListener, Observer<T> {
    private AbstractOnNextListener mAbstractOnNextListener;
    private ProgressDialogHandler mProgressDialogHandler;
    private Disposable mDisposable;
    private Context mContext;

    public ProgressSubscriber(Context context, AbstractOnNextListener<T> mAbstractOnNextListener) {
        this.mAbstractOnNextListener = mAbstractOnNextListener;
        this.mContext = context;
        mProgressDialogHandler = new ProgressDialogHandler(context, this, true, true);
    }

    public ProgressSubscriber(Context context, boolean isShow, AbstractOnNextListener<T> mAbstractOnNextListener) {
        this.mAbstractOnNextListener = mAbstractOnNextListener;
        this.mContext = context;
        mProgressDialogHandler = new ProgressDialogHandler(context, this, true, isShow);
    }

    public ProgressSubscriber(Context context, boolean isShow, boolean isCancel,
                              AbstractOnNextListener<T> mAbstractOnNextListener) {
        this.mAbstractOnNextListener = mAbstractOnNextListener;
        this.mContext = context;
        mProgressDialogHandler = new ProgressDialogHandler(context, this, isCancel, isShow);
    }

    private void showProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    private void dismissProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mProgressDialogHandler = null;
        }
    }

    /**
     * 完成，隐藏ProgressDialog
     */
    @Override
    public void onComplete() {
        dismissProgressDialog();
    }

    /**
     * 对错误进行统一处理
     * 隐藏ProgressDialog
     *
     * @param e
     */
    @Override
    public void onError(Throwable e) {
        mAbstractOnNextListener.onError(e);
        String msg = "未知错误";
        if (e instanceof UnknownHostException) {
            msg = "网络不可用!";
        } else if (e instanceof SocketTimeoutException) {
            msg = "网络请求超时!";
        } else if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            msg = convertStatusCode(httpException);
        } else if (e instanceof JSONPathException
                || e instanceof com.alibaba.fastjson.JSONException
                || e instanceof JSONException) {
            msg = "数据解析错误!";
        }
        ToastUtils.showShort(msg);
        dismissProgressDialog();
    }

    private String convertStatusCode(HttpException httpException) {
        String msg;
        if (httpException.code() == 500) {
            msg = "服务器发生错误!";
        } else if (httpException.code() == 404) {
            msg = "请求地址不存在!";
        } else if (httpException.code() == 403) {
            msg = "请求被服务器拒绝!";
        } else if (httpException.code() == 307) {
            msg = "请求被重定向到其他页面!";
        } else {
            msg = httpException.message();
        }
        return msg;
    }

    /**
     * 订阅开始时调用
     * 显示ProgressDialog
     */
    @Override
    public void onSubscribe(Disposable d) {
        showProgressDialog();
        this.mDisposable = d;
    }

    /**
     * 将onNext方法中的返回结果交给Activity或Fragment自己处理
     *
     * @param t 创建Subscriber时的泛型类型
     */
    @Override
    public void onNext(T t) {
        if (mAbstractOnNextListener != null) {
            mAbstractOnNextListener.onNext(t);
        }
    }

    /**
     * 取消ProgressDialog的时候，取消对observable的订阅，同时也取消了http请求
     */
    @Override
    public void onCancelProgress() {
        if (null != mDisposable && mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }
}