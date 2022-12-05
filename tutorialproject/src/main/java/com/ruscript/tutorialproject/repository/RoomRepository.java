package com.ruscript.tutorialproject.repository;

import com.ruscript.tutorialproject.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
