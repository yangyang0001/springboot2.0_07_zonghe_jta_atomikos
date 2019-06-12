package com.inspur.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable{

    private static final long serialVersionUID = 6421551811110924542L;

    private Long id;
    private String username;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}