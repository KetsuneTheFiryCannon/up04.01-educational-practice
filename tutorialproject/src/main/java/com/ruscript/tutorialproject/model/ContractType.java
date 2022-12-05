package com.ruscript.tutorialproject.model;

import javax.persistence.*;

@Entity
@Table(name = "contract_type_table")
public class ContractType {

    @Id
    @Column(name = "contract_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int contracttypeid;

    @Column(name = "contract_type")
    public String contracttype;

    public ContractType() {
    }

    public int getContracttypeid() {
        return contracttypeid;
    }

    public void setContracttypeid(int contracttypeid) {
        this.contracttypeid = contracttypeid;
    }

    public String getContracttype() {
        return contracttype;
    }

    public void setContracttype(String contracttype) {
        this.contracttype = contracttype;
    }
}
