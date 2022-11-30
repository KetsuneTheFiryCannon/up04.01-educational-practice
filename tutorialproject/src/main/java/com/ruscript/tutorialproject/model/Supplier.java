package com.ruscript.tutorialproject.model;

public class Supplier {
    public int SupplierId;

    public String SupplierName;

    public int PersonalDataFk;

    public Supplier() {
    }

    public int getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(int supplierId) {
        SupplierId = supplierId;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public int getPersonalDataFk() {
        return PersonalDataFk;
    }

    public void setPersonalDataFk(int personalDataFk) {
        PersonalDataFk = personalDataFk;
    }
}
