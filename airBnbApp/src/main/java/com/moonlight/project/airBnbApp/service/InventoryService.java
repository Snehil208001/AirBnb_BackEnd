package com.moonlight.project.airBnbApp.service;

import com.moonlight.project.airBnbApp.entity.Room;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteFutureInventories(Room room);

    // Add this definition
    void deleteAllInventories(Room room);

}