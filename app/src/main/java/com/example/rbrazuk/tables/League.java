package com.example.rbrazuk.tables;

/**
 * Created by rossbrazuk1 on 2/12/16.
 */
public class League {
    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public League(String name, String id) {
        this.name = name;
        this.id = id;
    }
}
