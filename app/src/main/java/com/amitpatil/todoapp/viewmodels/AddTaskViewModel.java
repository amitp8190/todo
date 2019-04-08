package com.amitpatil.todoapp.viewmodels;

import android.util.Log;

import com.amitpatil.todoapp.base.BaseViewModel;
import com.amitpatil.todoapp.base.TodoApp;
import com.amitpatil.todoapp.database.TODORepository;
import com.amitpatil.todoapp.database.TodoData;
import com.amitpatil.todoapp.model.TaskModel;
import com.amitpatil.todoapp.views.addtask.AddTaskNavigator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AddTaskViewModel extends BaseViewModel<AddTaskNavigator> {


    private TODORepository todoRepository;

    public AddTaskViewModel() {
        todoRepository = new TODORepository();
    }

    public void onSubmit(TaskModel user) {
        if (isValid(user)) {

            TodoData data = new TodoData();
            data.setTitle(user.getTitle());
            data.setDetails(user.getDetails());
            data.setCreated_date(getCurrentDate());
            todoRepository.addTask(data);

            disposable.add(todoRepository.addTask(data)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(() -> Log.e("Alpha", "Successful Insertion"),
                            throwable -> Log.e("Alpha", "error while insertion " + throwable.getLocalizedMessage())));

            //Redirect to list
            mNavigator.redirecttaskList();
        } else {
            showToastMessage("All Fields are mandatory", TodoApp.getContext());
        }

    }

    private boolean isValid(TaskModel user) {
        boolean isValid = true;
        if (user.getTitle().length() == 0) {
            isValid = false;
        }
        if (user.getDetails().length() == 0) {
            isValid = false;
        }
        return isValid;
    }

    public void onClear() {
        mNavigator.onClearFormData();
    }

    private String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    }
}
