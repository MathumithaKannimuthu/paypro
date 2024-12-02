package com.payproapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payproapi.api.model.LeaveIdRequest;
import com.payproapi.api.model.LeaveRequestBody;
import com.payproapi.api.service.LeaveService;
  
@RestController
@CrossOrigin(origins="*")
public class LeaveController {
	
	@Autowired
    private LeaveService leaveService;

    @RequestMapping(value = "/createLeave", method = RequestMethod.POST)
    public ResponseEntity<?> createLeave(@RequestBody LeaveRequestBody leaveReqBody) throws Exception {
        return ResponseEntity.ok(leaveService.createLeave(leaveReqBody));
    }
    @RequestMapping(value = "/updateLeave", method = RequestMethod.PUT)
    public ResponseEntity<?> updateLeave(@RequestBody LeaveRequestBody leaveReqBody) throws Exception {
        return ResponseEntity.ok(leaveService.updateLeave(leaveReqBody));
    }
    @RequestMapping(value = "/listAllLeaves", method = RequestMethod.GET)
    public ResponseEntity<?> listAllLeaves(@RequestParam(defaultValue = "0") final Integer pageNumber,
                                           @RequestParam(defaultValue = "10") final Integer size) throws Exception {
        return ResponseEntity.ok(leaveService.listAllLeaves(pageNumber, size));
    }


    @RequestMapping(value = "/deleteLeave", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteLeave(@RequestBody LeaveIdRequest leaveIdRequest) throws Exception {
        return ResponseEntity.ok(leaveService.deleteLeave(leaveIdRequest));
    }
    @RequestMapping(value = "/leavesCount", method = RequestMethod.GET)
    public ResponseEntity<?> countNumberOfLeaves() throws Exception {
        return ResponseEntity.ok(leaveService.countNumberOfLeaves());
    }
	
}