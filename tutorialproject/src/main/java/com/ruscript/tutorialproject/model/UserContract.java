package com.ruscript.tutorialproject.model;

import java.util.UUID;

public class UserContract {
    public int UserContractId;

    public UUID UserFk;

    public int ContractFk;

    public UserContract() {
    }

    public int getUserContractId() {
        return UserContractId;
    }

    public void setUserContractId(int userContractId) {
        UserContractId = userContractId;
    }

    public UUID getUserFk() {
        return UserFk;
    }

    public void setUserFk(UUID userFk) {
        UserFk = userFk;
    }

    public int getContractFk() {
        return ContractFk;
    }

    public void setContractFk(int contractFk) {
        ContractFk = contractFk;
    }
}
