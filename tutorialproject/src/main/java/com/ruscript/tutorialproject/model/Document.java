package com.ruscript.tutorialproject.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name = "document_table")
public class Document {
    @Id
    @Column(name = "document_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 6, max = 6, message = "Wrong format")
    @Column(name = "passport_number")
    public String passportnumber;

    @Column(name = "passport_seria")
    public String passportseries;

    @Column(name = "birth_date")
    public Date birthdate;

    @Column(name = "address")
    public String address;

    public Document() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassportnumber() {
        return passportnumber;
    }

    public void setPassportnumber(String passportnumber) {
        this.passportnumber = passportnumber;
    }

    public String getPassportseries() {
        return passportseries;
    }

    public void setPassportseries(String passportseries) {
        this.passportseries = passportseries;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
