package com.moonlight.project.airBnbApp.repository;

import com.moonlight.project.airBnbApp.entity.Inventory;
import com.moonlight.project.airBnbApp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    void deleteByDateAfterAndRoom(LocalDate date, Room room);

    // Add this new method
    void deleteByRoom(Room room);
}