package com.amitpatil.todoapp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;
@Dao
public interface TODODao {

    @Insert
    void insertTask(TodoData tagData);

    @Query("Select * from TodoData ORDER BY id DESC")
    List<TodoData> getAllToDoListData();

    @Query("delete from TodoData")
    int deleteAllTodoData();

    @Query("update TodoData set details =:details,title=:title,details=:details,created_date=:created_date where id = :id")
    int update(String title, String details, String created_date, String id);
}
