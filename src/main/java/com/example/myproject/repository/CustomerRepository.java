package com.example.myproject.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.myproject.model.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer> {

	@Modifying
	@Query("select c.tokenId, c.waitingTime from Customers c order by c.customerId desc")
	@Transactional
	public Customers getTokenAndWaitingTime();

	@Modifying
	@Query("delete from Customers c where c.tokenId= (select max(cs.tokenId) from Customers cs)")
	@Transactional
	public String deleteByTokenId();

	@Modifying
	@Query("select avg(c.waitingTime) from Customers c")
	@Transactional
	public String avgWaitTime();

	@Modifying
	@Query("select max(c.waitingChair) from Customers c")
	@Transactional
	public int findLargestChairNumber();

	@Modifying
	@Query("select count(*) from Customers c where c.customerLeft=true")
	@Transactional
	public int countByCustomerLeft();

}
