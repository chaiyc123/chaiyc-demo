package com.chaiyc._01_sort._01_Comparable;

public class Student implements Comparable<Student>{

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name:" + name + ":age=" + age;
    }

    //定义比较规则
    @Override
    public int compareTo(Student o) {
        return this.age - o.getAge();
    }
}
