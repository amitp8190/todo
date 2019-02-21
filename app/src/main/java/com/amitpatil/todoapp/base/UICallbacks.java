package com.amitpatil.todoapp.base;


public interface UICallbacks {

    int getLayoutID();

    void onBinding();

    Class getViewModel();

    BaseNavigator getNavigatorReference();

    String getScreenName();

}
