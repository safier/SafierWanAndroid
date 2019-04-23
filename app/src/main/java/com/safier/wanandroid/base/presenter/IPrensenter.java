package com.safier.wanandroid.base.presenter;

import com.safier.wanandroid.base.view.IView;

/**
 * @author safier
 * @date 2019/4/23
 */
public interface IPrensenter<T extends IView> {
    /**
     * attachView
     *
     * @param view view
     */
    void attachView(T view);

    /**
     * detachView
     */
    void detachView();

    void reload();

    void registerEventBus();

    void unregisterEventBus();

    /**
     * Set login status
     *
     * @param loginStatus login status
     */
    void setLoginStatus(boolean loginStatus);

    /**
     * Get login status
     *
     * @return if is login status
     */
    boolean getLoginStatus();

    /**
     * Get login account
     *
     * @return login account
     */
    String getLoginAccount();

    /**
     * Set login status
     *
     * @param account account
     */
    void setLoginAccount(String account);
}
