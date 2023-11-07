package com.example.studyprojectcontroller.study;

import java.util.HashMap;
import java.util.Objects;

public class Student {
    private String name;
    private int id;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name);
//    }

    public static void main(String[] args) {
        HashMap<Student,String> hashMap = new HashMap<Student, String>();
        Student student1 = new Student(1,"Alic1");
        Student student2 = new Student(1,"Alic1");
        hashMap.put(student1,"name1");
        System.out.println(hashMap.get(student2));
    }

}
