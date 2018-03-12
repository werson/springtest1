package com.werson.springtest.model;

import javax.persistence.Entity;

/**
 * Created by wersom on 2017/10/17 0017.
 */
@Entity
public class Person {

    public Person(){
        System.out.println("this is Person");
    }

    private String name;

    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
