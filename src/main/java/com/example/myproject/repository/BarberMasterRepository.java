package com.example.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myproject.model.BarberMaster;

@Repository
public interface BarberMasterRepository extends JpaRepository<BarberMaster, Integer> {

}
