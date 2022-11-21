package com.ruscript.tutorialproject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "personal_data_table")
public class Personality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "second_name")
    private String second_name;

    @Column(name = "third_name")
    private String third_name;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "status")
    private boolean status;
}
