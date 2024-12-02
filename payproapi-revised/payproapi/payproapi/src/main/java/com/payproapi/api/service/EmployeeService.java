package com.payproapi.api.service;

import com.payproapi.api.entity.EmployeeEntity;
import com.payproapi.api.model.EmpIdRequest;
import com.payproapi.api.model.EmployeeRequestBody; 
import com.payproapi.api.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService  {

	@Autowired
	private EmployeeRepository employeeRepository;

	

	public EmployeeEntity createEmployee(EmployeeRequestBody empReqBody) {

		EmployeeEntity newEmployee = new EmployeeEntity();
		newEmployee.setFirstName(empReqBody.getFirstName());
		newEmployee.setLastName(empReqBody.getLastName());
		newEmployee.setDepartment(empReqBody.getDepartment());
		newEmployee.setManagerName(empReqBody.getManagerName());
		return employeeRepository.save(newEmployee);		 
	}

	public EmployeeEntity updateEmployee(EmployeeRequestBody empReqBody) {
		EmployeeEntity newEmployee = new EmployeeEntity();
		newEmployee.setEmpId(empReqBody.getEmpId());
		newEmployee.setFirstName(empReqBody.getFirstName());
		newEmployee.setLastName(empReqBody.getLastName());
		newEmployee.setDepartment(empReqBody.getDepartment());
		newEmployee.setManagerName(empReqBody.getManagerName());
		return employeeRepository.save(newEmployee);		 
	}

	public Page<EmployeeEntity> listallusersfromdb(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return employeeRepository.listallusersfromdb(pageable);
	}
 
	public String deleteEmployee(EmpIdRequest user) {
		int employeeId= user.getEmpId();
		employeeRepository.deleteById(employeeId);
		return "Record Deleted";
	}

	public String countNumberOfEmployees() {

		return employeeRepository.countNumberOfEmployees();
	}

}
