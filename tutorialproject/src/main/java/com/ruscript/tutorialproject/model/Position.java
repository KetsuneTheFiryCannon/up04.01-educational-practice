package com.ruscript.tutorialproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "position_table")
public class Position {

    @Id
    @Column(name = "position_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int positionid;

    @Column(name = "position_name")
    public String positionname;

    @Column(name = "position_price")
    public double positionprice;

    @ManyToOne(optional = true)
    public Supplier supplierfk;

    @ManyToMany
    @JoinTable(name="position_contract_table",
            joinColumns=@JoinColumn(name="position_fk"),
            inverseJoinColumns=@JoinColumn(name="contract_fk"))
    public List<Contract> contractfk;

    public Position() {
    }

    public Position(int positionid, String positionname, double positionprice, Supplier supplierfk) {
        this.positionid = positionid;
        this.positionname = positionname;
        this.positionprice = positionprice;
        this.supplierfk = supplierfk;
    }

    public int getPositionid() {
        return positionid;
    }

    public void setPositionid(int positionid) {
        this.positionid = positionid;
    }

    public String getPositionname() {
        return positionname;
    }

    public void setPositionname(String positionname) {
        this.positionname = positionname;
    }

    public double getPositionprice() {
        return positionprice;
    }

    public void setPositionprice(double positionprice) {
        this.positionprice = positionprice;
    }

    public Supplier getSupplierfk() {
        return supplierfk;
    }

    public void setSupplierfk(Supplier supplierfk) {
        this.supplierfk = supplierfk;
    }
}
