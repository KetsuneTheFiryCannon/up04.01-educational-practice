package com.ruscript.tutorialproject.model;

import javax.persistence.*;

@Entity
@Table(name = "supplier_table")
public class Supplier {

    @Id
    @Column(name = "supplier_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int supplierid;

    @Column(name = "supplier_name")
    public String suppliername;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_data_fk")
    public Personality personaldatafk;

    public Supplier(int supplierid, String suppliername, Personality personaldatafk) {
        this.supplierid = supplierid;
        this.suppliername = suppliername;
        this.personaldatafk = personaldatafk;
    }

    public Supplier() {
    }

    public int getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(int supplierid) {
        this.supplierid = supplierid;
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public Personality getPersonaldatafk() {
        return personaldatafk;
    }

    public void setPersonaldatafk(Personality personaldatafk) {
        this.personaldatafk = personaldatafk;
    }
}
