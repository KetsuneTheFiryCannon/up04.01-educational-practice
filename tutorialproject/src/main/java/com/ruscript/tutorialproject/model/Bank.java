package com.ruscript.tutorialproject.model;

import javax.persistence.*;

@Entity
@Table(name = "bank_table")
public class Bank {

    @Id
    @Column(name = "bank_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int BankId;

    @Column(name = "bank_name")
    public String BankName;

    @Column(name = "personal_data_fk")
    public int PersonalDataFk;

    public Bank() {
    }

    public int getBankId() {
        return BankId;
    }

    public void setBankId(int bankId) {
        BankId = bankId;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }

    public int getPersonalDataFk() {
        return PersonalDataFk;
    }

    public void setPersonalDataFk(int personalDataFk) {
        PersonalDataFk = personalDataFk;
    }
}
