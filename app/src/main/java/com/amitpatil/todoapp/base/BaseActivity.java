package com.amitpatil.todoapp.base;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.amitpatil.todoapp.utils.LoadingDialog;


public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity implements UICallbacks {

    protected T mBinding;
    protected V mViewModel;

    private LoadingDialog loadingDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(BaseActivity.this, getLayoutID());
        mViewModel = (V) ViewModelProviders.of(BaseActivity.this).get(getViewModel());
        mViewModel.setNavigator(getNavigatorReference());
        onBinding();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


}