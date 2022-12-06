package com.ruscript.tutorialproject.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "room_table")
public class Room {

    @Id
    @Column(name = "room_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int roomid;

    @Column(name = "room_name")
    public String roomname;

    @OneToMany(mappedBy = "roomfk", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Collection<Placement> placements;

    public Room(int roomid, String roomname, Collection<Placement> placements) {
        this.roomid = roomid;
        this.roomname = roomname;
        this.placements = placements;
    }

    public Room() {
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public Collection<Placement> getPlacements() {
        return placements;
    }

    public void setPlacements(Collection<Placement> placements) {
        this.placements = placements;
    }
}
