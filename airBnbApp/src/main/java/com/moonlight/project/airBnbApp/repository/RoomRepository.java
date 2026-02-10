package com.moonlight.project.airBnbApp.repository;

import com.moonlight.project.airBnbApp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
