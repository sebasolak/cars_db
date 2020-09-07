package com.example.db_project.dao;

import com.example.db_project.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("mysql")
public interface CarDao extends JpaRepository<Car, Long> {
}
