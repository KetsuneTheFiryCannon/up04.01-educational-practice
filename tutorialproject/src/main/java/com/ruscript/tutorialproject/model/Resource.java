package com.ruscript.tutorialproject.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Resource {

    @Id
    public int ResourceId;

    public String ResourceName;

    public int PersonalDataFk;

    public Resource() {
    }

    public int getResourceId() {
        return ResourceId;
    }

    public void setResourceId(int resourceId) {
        ResourceId = resourceId;
    }

    public String getResourceName() {
        return ResourceName;
    }

    public void setResourceName(String resourceName) {
        ResourceName = resourceName;
    }

    public int getPersonalDataFk() {
        return PersonalDataFk;
    }

    public void setPersonalDataFk(int personalDataFk) {
        PersonalDataFk = personalDataFk;
    }
}
