package com.ruscript.tutorialproject.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.print.Doc;
import java.util.UUID;

@Entity
@Table(name = "user_table")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "uuidgen")
    @GenericGenerator(name = "uuidgen", strategy = "org.hibernate.id.UUIDGenerator")
    public UUID userId;

    @Column(name = "user_login")
    public String userlogin;

    @Column(name = "user_password")
    public String userpassword;

    @Column(name = "status")
    public boolean status;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "document_fk")
    public Document documentfk;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_data_fk")
    public Personality personaldatafk;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_fk")
    public Role rolefk;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUserlogin() {
        return userlogin;
    }

    public void setUserlogin(String userlogin) {
        this.userlogin = userlogin;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public User(String userlogin, String userpassword, Document documentfk, Personality personaldatafk, Role rolefk) {
        this.userlogin = userlogin;
        this.userpassword = userpassword;
        this.documentfk = documentfk;
        this.personaldatafk = personaldatafk;
        this.rolefk = rolefk;
    }

    public User() {
    }

    public Document getDocumentfk() {
        return documentfk;
    }

    public void setDocumentfk(Document documentfk) {
        this.documentfk = documentfk;
    }

    public Personality getPersonaldatafk() {
        return personaldatafk;
    }

    public void setPersonaldatafk(Personality personaldatafk) {
        this.personaldatafk = personaldatafk;
    }

    public Role getRolefk() {
        return rolefk;
    }

    public void setRolefk(Role rolefk) {
        this.rolefk = rolefk;
    }
}
