package com.payproapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payproapi.api.model.EmployeeRequestBody;
import com.payproapi.api.model.EmpIdRequest;
import com.payproapi.api.service.EmployeeService;
  
@RestController
@CrossOrigin
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;	
	
	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
	public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequestBody employeeReqBody) throws Exception {
		return ResponseEntity.ok(employeeService.createEmployee(employeeReqBody));
	}
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
	public ResponseEntity<?> updateEmployee(@RequestBody EmployeeRequestBody employeeReqBody) throws Exception {
		return ResponseEntity.ok(employeeService.updateEmployee(employeeReqBody));
	}		
	
	@RequestMapping(value = "/listAllEmployees", method = RequestMethod.GET)
	public ResponseEntity<?> listAllEmployees(@RequestParam(defaultValue = "0") final Integer pageNumber,
			@RequestParam(defaultValue = "10") final Integer size) throws Exception {
		return ResponseEntity.ok(employeeService.listallusersfromdb(pageNumber, size));
	}		
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmployee(@RequestBody EmpIdRequest user) throws Exception {
		return ResponseEntity.ok(employeeService.deleteEmployee(user));
	}		
	
	@RequestMapping(value = "/employeescount", method = RequestMethod.GET)
	public ResponseEntity<?> countNumberOfEmployees() throws Exception {
		return ResponseEntity.ok((employeeService.countNumberOfEmployees()));
	}
	
}
