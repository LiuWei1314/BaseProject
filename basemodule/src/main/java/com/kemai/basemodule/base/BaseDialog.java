package com.kemai.basemodule.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kemai.basemodule.di.component.BaseComponent;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * @author mark.liu
 *         Created by mark.liu on 2017-5-16.
 */
public abstract class BaseDialog<P extends IPresenter> extends Dialog {
    protected Context mContext;
    @Inject protected P mPresenter;

    public BaseDialog(@NonNull Context context) {
        super(context);
        mContext = context;
    }

    public BaseDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        mContext = context;
    }

    protected BaseDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 如果要使用eventbus请将此方法返回true
        if (useEventBus()) {
            // 注册到事件主线
            EventBus.getDefault().register(this);
        }

        View view = LayoutInflater.from(mContext).inflate(getLayoutRes(), null);
        ViewGroup.LayoutParams params = getLayoutParams();
        if (null != params) {
            setContentView(view, params);
        } else {
            setContentView(view);
        }

        // 绑定到butterknife
        ButterKnife.bind(this);
        // 依赖注入
        setupDialogComponent(BaseApplication.getBaseComponent());
        initData();
    }

    protected ViewGroup.LayoutParams getLayoutParams() {
        return null;
    }

    /**
     * 提供AppComponent(提供所有的单例对象)给子类，进行Component依赖
     *
     * @param baseComponent 父组件
     */
    protected abstract void setupDialogComponent(BaseComponent baseComponent);

    /**
     * 是否使用eventBus,默认为使用(false)，
     */
    protected boolean useEventBus() {
        return false;
    }

    /**
     * 加载xml布局
     *
     * @return
     */
    @LayoutRes
    protected abstract int getLayoutRes();

    /**
     * 初始化方法
     */
    protected abstract void initData();
}
