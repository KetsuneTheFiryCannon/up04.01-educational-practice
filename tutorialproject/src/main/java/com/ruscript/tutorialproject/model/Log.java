package com.ruscript.tutorialproject.model;

import java.util.UUID;

public class Log {
    public int logid;

    public String logactivity;

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
