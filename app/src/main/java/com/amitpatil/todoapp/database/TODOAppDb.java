package com.amitpatil.todoapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.amitpatil.todoapp.base.TodoApp;

@Database(entities = {TodoData.class}, version = 1, exportSchema = false)
public abstract class TODOAppDb extends RoomDatabase {

    private static TODOAppDb INSTANCE;

    public static TODOAppDb getDatabase() {
        INSTANCE = Room.databaseBuilder(TodoApp.getContext(), TODOAppDb.class, "todo_db")
                .allowMainThreadQueries().build();
        return INSTANCE;
    }

    public abstract TODODao daoAccess();
}
