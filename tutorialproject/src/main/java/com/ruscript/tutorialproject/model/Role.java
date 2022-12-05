package com.ruscript.tutorialproject.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

public enum Role implements GrantedAuthority {
    OFFICER, ADMIN, RENTER;

    @Override
    public String getAuthority() {
        return name();
    }
}


//
//@Entity
//@Table(name = "role_table")
//public class Role implements GrantedAuthority {
//    @Id
//    @Column(name = "role_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Column(name = "role_name")
//    private String name;
//
//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Role() {
//    }
//
//    @Override
//    public String getAuthority() {
//        return name;
//    }
//}
