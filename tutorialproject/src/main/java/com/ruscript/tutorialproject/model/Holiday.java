package com.ruscript.tutorialproject.model;

import java.sql.Date;
import java.util.UUID;

public class Holiday {
    public int HolidayId;

    public Date HolidayStart;

    public Date HolidayEnd;

    public UUID UserFk;

    public Holiday() {
    }

    public int getHolidayId() {
        return HolidayId;
    }

    public void setHolidayId(int holidayId) {
        HolidayId = holidayId;
    }

    public Date getHolidayStart() {
        return HolidayStart;
    }

    public void setHolidayStart(Date holidayStart) {
        HolidayStart = holidayStart;
    }

    public Date getHolidayEnd() {
        return HolidayEnd;
    }

    public void setHolidayEnd(Date holidayEnd) {
        HolidayEnd = holidayEnd;
    }

    public UUID getUserFk() {
        return UserFk;
    }

    public void setUserFk(UUID userFk) {
        UserFk = userFk;
    }
}
