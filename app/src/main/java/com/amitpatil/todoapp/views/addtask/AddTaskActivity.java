package com.amitpatil.todoapp.views.addtask;

import android.content.Intent;

import com.amitpatil.todoapp.R;
import com.amitpatil.todoapp.base.BaseActivity;
import com.amitpatil.todoapp.base.BaseNavigator;
import com.amitpatil.todoapp.databinding.ActivityAddTaskBinding;
import com.amitpatil.todoapp.model.TaskModel;
import com.amitpatil.todoapp.viewmodels.AddTaskViewModel;
import com.amitpatil.todoapp.views.tasklist.TaskListActivity;

public class AddTaskActivity extends BaseActivity<ActivityAddTaskBinding, AddTaskViewModel> implements AddTaskNavigator {

    @Override
    public int getLayoutID() {
        return R.layout.activity_add_task;
    }

    @Override
    public void onBinding() {
        mBinding.setViewModel(mViewModel);
        mBinding.setModel(new TaskModel());
    }

    @Override
    public Class getViewModel() {
        return AddTaskViewModel.class;
    }

    @Override
    public BaseNavigator getNavigatorReference() {
        return AddTaskActivity.this;
    }

    @Override
    public String getScreenName() {
        return null;
    }


    @Override
    public void onClearFormData() {
        mBinding.txtDetail.setText("");
        mBinding.txtTitle.setText("");
    }

    @Override
    public void redirecttaskList() {
        Intent refreshTaskListintent =new Intent(AddTaskActivity.this, TaskListActivity.class);
        refreshTaskListintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        refreshTaskListintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(refreshTaskListintent);

    }
}
