package com.amitpatil.todoapp.database;


import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;

@Dao
public interface TODODao {

    @Insert
    Completable insertTask(TodoData tagData);

    @Query("Select * from TodoData ORDER BY id DESC")
    Flowable<List<TodoData>> getAllToDoListData();


  /*  @Query("delete from TodoData")
    Maybe deleteAllTodoData();

    @Query("update TodoData set details =:details,title=:title,details=:details,created_date=:created_date where id = :id")
    Maybe update(String title, String details, String created_date, String id);
*/


}
