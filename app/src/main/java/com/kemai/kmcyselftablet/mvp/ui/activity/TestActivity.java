package com.kemai.kmcyselftablet.mvp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.blankj.utilcode.util.LogUtils;
import com.kemai.kmcyselftablet.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        init();
    }

    public void init() {
        Observable.interval(1, TimeUnit.SECONDS)
                  .subscribe(s -> LogUtils.i(s));
    }
}
