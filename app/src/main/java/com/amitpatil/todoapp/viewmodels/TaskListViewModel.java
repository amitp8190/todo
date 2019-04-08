package com.amitpatil.todoapp.viewmodels;

import androidx.lifecycle.MutableLiveData;

import com.amitpatil.todoapp.base.BaseViewModel;
import com.amitpatil.todoapp.database.TODORepository;
import com.amitpatil.todoapp.database.TodoData;
import com.amitpatil.todoapp.views.tasklist.TaskListNavigator;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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

    public Flowable<List<TodoData>> getTaskList() {
        return todoRepository.getToDoData();

    }

    //code for MutableLiveData
    public MutableLiveData<List<TodoData>> getDataFromDB() {
        disposable.add(getTaskList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(todoDataList -> {
                            listMutableLiveData.setValue(todoDataList);
                        },
                        throwable -> {
                            //Log.e(TAG, "Unable to update username", throwable)
                        }));
        return listMutableLiveData;
    }
}
