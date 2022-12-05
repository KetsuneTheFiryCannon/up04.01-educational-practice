package com.ruscript.tutorialproject.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "holiday_table")
public class Holiday {

    @Id
    @Column(name = "holiday_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int holidayid;

    @Column(name = "holiday_start")
    public Date holidaystart;

    @Column(name = "holiday_end")
    public Date holidayend;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    public User holidays;

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

    public User getUser() {
        return holidays;
    }

    public void setUser(User user) {
        this.holidays = user;
    }
}
