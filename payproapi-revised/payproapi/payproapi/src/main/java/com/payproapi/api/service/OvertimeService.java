package com.payproapi.api.service;

import com.payproapi.api.entity.OvertimeEntity;
import com.payproapi.api.model.OvertimeRequestBody;
import com.payproapi.api.repositories.OvertimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class OvertimeService {

    @Autowired
    private OvertimeRepository overtimeRepository;

    // Method to create a new Overtime record
    public OvertimeEntity createOvertime(OvertimeRequestBody reqBody) {
        OvertimeEntity entity = new OvertimeEntity();
        entity.setOvertimeId(reqBody.getOvertimeId()); // Ensure overtimeId is a Long
        entity.setOvertimeHours(reqBody.getOvertimeHours()); // Ensure overtimeHours is a proper type (Double or Integer)
        entity.setOvertimeRate(reqBody.getOvertimeRate()); // Ensure overtimeRate is a proper type (Double)
        entity.setOvertimeDate(convertToDate(reqBody.getOvertimeDate())); // Convert String to LocalDate
        return overtimeRepository.save(entity);
    }

    // Method to update an existing Overtime record
    public OvertimeEntity updateOvertime(OvertimeRequestBody reqBody) {
        Optional<OvertimeEntity> existingEntity = overtimeRepository.findById(reqBody.getOvertimeId());
        
        if(existingEntity.isPresent()) {
            OvertimeEntity entity = existingEntity.get();
            entity.setOvertimeHours(reqBody.getOvertimeHours()); // Update overtimeHours
            entity.setOvertimeRate(reqBody.getOvertimeRate()); // Update overtimeRate
            entity.setOvertimeDate(convertToDate(reqBody.getOvertimeDate())); // Update overtimeDate
            return overtimeRepository.save(entity);
        } else {
            throw new IllegalArgumentException("Overtime record not found for ID: " + reqBody.getOvertimeId());
        }
    }

    // Method to list all overtime records with pagination
    public Page<OvertimeEntity> listAllUsersFromDb(int pageNumber, int size) {
        Pageable pageable = PageRequest.of(pageNumber, size);
        return overtimeRepository.findAll(pageable); // Paginated results
    }

    // Method to delete an Overtime record
    public String deleteOvertime(Long overtimeId) { 
        overtimeRepository.deleteById(overtimeId); // Delete by ID
        return "Record Deleted";
    }

    // Method to count the number of overtime records
    public long countNumberOfOvertime() {
        return overtimeRepository.count(); // Returns the count of records
    }

    // Helper method to convert date String to LocalDate
    private LocalDate convertToDate(String dateString) {
        if (dateString == null || dateString.isEmpty()) {
            return null; // Handle null or empty strings safely
        }
        return LocalDate.parse(dateString); // Assumes ISO-8601 formatted String (e.g., "2024-12-16")
    }
}



