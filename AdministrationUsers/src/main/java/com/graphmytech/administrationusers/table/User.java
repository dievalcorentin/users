package com.graphmytech.administrationusers.table;

import jakarta.persistence.Entity;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
public class User{

    private String name;
    private Integer age;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }
}