package com.amitpatil.todoapp.database;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import java.util.List;

public class TODORepository {

    private TODODao myAppDao;

    public TODORepository() {
        TODOAppDb db = TODOAppDb.getDatabase();
        myAppDao = db.daoAccess();
    }

    public List<TodoData> getToDoData() {
        return myAppDao.getAllToDoListData();
    }


    public int updateTagData(String title, String details, String created_date, String id) {
        return myAppDao.update(title, details, created_date, id);
    }


    public void dbOperation(TodoData user1) {
        if (null != user1) {
            new DBOperation(myAppDao).execute(user1);
        } else {
            new IllegalArgumentException("TodoData class cannot be null");
        }
    }


    public int deleleAll() {
        return myAppDao.deleteAllTodoData();
    }

    class DBOperation extends AsyncTask {

        private TODODao dao;

        DBOperation(TODODao dao) {
            this.dao = dao;
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            dao.insertTask((TodoData) objects[0]);
            return null;
        }
    }
}
