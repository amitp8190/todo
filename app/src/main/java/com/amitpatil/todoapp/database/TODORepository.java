package com.amitpatil.todoapp.database;

import android.os.AsyncTask;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;

public class TODORepository {

    private TODODao myAppDao;

    public TODORepository() {
        TODOAppDb db = TODOAppDb.getDatabase();
        myAppDao = db.daoAccess();
    }

    public Flowable<List<TodoData>> getToDoData() {
        return myAppDao.getAllToDoListData();
    }


    /*public Maybe updateTagData(String title, String details, String created_date, String id) {
        return myAppDao.update(title, details, created_date, id);
    }*/


    public void dbOperation(TodoData user1) {
        if (null != user1) {
        //    new DBOperation(myAppDao).execute(user1);
        } else {
            new IllegalArgumentException("TodoData class cannot be null");
        }
    }


/*
    public Maybe deleleAll() {
        return myAppDao.deleteAllTodoData();
    }
*/

    public Completable addTask(TodoData todoData) {
        return myAppDao.insertTask(todoData);
    }

//    class DBOperation extends AsyncTask {
//
//        private TODODao dao;
//
//        DBOperation(TODODao dao) {
//            this.dao = dao;
//        }
//
//        @Override
//        protected Object doInBackground(Object[] objects) {
//            return null;
//        }
//    }
}
