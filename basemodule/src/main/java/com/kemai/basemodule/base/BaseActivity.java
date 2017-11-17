package com.kemai.basemodule.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.kemai.basemodule.di.component.BaseComponent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author mark.liu
 */
public abstract class BaseActivity<P extends IPresenter> extends RxAppCompatActivity {
    private final static String LAYOUT_LINEAR_LAYOUT = "LinearLayout";
    private final static String LAYOUT_FRAME_LAYOUT = "FrameLayout";
    private final static String LAYOUT_RELATIVE_LAYOUT = "RelativeLayout";
    private Unbinder mUnbinder;
    protected final String TAG = this.getClass().getSimpleName();
    @Inject protected P mPresenter;

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View view = null;
        if (name.equals(LAYOUT_FRAME_LAYOUT)) {
            view = new AutoFrameLayout(context, attrs);
        } else if (name.equals(LAYOUT_LINEAR_LAYOUT)) {
            view = new AutoLinearLayout(context, attrs);
        } else if (name.equals(LAYOUT_RELATIVE_LAYOUT)) {
            view = new AutoRelativeLayout(context, attrs);
        }
        return view;
    }

    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        if (useEventBus()) {
            // 如果要使用eventbus请将此方法返回true
            EventBus.getDefault().register(this);
        }
        // 绑定到butterknife
        mUnbinder = ButterKnife.bind(this);
        // 依赖注入
        setupActivityComponent(BaseApplication.getBaseComponent());
        initData();
    }

    /**
     * 提供AppComponent(提供所有的单例对象)给子类，进行Component依赖
     */
    protected abstract void setupActivityComponent(BaseComponent baseComponent);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            // 释放资源
            mPresenter.onDestroy();
        }
        if (mUnbinder != Unbinder.EMPTY) {
            mUnbinder.unbind();
        }
        // 如果要使用eventbus请将此方法返回true
        if (useEventBus()) {
            EventBus.getDefault().unregister(this);
        }
        mPresenter = null;
        mUnbinder = null;
    }

    /**
     * 是否使用eventBus,默认为使用(false)，
     */
    protected boolean useEventBus() {
        return false;
    }

    /**
     * 加载xml布局文件
     */
    @LayoutRes
    protected abstract int getLayoutRes();

    /**
     * 初始化数据
     */
    protected abstract void initData();
}