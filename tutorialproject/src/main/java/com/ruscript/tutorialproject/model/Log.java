package com.ruscript.tutorialproject.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "log_table")
public class Log {

    @Id
    @Column(name = "log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int logid;

    @Column(name = "log_activity")
    public String logactivity;

    //@Column(name = "")
    public UUID userfk;

    public Log() {
    }

    public int getLogid() {
        return logid;
    }

    public void setLogid(int logid) {
        this.logid = logid;
    }

    public String getLogactivity() {
        return logactivity;
    }

    public void setLogactivity(String logactivity) {
        this.logactivity = logactivity;
    }

    public UUID getUserfk() {
        return userfk;
    }

    public void setUserfk(UUID userfk) {
        this.userfk = userfk;
    }
}
