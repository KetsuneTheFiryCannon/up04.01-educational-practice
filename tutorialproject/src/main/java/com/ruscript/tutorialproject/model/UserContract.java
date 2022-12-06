package com.ruscript.tutorialproject.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user_contract_table")
public class UserContract {

    @Id
    @Column(name = "user_contract_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int UserContractId;

    @Column(name = "user_fk")
    public UUID UserFk;

    @Column(name = "contract_fk")
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
