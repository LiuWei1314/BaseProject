package com.kemai.kmcyselftablet.mvp.ui.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.ImageView;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;
import com.kemai.basemodule.base.BaseActivity;
import com.kemai.basemodule.di.component.BaseComponent;
import com.kemai.kmcyselftablet.R;
import com.kemai.kmcyselftablet.mvp.contract.MainContract;
import com.kemai.kmcyselftablet.mvp.di.component.DaggerMainComponent;
import com.kemai.kmcyselftablet.mvp.di.module.MainModule;
import com.kemai.kmcyselftablet.mvp.presenter.MainPresenter;

import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;

/**
 * @author mark.liu
 *         Created by mark.liu on 2017-8-17.
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {
    @BindView(R.id.bt) Button mBt;
    @BindView(R.id.iv) ImageView mIV;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerMainComponent
                .builder()
                .baseComponent(baseComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
    }

    private Disposable disposable;

    @OnClick(R.id.bt)
    public void onClick() {
//        launchActivity(new Intent(this, TestActivity.class));
//        mPresenter.test();
//        EventBus.getDefault().register(this);
//        EventBus.getDefault().post(new String("asdf"));
       /* OkHttpUtils.get().url("http://static.liaoliaoy.com/audio/20170519/041707vn680cuf.mp3").build()
                   .execute(new FileCallBack(
                           "/data/data/com.kemai.kmcyselftablet/music",
                           "041707vn680cuf.mp3") {
                       @Override
                       public void onError(Call call, Exception e, int i) {
                           LogUtils.i("call++++++++++++++");
                           e.printStackTrace();
                       }

                       @Override
                       public void onResponse(File file, int i) {
                           LogUtils.i("onResponse++++++++++++++");

                           List<File> files = FileUtils.listFilesInDir("/data/data/com.kemai.kmcyselftablet/music");
                           LogUtils.i(files);
                       }

                       @Override
                       public void inProgress(float progress, long total, int id) {
                           double p = DoubleUtils.round_d(progress);
                           if (i < p) {
                               i = p;
                               LogUtils.i(i + "------------");
                           }
                       }

                       double i = -1;
                   });*/

//        List<File> files = FileUtils.listFilesInDir("/data/data/com.kemai.kmcyselftablet/music");
//        for (File file : files) {
//            LogUtils.i(file.getName());
//        }
//        LogUtils.i(files);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        ActivityUtils.startActivity(this, intent);
    }

    @Override
    public void killMyself() {
        ActivityUtils.finishActivity(this);
    }

    @Subscribe
    public void test(String string) {

    }
}