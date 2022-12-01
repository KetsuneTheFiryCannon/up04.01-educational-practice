package com.ruscript.tutorialproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "photo_table")
public class Photo {
    @Id
    @Column(name = "photo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int photoid;

    @Column(name = "photo_path")
    public String photopath;

    @ManyToMany
    @JoinTable (name="advertisement_photo_like",
            joinColumns=@JoinColumn (name="photo_fk"),
            inverseJoinColumns=@JoinColumn(name="advertisement_fk"))

    private List<Advertisement> advertisements;

    public Photo() {
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    public int getPhotoid() {
        return photoid;
    }

    public void setPhotoid(int photoid) {
        this.photoid = photoid;
    }

    public String getPhotopath() {
        return photopath;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath;
    }
}
