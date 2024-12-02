package com.payproapi.api.repositories;

import java.util.List;

 import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.payproapi.api.entity.EmployeeEntity;
import com.payproapi.api.model.EmployeeRequestBody;
 
@Repository
public interface  EmployeeRepository extends CrudRepository<EmployeeEntity,Integer> {

	@Query(value = "select * from  main_employee ", nativeQuery = true)
	Page<EmployeeEntity> listallusersfromdb(Pageable pageable);

	@Query(value = "SELECT count(*) from main_employee", nativeQuery = true)
	String countNumberOfEmployees();



}
