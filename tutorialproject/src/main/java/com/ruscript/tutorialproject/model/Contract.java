package com.ruscript.tutorialproject.model;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "contract_table")
public class Contract {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "date")
    public Date date;

    @Column(name = "total")
    public double total;

    @ManyToMany
    @JoinTable(name="user_contract_table",
            joinColumns=@JoinColumn(name="contract_fk"),
            inverseJoinColumns=@JoinColumn(name="user_fk"))
    public List<User> userfk;

    @ManyToMany
    @JoinTable(name="position_contract_table",
            joinColumns=@JoinColumn(name="contract_fk"),
            inverseJoinColumns=@JoinColumn(name="position_fk"))
    public List<Position> positionfk;
}
