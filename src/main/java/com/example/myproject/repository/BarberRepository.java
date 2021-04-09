package com.example.myproject.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.myproject.model.BarberCustomers;


@Repository
public interface BarberRepository extends JpaRepository<BarberCustomers, Integer>{

	@Modifying
	@Query("select max(bc.tokenId) from BarberCustomers bc")
	@Transactional
	public int findLargestToken();

	@Modifying
	@Query("select bc.barberId from BarberCustomers bc where  bc.isBarberEngaged=false ")
	@Transactional
	public int findFreeBarbers();

}
