package com.ruscript.tutorialproject.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

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

    @OneToMany(mappedBy = "holidays", fetch = FetchType.EAGER)
    public Set<Holiday> holiday = new HashSet<>();

    @OneToMany(mappedBy = "rents", fetch = FetchType.EAGER)
    public Set<Rent> rent = new HashSet<>();

    @ManyToMany
    @JoinTable(name="user_contract_table",
            joinColumns=@JoinColumn(name="user_fk"),
            inverseJoinColumns=@JoinColumn(name="contract_fk"))
    public List<Contract> contractfk;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    public Set<Role> role;


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

    public User(UUID userId, String userlogin, String userpassword, boolean status, Document documentfk, Set<Holiday> holiday, Set<Rent> rent, Personality personaldatafk, Set<Role> role) {
        this.userId = userId;
        this.userlogin = userlogin;
        this.userpassword = userpassword;
        this.status = status;
        this.documentfk = documentfk;
        this.holiday = holiday;
        this.rent = rent;
        this.personaldatafk = personaldatafk;
        this.role = role;
    }

    public User() {
    }

    public Document getDocumentfk() {
        return documentfk;
    }

    public void setDocumentfk(Document documentfk) {
        this.documentfk = documentfk;
    }

    public Set<Holiday> getHoliday() {
        return holiday;
    }

    public void setHoliday(Set<Holiday> holiday) {
        this.holiday = holiday;
    }

    public Set<Rent> getRent() {
        return rent;
    }

    public void setRent(Set<Rent> rent) {
        this.rent = rent;
    }

    public Personality getPersonaldatafk() {
        return personaldatafk;
    }

    public void setPersonaldatafk(Personality personaldatafk) {
        this.personaldatafk = personaldatafk;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
}
