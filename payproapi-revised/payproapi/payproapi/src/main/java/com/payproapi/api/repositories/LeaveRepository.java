package com.payproapi.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.payproapi.api.entity.LeaveEntity;
 
@Repository
public interface  LeaveRepository extends CrudRepository<LeaveEntity,Integer> {

	@Query(value = "select * from  nandhini_leave ", nativeQuery = true)
	Page<LeaveEntity> listallLeavefromdb(Pageable pageable);

	@Query(value = "SELECT count(*) from nandhini_leave", nativeQuery = true)
	String countNumberOfLeaves();



}