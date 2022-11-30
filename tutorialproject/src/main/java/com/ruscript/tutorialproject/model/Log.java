package com.ruscript.tutorialproject.model;

import java.util.UUID;

public class Log {
    public int LogId;

    public String LogActivity;

    public UUID UserFk;

    public Log() {
    }

    public int getLogId() {
        return LogId;
    }

    public void setLogId(int logId) {
        LogId = logId;
    }

    public String getLogActivity() {
        return LogActivity;
    }

    public void setLogActivity(String logActivity) {
        LogActivity = logActivity;
    }

    public UUID getUserFk() {
        return UserFk;
    }

    public void setUserFk(UUID userFk) {
        UserFk = userFk;
    }
}
