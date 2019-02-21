package com.amitpatil.todoapp.viewmodels;

import android.arch.lifecycle.MutableLiveData;

import com.amitpatil.todoapp.base.BaseViewModel;
import com.amitpatil.todoapp.database.TODORepository;
import com.amitpatil.todoapp.database.TodoData;
import com.amitpatil.todoapp.views.tasklist.TaskListNavigator;

import java.util.List;

public class TaskListViewModel extends BaseViewModel<TaskListNavigator> {

    final TODORepository todoRepository;
    private MutableLiveData<List<TodoData>> listMutableLiveData = new MutableLiveData<>();

    public TaskListViewModel() {
        todoRepository = new TODORepository();
        getDataFromDB();
    }


    public void addNewTask() {
        mNavigator.createNewTask();
    }

    public MutableLiveData<List<TodoData>> getDataFromDB() {
        listMutableLiveData.setValue(todoRepository.getToDoData());
        return listMutableLiveData;
    }
}
