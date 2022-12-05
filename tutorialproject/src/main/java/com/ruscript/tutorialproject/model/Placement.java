package com.ruscript.tutorialproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "placement_table")
public class Placement {

    @Id
    @Column(name = "placement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int placementid;

    @Column(name = "placement_name")
    public String placementname;

    @Column(name = "placement_cost")
    public double placementcost;

    @Column(name = "placement_status")
    public boolean placementstatus;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    public Room roomfk;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "rentfk")
    public Rent rentfk;

    public Placement() {
    }

    public int getPlacementid() {
        return placementid;
    }

    public void setPlacementid(int placementid) {
        this.placementid = placementid;
    }

    public String getPlacementname() {
        return placementname;
    }

    public void setPlacementname(String placementname) {
        this.placementname = placementname;
    }

    public double getPlacementcost() {
        return placementcost;
    }

    public void setPlacementcost(double placementcost) {
        this.placementcost = placementcost;
    }

    public boolean isPlacementstatus() {
        return placementstatus;
    }

    public void setPlacementstatus(boolean placementstatus) {
        this.placementstatus = placementstatus;
    }

    public Room getRoomfk() {
        return roomfk;
    }

    public void setRoomfk(Room roomfk) {
        this.roomfk = roomfk;
    }
}
