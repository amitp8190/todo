package com.amitpatil.todoapp.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import io.reactivex.disposables.CompositeDisposable;


public class BaseViewModel<N extends BaseNavigator> extends ViewModel {
    public CompositeDisposable disposable = new CompositeDisposable();
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
        disposable.dispose();

    }

    public void showToastMessage(String msg, Context context) {
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
