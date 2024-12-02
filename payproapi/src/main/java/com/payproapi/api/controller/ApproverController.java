package com.payproapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payproapi.api.model.ApproverRequestBody;
import com.payproapi.api.model.EmpIdRequest;
import com.payproapi.api.service.ApproverService;
  
@RestController
@CrossOrigin(origins="*")
public class ApproverController {
	
	@Autowired
	private ApproverService approverService;	
	
	@RequestMapping(value = "/createApprover", method = RequestMethod.POST)
	public ResponseEntity<?> createApprover(@RequestBody ApproverRequestBody approverReqBody) throws Exception {
		return ResponseEntity.ok(approverService.createApprover(approverReqBody));
	}
	
	@RequestMapping(value = "/updateApprover", method = RequestMethod.PUT)
	public ResponseEntity<?> updateApprover(@RequestBody ApproverRequestBody approverReqBody) throws Exception {
		return ResponseEntity.ok(approverService.updateApprover(approverReqBody));
	}		
	
	@RequestMapping(value = "/listAllApprovers", method = RequestMethod.GET)
	public ResponseEntity<?> listAllApprovers(@RequestParam(defaultValue = "0") Integer pageNumber,
			@RequestParam(defaultValue = "10") Integer size) throws Exception {
		return ResponseEntity.ok(approverService.listAllApprovers(pageNumber, size));
	}		
	
	@RequestMapping(value = "/getApprover", method = RequestMethod.GET)
	public ResponseEntity<?> getApprover(@RequestBody EmpIdRequest user) throws Exception {
		return ResponseEntity.ok(approverService.getApproverById(user));
	}	
	
	@RequestMapping(value = "/deleteApprover", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteApprover(@RequestBody EmpIdRequest user) throws Exception {
		return ResponseEntity.ok(approverService.deleteApprover(user));
	}		
	
	@RequestMapping(value = "ApproversCount", method = RequestMethod.GET)
	public ResponseEntity<?> countNumberOfApprovers() throws Exception {
		return ResponseEntity.ok((approverService.countNumberOfApprovers()));
	}
	
}