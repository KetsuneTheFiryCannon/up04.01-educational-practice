package com.ruscript.tutorialproject.model;

public class Placement {
    public int placementid;

    public String placementname;

    public double placementcost;

    public boolean placementstatus;

    public int roomfk;

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

    public int getRoomfk() {
        return roomfk;
    }

    public void setRoomfk(int roomfk) {
        this.roomfk = roomfk;
    }
}
