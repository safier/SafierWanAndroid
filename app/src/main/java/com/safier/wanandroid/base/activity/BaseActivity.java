package com.safier.wanandroid.base.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.classic.common.MultipleStatusView;
import com.safier.wanandroid.base.presenter.IPrensenter;
import com.safier.wanandroid.base.view.IView;
import com.safier.wanandroid.utils.CommonUtils;
import com.safier.wanandroid.utils.ToastUtils;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * @author safier
 * @date 2019/4/23
 */
public abstract class BaseActivity<T extends IPrensenter> extends AbstractSimpleActivity implements HasSupportFragmentInjector,IView{

    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentDispatchingAndroidInjector;
    @Inject
    protected T mPresenter;

    private MultipleStatusView mMultipleStatusView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void onViewCreated() {
//        mMultipleStatusView = findViewById(R.id.custom_multiple_status_view);
//        if (mMultipleStatusView != null) {
//            mMultipleStatusView.setOnRetryClickListener(v -> mPresenter.reload());
//        }
//        if (mPresenter != null) {
//            mPresenter.attachView(this);
//        }
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        hideLoading();
        super.onDestroy();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mFragmentDispatchingAndroidInjector;
    }

    @Override
    public void onBackPressedSupport() {
        CommonUtils.hideKeyBoard(this, this.getWindow().getDecorView().getRootView());
        super.onBackPressedSupport();
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        ToastUtils.showToast(this, errorMsg);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {
        if (mMultipleStatusView != null) {
            mMultipleStatusView.showLoading();
        }
    }

    @Override
    public void showError() {
        if (mMultipleStatusView != null) {
            mMultipleStatusView.showError();
        }
    }

    @Override
    public void showNoNetwork() {
        if (mMultipleStatusView != null) {
            mMultipleStatusView.showNoNetwork();
        }
    }

    @Override
    public void showEmpty() {
        if (mMultipleStatusView != null) {
            mMultipleStatusView.showEmpty();
        }
    }

    @Override
    public void showContent() {
        if (mMultipleStatusView != null) {
            mMultipleStatusView.showContent();
        }
    }

    @Override
    public void handleLoginSuccess() {

    }

    @Override
    public void handleLogoutSuccess() {

    }


}
