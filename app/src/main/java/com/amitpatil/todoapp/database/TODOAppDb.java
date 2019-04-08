package com.amitpatil.todoapp.database;



import com.amitpatil.todoapp.base.TodoApp;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

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
