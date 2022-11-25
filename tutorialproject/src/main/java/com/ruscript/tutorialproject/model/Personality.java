package com.ruscript.tutorialproject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "personal_data_table")
public class Personality {
    @Id
    @Column(name = "personal_data_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "second_name")
    private String secondname;

    @Column(name = "third_name")
    private String thirdname;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone_number")
    private String phonenumber;

    @Column(name = "status")
    private boolean status;


    public Personality() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getThirdname() {
        return thirdname;
    }

    public void setThirdname(String thirdname) {
        this.thirdname = thirdname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
