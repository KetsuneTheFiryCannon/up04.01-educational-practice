package com.ruscript.tutorialproject.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "advertisment_table")
public class Advertisement {
    @Id
    @Column(name = "advertisment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int advertisementid;

    @Column(name = "advertisment_name")
    public String advertisementname;

    @Column(name = "advertisment_price")
    public double advertisementprice;

    @Column(name = "advertisment_status")
    public boolean advertisementstatus;

    @Column(name = "advertisment_text")
    public String advertisementtext;

    @Column(name = "resource_fk")
    public int resourcefk;

    @Column(name = "user_fk")
    public UUID userFk;

    @ManyToMany
    @JoinTable(name="advertisement_photo_like",
            joinColumns=@JoinColumn(name="advertisement_fk"),
            inverseJoinColumns=@JoinColumn(name="photo_fk"))
    public List<Photo> photos;

    public Advertisement() {
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public int getAdvertisementid() {
        return advertisementid;
    }

    public void setAdvertisementid(int advertisementid) {
        this.advertisementid = advertisementid;
    }

    public String getAdvertisementname() {
        return advertisementname;
    }

    public void setAdvertisementname(String advertisementname) {
        this.advertisementname = advertisementname;
    }

    public double getAdvertisementprice() {
        return advertisementprice;
    }

    public void setAdvertisementprice(double advertisementprice) {
        this.advertisementprice = advertisementprice;
    }

    public boolean isAdvertisementstatus() {
        return advertisementstatus;
    }

    public void setAdvertisementstatus(boolean advertisementstatus) {
        this.advertisementstatus = advertisementstatus;
    }

    public String getAdvertisementtext() {
        return advertisementtext;
    }

    public void setAdvertisementtext(String advertisementtext) {
        this.advertisementtext = advertisementtext;
    }

    public int getResourcefk() {
        return resourcefk;
    }

    public void setResourcefk(int resourcefk) {
        this.resourcefk = resourcefk;
    }

    public UUID getUserFk() {
        return userFk;
    }

    public void setUserFk(UUID userFk) {
        this.userFk = userFk;
    }
}
