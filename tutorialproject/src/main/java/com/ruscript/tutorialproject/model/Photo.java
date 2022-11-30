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

    @Id
    @Column(name = "photo_path")
    public String photopath;

    @ManyToMany
    @JoinTable (name="advertisment_photo_table",
            joinColumns=@JoinColumn (name="advertisment_fk"),
            inverseJoinColumns=@JoinColumn(name="photo_fk"))
    private List<Advertisement> universities;

    public Photo() {
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
