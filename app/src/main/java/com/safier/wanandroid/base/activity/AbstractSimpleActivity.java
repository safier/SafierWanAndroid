package com.safier.wanandroid.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gyf.barlibrary.ImmersionBar;
import com.safier.wanandroid.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * @author safier
 * @date 2019/4/23
 */
public abstract class AbstractSimpleActivity extends SupportActivity {
    private Unbinder unBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ImmersionBar.with(this)
                .statusBarView(findViewById(R.id.status_bar_view))
                .keyboardEnable(true)
                .init();
        unBinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy(); //必须调用该方法，防止内存泄漏
        if (unBinder != null && unBinder != Unbinder.EMPTY) {
            unBinder.unbind();
            unBinder = null;
        }
    }

    protected abstract void initView();

    /**
     * 在initEventAndData()之前执行
     */
    protected abstract void onViewCreated();

    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化ToolBar
     */
    protected abstract void initToolbar();

    /**
     * 初始化数据
     */
    protected abstract void initEventAndData();
}
