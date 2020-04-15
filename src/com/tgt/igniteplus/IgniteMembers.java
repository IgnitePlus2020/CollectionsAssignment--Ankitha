package com.tgt.igniteplus;

import java.util.HashSet;

public class IgniteMembers {
     String name;
     String college;
     String department;
     HashSet<String> skillset;
     int age;


    public IgniteMembers(String name,String college,String department, HashSet<String> skillset,int age) {
        this.name=name;
        this.college=college;
        this.department=department;
        this.skillset=skillset;
        this.age=age;
    }

    public IgniteMembers(String name,String dept){
        this.name = name;
        this.department=dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public HashSet<String> getSkillset() {
        return skillset;
    }

    public void setSkillset(HashSet<String> skillset) {
        this.skillset = skillset;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "IgniteMembers{" +
                "name='" + name + '\'' +
                ", college='" + college + '\'' +
                ", department='" + department + '\'' +
                ", skillset=" + skillset +
                ", age=" + age +
                '}';
    }
}
