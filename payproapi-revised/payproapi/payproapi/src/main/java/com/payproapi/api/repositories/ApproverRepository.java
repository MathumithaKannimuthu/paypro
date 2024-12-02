package com.payproapi.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.payproapi.api.entity.ApproverEntity;
@Repository
public interface  ApproverRepository extends CrudRepository<ApproverEntity,Integer> {

	@Query(value = "select * from  nandhini_approver ", nativeQuery = true)
	Page<ApproverEntity> listallApproverfromdb(Pageable pageable);

	@Query(value = "SELECT count(*) from nandhini_approver", nativeQuery = true)
	String countNumberOfApprovers();



}