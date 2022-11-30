package com.ruscript.tutorialproject.model;

public class Placement {
    public int PlacementId;

    public String PlacementName;

    public double PlacementCost;

    public boolean PlacementStatus;

    public int RoomFk;

    public Placement() {
    }

    public int getPlacementId() {
        return PlacementId;
    }

    public void setPlacementId(int placementId) {
        PlacementId = placementId;
    }

    public String getPlacementName() {
        return PlacementName;
    }

    public void setPlacementName(String placementName) {
        PlacementName = placementName;
    }

    public double getPlacementCost() {
        return PlacementCost;
    }

    public void setPlacementCost(double placementCost) {
        PlacementCost = placementCost;
    }

    public boolean isPlacementStatus() {
        return PlacementStatus;
    }

    public void setPlacementStatus(boolean placementStatus) {
        PlacementStatus = placementStatus;
    }

    public int getRoomFk() {
        return RoomFk;
    }

    public void setRoomFk(int roomFk) {
        RoomFk = roomFk;
    }
}
