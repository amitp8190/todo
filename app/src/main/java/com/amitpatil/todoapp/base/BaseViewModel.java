package com.amitpatil.todoapp.base;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;


public class BaseViewModel<N extends BaseNavigator> extends ViewModel {
    protected N mNavigator;
    protected MutableLiveData<Boolean> dialogVisibility = new MutableLiveData<>();
    protected MutableLiveData<String> dialogMessage = new MutableLiveData<>();

    public void setNavigator(N mNavigator) {
        this.mNavigator = mNavigator;

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mNavigator = null;

    }

    public void showToastMessage(String msg, Context context) {
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
