package com.ruscript.tutorialproject.service;

import com.ruscript.tutorialproject.model.Room;
import com.ruscript.tutorialproject.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    final
    RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void save(Room room) { roomRepository.save(room); }

    public void delete(Room room) { roomRepository.delete(room); }

    public List<Room> findAll() { return roomRepository.findAll(); }

    public Room findById(int i) { return roomRepository.findById(i).orElseThrow(); }
}
