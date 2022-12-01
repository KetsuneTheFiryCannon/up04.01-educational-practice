package com.ruscript.tutorialproject.model;

import javax.persistence.*;

@Entity
@Table(name = "advertisement_photo_like")
public class AdvertisementPhoto {

    @Id
    @Column(name = "apid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int apid;

    @Column(name = "photo_fk")
    public int photofk;

    @Column(name = "advertisement_fk")
    public int advertisementfk;
}
