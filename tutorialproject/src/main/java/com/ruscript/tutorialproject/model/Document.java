package com.ruscript.tutorialproject.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "document_table")
public class Document {
    @Id
    @Column(name = "document_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "passport_number")
    private String passport_number;

    @Column(name = "passport_seria")
    private String passport_series;

    @Column(name = "birth_date")
    private Date birth_date;

    @Column(name = "address")
    private String address;

    public Document() {
    }

    public int getId() {
        return id;
    }

    public String getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(String passport_number) {
        this.passport_number = passport_number;
    }

    public String getPassport_series() {
        return passport_series;
    }

    public void setPassport_series(String passport_seria) {
        this.passport_series = passport_seria;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
