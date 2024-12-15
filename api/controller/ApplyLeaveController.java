package com.payproapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.payproapi.api.model.ApplyLeaveRequestBody;
import com.payproapi.api.service.ApplyLeaveService;

@RestController
@CrossOrigin(origins = "*")
public class ApplyLeaveController {

    @Autowired
    private ApplyLeaveService applyLeaveService;

    @RequestMapping(value = "/applyLeave", method = RequestMethod.POST)
    public ResponseEntity<?> applyLeave(@RequestBody ApplyLeaveRequestBody applyLeaveRequestBody) throws Exception {
        return ResponseEntity.ok(applyLeaveService.applyLeave(applyLeaveRequestBody));
    }

    @RequestMapping(value = "/updateApplyLeave", method = RequestMethod.PUT)
    public ResponseEntity<?> updateApplyLeave(@RequestBody ApplyLeaveRequestBody applyLeaveRequestBody) throws Exception {
        return ResponseEntity.ok(applyLeaveService.updateApplyLeave(applyLeaveRequestBody));
    }

    @RequestMapping(value = "/listAllApplyLeaves", method = RequestMethod.GET)
    public ResponseEntity<?> listAllApplyLeaves(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                @RequestParam(defaultValue = "10") Integer size) throws Exception {
        return ResponseEntity.ok(applyLeaveService.listAllApplyLeaves(pageNumber, size));
    }

    @RequestMapping(value = "/deleteApplyLeave", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteApplyLeave(@RequestParam Integer leaveId) {
        try {
            return ResponseEntity.ok(applyLeaveService.deleteApplyLeave(Long.valueOf(leaveId)));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/applyLeavesCount", method = RequestMethod.GET)
    public ResponseEntity<?> countApplyLeaves() throws Exception {
        return ResponseEntity.ok(applyLeaveService.countApplyLeaves());
    }
}
