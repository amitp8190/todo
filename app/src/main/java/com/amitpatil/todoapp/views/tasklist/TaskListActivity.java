package com.amitpatil.todoapp.views.tasklist;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.amitpatil.todoapp.R;
import com.amitpatil.todoapp.base.BaseActivity;
import com.amitpatil.todoapp.base.BaseNavigator;
import com.amitpatil.todoapp.databinding.ActivityTaskListBinding;
import com.amitpatil.todoapp.viewmodels.TaskListViewModel;
import com.amitpatil.todoapp.views.addtask.AddTaskActivity;
import com.amitpatil.todoapp.views.taskdetail.TaskDetailsActivity;


public class TaskListActivity extends BaseActivity<ActivityTaskListBinding, TaskListViewModel> implements TaskListNavigator {

    private TaskListAdapter mAdapter;


    @Override
    public int getLayoutID() {
        return R.layout.activity_task_list;
    }

    @Override
    public void onBinding() {
        mBinding.setViewModel(mViewModel);
        setInitialization();
        setData();
    }

    private void setData() {
        mViewModel.getDataFromDB().observe(this, mlist -> {
            if (mlist.size() > 0) {
                mBinding.rvTaskList.setVisibility(View.VISIBLE);
                mBinding.noData.setVisibility(View.GONE);
                mAdapter.setItems(mlist);
            } else {
                mBinding.noData.setVisibility(View.VISIBLE);
                mBinding.rvTaskList.setVisibility(View.GONE);

            }
        });
    }

    private void setInitialization() {
        mAdapter = new TaskListAdapter(TaskListActivity.this);
        mBinding.rvTaskList.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvTaskList.setAdapter(mAdapter);

        mAdapter.getItemClick().subscribe(task_data -> {
            Intent detailTaskIntent = new Intent(TaskListActivity.this, TaskDetailsActivity.class);
            detailTaskIntent.putExtra("data", task_data);
            startActivity(detailTaskIntent);
        });
    }

    @Override
    public Class getViewModel() {
        return TaskListViewModel.class;
    }

    @Override
    public BaseNavigator getNavigatorReference() {
        return TaskListActivity.this;
    }

    @Override
    public String getScreenName() {
        return null;
    }


    @Override
    public void createNewTask() {
        Intent createTaskIntent = new Intent(TaskListActivity.this, AddTaskActivity.class);
        startActivity(createTaskIntent);
    }
}
