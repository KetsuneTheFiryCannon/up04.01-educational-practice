package com.ruscript.tutorialproject.model;

import javax.persistence.*;

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

    public int supplierfk;

    public Position() {
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

    public int getSupplierfk() {
        return supplierfk;
    }

    public void setSupplierfk(int supplierfk) {
        this.supplierfk = supplierfk;
    }
}
