package com.inventarymanagementsystem.InventaryMangementSystem.repository;

import com.inventarymanagementsystem.InventaryMangementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.inventarymanagementsystem.InventaryMangementSystem.model.User;
@Repository
public interface WorkerRepository extends JpaRepository<User,Integer> {
   User findByUsername(String username);
}
