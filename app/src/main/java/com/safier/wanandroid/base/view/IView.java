package com.safier.wanandroid.base.view;

/**
 * @author safier
 * @date 2019/4/23
 */
public interface IView {
    /**
     * Show error message
     *
     * @param errorMsg error message
     */
    void showErrorMsg(String errorMsg);

    void showLoading();

    void hideLoading();

    void showError();

    void showNoNetwork();

    void showEmpty();

    void showContent();

    void handleLoginSuccess();

    void handleLogoutSuccess();
}
