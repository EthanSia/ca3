package com.dkit.Sd2a.ethan.sia;

import java.util.ArrayList;
import java.util.Objects;

public class Student implements Comparable<Student>
{
    private String id;
    private String name;
    private String email;
    private String telephone;
    private ArrayList<String> computersTag =new ArrayList<>();


    public Student( String name, String id, String email, String telephone)
    {
        this.name = name;
        this.id = id;
        this.email = email;
        this.telephone = telephone;
    }

    public Student(String name,String id, String email, String telephone, ArrayList<String>computersTag) {

        this.name = name;
        this.id = id;
        this.email = email;
        this.telephone = telephone;
        this.computersTag = computersTag;
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

    public ArrayList<String> getComputersTag()
    {
        return computersTag;
    }

    public void setComputersTag(String computersTag)
    {
        this.computersTag.add(computersTag);
    }



    public int compareTo(Student other)
   {
      return this.id.compareTo(other.id);  // return -1,+1,0
   }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", computersTag=" + computersTag +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getId(), student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
