package com.amitpatil.todoapp.base;

import androidx.lifecycle.ViewModelProviders;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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