package com.ruscript.tutorialproject.model;

import java.sql.Date;

public class Rent {
    public int RentContractId;

    public Date RentContractStart;

    public Date RentContractEnd;

    public double Total;

    public boolean Status;

    public int PlacementFk;

    public Rent() {
    }

    public int getRentContractId() {
        return RentContractId;
    }

    public void setRentContractId(int rentContractId) {
        RentContractId = rentContractId;
    }

    public Date getRentContractStart() {
        return RentContractStart;
    }

    public void setRentContractStart(Date rentContractStart) {
        RentContractStart = rentContractStart;
    }

    public Date getRentContractEnd() {
        return RentContractEnd;
    }

    public void setRentContractEnd(Date rentContractEnd) {
        RentContractEnd = rentContractEnd;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public int getPlacementFk() {
        return PlacementFk;
    }

    public void setPlacementFk(int placementFk) {
        PlacementFk = placementFk;
    }
}
