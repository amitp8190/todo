package com.amitpatil.todoapp.views.taskdetail;

import com.amitpatil.todoapp.R;
import com.amitpatil.todoapp.base.BaseActivity;
import com.amitpatil.todoapp.base.BaseNavigator;
import com.amitpatil.todoapp.database.TodoData;
import com.amitpatil.todoapp.databinding.ActivityTaskDetailsBinding;
import com.amitpatil.todoapp.viewmodels.TaskDetailsViewModel;

public class TaskDetailsActivity extends BaseActivity<ActivityTaskDetailsBinding,
        TaskDetailsViewModel> implements TaskDetailsNavigator {



    @Override
    public int getLayoutID() {
        return R.layout.activity_task_details;
    }

    @Override
    public void onBinding() {

        TodoData model = (TodoData) getIntent().getSerializableExtra("data");
        mBinding.setModel(model);
    }

    @Override
    public Class getViewModel() {
        return TaskDetailsViewModel.class;
    }

    @Override
    public BaseNavigator getNavigatorReference() {
        return TaskDetailsActivity.this;
    }

    @Override
    public String getScreenName() {
        return null;
    }
}
