package com.payproapi.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.payproapi.api.entity.ApplyLeave;

@Repository
public interface ApplyLeaveRepository extends CrudRepository<ApplyLeave, Long> {

    @Query(value = "SELECT * FROM apply_leave", nativeQuery = true)
    Page<ApplyLeave> listAllApplyLeaves(Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM apply_leave", nativeQuery = true)
    String countApplyLeaves();
}
