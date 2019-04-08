package com.amitpatil.todoapp.database;



import java.io.Serializable;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class TodoData  implements Serializable{

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String details;
    private String created_date;

    public TodoData() {

    }

    @Ignore
    public TodoData(int id, String title, String details, String created_date) {
        this.id = id;
        this.title = title;
        this.details = details;
        this.created_date = created_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }
}
