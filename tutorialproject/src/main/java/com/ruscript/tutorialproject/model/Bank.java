package com.ruscript.tutorialproject.model;

import javax.persistence.*;

@Entity
@Table(name = "bank_table")
public class Bank {

    @Id
    @Column(name = "bank_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int bankid;

    @Column(name = "bank_name")
    public String nankname;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_data_fk")
    public Personality personaldatafk;

    public Bank() {
    }

    public int getBankid() {
        return bankid;
    }

    public void setBankid(int bankid) {
        this.bankid = bankid;
    }

    public String getNankname() {
        return nankname;
    }

    public void setNankname(String nankname) {
        this.nankname = nankname;
    }

    public Personality getPersonaldatafk() {
        return personaldatafk;
    }

    public void setPersonaldatafk(Personality personaldatafk) {
        this.personaldatafk = personaldatafk;
    }
}
