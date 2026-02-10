package com.moonlight.project.airBnbApp.repository;

import com.moonlight.project.airBnbApp.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
