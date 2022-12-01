package com.ruscript.tutorialproject.model;

public class Position {
    public int positionid;

    public String positionname;

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
