package com.ruscript.tutorialproject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "document_table")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "passport_number")
    private String passport_number;

    @Column(name = "passport_seria")
    private String passport_seria;

    @Column(name = "birth_date")
    private Date birth_date;

    @Column(name = "address")
    private String address;
}
