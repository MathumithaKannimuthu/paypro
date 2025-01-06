package com.payproapi.api.controller;

import com.payproapi.api.entity.OvertimeEntity; // Ensure this is the correct package for OvertimeEntity
import com.payproapi.api.model.OvertimeRequestBody;
import com.payproapi.api.service.OvertimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/overtime")
public class OvertimeController {

    @Autowired
    private OvertimeService overtimeService;

    // Utility method for mapping OvertimeEntity to OvertimeRequestBody
    private OvertimeRequestBody mapToRequestBody(OvertimeEntity entity) {
        OvertimeRequestBody reqBody = new OvertimeRequestBody();
        reqBody.setField1(entity.getField1()); // Map all fields from entity to request body
        reqBody.setField2(entity.getField2());
        return reqBody;
    }

    // Utility method for mapping OvertimeRequestBody to OvertimeEntity
    private OvertimeEntity mapToEntity(OvertimeRequestBody reqBody) {
        OvertimeEntity entity = new OvertimeEntity();
        entity.setField1(reqBody.getField1()); // Map all fields from request body to entity
        entity.setField2(reqBody.getField2());
        return entity;
    }

    // Create a new overtime record
    @PostMapping("/create")
    public ResponseEntity<OvertimeRequestBody> createOvertime(@RequestBody OvertimeRequestBody reqBody) {
        OvertimeEntity entity = mapToEntity(reqBody);
        OvertimeEntity createdEntity = overtimeService.createOvertime(entity);
        OvertimeRequestBody createdOvertime = mapToRequestBody(createdEntity);
        return new ResponseEntity<>(createdOvertime, HttpStatus.CREATED);  // HTTP 201 Created
    }

    // Update an existing overtime record
    @PutMapping("/update")
    public ResponseEntity<OvertimeRequestBody> updateOvertime(@RequestBody OvertimeRequestBody reqBody) {
        try {
            OvertimeEntity entity = mapToEntity(reqBody);
            OvertimeEntity updatedEntity = overtimeService.updateOvertime(entity);
            OvertimeRequestBody updatedOvertime = mapToRequestBody(updatedEntity);
            return ResponseEntity.ok(updatedOvertime);  // HTTP 200 OK
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // HTTP 404 Not Found
        }
    }

    // List all overtime records with pagination
    @GetMapping("/list")
    public ResponseEntity<?> listAllOvertime(@RequestParam(defaultValue = "0") int pageNumber,
                                             @RequestParam(defaultValue = "10") int size) {
        var entities = overtimeService.listAllUsersFromDb(pageNumber, size);
        var responseList = entities.stream()
                .map(this::mapToRequestBody)
                .toList();
        return ResponseEntity.ok(responseList); // HTTP 200 OK
    }

    // Delete an overtime record by its ID
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteOvertime(@RequestParam Long overtimeId) {
        overtimeService.deleteOvertime(overtimeId);
        return ResponseEntity.ok("Record Deleted"); // HTTP 200 OK
    }

    // Count the total number of overtime records
    @GetMapping("/count")
    public ResponseEntity<Long> countOvertime() {
        long count = overtimeService.countNumberOfOvertime();
        return ResponseEntity.ok(count); // HTTP 200 OK
    }
}



