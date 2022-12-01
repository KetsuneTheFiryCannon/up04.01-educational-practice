package com.ruscript.tutorialproject.model;

import java.sql.Date;
import java.util.UUID;

public class Holiday {
    public int holidayid;

    public Date holidaystart;

    public Date holidayend;

    public UUID userfk;

    public Holiday() {
    }

    public int getHolidayid() {
        return holidayid;
    }

    public void setHolidayid(int holidayid) {
        this.holidayid = holidayid;
    }

    public Date getHolidaystart() {
        return holidaystart;
    }

    public void setHolidaystart(Date holidaystart) {
        this.holidaystart = holidaystart;
    }

    public Date getHolidayend() {
        return holidayend;
    }

    public void setHolidayend(Date holidayend) {
        this.holidayend = holidayend;
    }

    public UUID getUserfk() {
        return userfk;
    }

    public void setUserfk(UUID userfk) {
        this.userfk = userfk;
    }
}
