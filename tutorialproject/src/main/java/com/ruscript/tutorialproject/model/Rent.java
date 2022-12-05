package com.ruscript.tutorialproject.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "rent_contract_table")
public class Rent {

    @Id
    @Column(name = "rent_contract_id")
    public int rentcontractid;

    @Column(name = "rent_contract_start")
    public Date rentcontractstart;

    @Column(name = "rent_contract_end")
    public Date rentcontractend;

    @Column(name = "total")
    public double total;

    @Column(name = "status")
    public boolean status;

    @OneToOne(optional = true, mappedBy = "rentfk")
    public Placement placementfk;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    public User rents;

    public Rent() {
    }

    public int getRentcontractid() {
        return rentcontractid;
    }

    public void setRentcontractid(int rentcontractid) {
        this.rentcontractid = rentcontractid;
    }

    public Date getRentcontractstart() {
        return rentcontractstart;
    }

    public void setRentcontractstart(Date rentcontractstart) {
        this.rentcontractstart = rentcontractstart;
    }

    public Date getRentcontractend() {
        return rentcontractend;
    }

    public void setRentcontractend(Date rentcontractend) {
        this.rentcontractend = rentcontractend;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Placement getPlacementfk() {
        return placementfk;
    }

    public void setPlacementfk(Placement placementfk) {
        this.placementfk = placementfk;
    }

    public User getRents() {
        return rents;
    }

    public void setRents(User rents) {
        this.rents = rents;
    }
}
