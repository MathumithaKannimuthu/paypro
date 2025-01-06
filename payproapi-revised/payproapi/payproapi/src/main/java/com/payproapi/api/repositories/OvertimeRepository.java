package com.payproapi.api.repositories;

import com.payproapi.api.entity.OvertimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OvertimeRepository extends JpaRepository<OvertimeEntity, Long> {

    // Custom method to delete by ID, already provided by JpaRepository, but you can keep it if needed
    void deleteById(Long id);

    // Method to find all overtime entries with pagination
    Page<OvertimeEntity> findAll(Pageable pageable);

    // You can add other custom query methods as needed, e.g.:
    // List<OvertimeEntity> findByEmployeeId(Long employeeId);
}


