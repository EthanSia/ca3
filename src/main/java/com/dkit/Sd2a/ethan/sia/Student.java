package com.dkit.Sd2a.ethan.sia;

import java.util.HashMap;
import java.util.Map;

public class Student
{
    private String name;
    private String id;
    private String email;
    private String telephone;
    private Map<String,Computer> computers ;

    public Student(String name, String id, String email, String telephone) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.telephone = telephone;
        computers = new HashMap<>();
    }


    public void addBook( Computer compTag )
    {
        computers.put(compTag.getAssetTag(),compTag);  // use asset tag as Key, and Comp object as value
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", computers=" + computers +
                '}';
    }
}
