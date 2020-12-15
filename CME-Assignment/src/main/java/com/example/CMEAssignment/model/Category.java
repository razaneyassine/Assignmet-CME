package com.example.CMEAssignment.model;

import java.util.UUID;

public class Category {
    private  int id;
    private String Name;

    public Category(int id, String name) {
        this.id = id;
        Name = name;
    }

    public Category(String name){
        this.Name=name;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
