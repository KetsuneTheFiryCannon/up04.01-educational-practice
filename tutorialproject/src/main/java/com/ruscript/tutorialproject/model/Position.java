package com.ruscript.tutorialproject.model;

public class Position {
    public int PositionId;

    public String PositionName;

    public double PositionPrice;

    public int SupplierFk;

    public Position() {
    }

    public int getPositionId() {
        return PositionId;
    }

    public void setPositionId(int positionId) {
        PositionId = positionId;
    }

    public String getPositionName() {
        return PositionName;
    }

    public void setPositionName(String positionName) {
        PositionName = positionName;
    }

    public double getPositionPrice() {
        return PositionPrice;
    }

    public void setPositionPrice(double positionPrice) {
        PositionPrice = positionPrice;
    }

    public int getSupplierFk() {
        return SupplierFk;
    }

    public void setSupplierFk(int supplierFk) {
        SupplierFk = supplierFk;
    }
}
