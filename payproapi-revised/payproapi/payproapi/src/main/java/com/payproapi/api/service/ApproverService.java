package com.payproapi.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.payproapi.api.entity.ApproverEntity;
import com.payproapi.api.model.ApproverRequestBody;
import com.payproapi.api.model.EmpIdRequest;
import com.payproapi.api.repositories.ApproverRepository;

@Service
public class ApproverService  {

	@Autowired
	private ApproverRepository approverRepository;

	public ApproverEntity createApprover(ApproverRequestBody approverReqBody) {

		ApproverEntity newApprover = new ApproverEntity();
		newApprover.setEmployeeId(approverReqBody.getEmpId());
		newApprover.setFirstName(approverReqBody.getFirstName());
		newApprover.setLastName(approverReqBody.getLastName());
		newApprover.setDepartment(approverReqBody.getDepartment());
		newApprover.setManagerName(approverReqBody.getManagerName());
		return approverRepository.save(newApprover);		 
	}

	public ApproverEntity updateApprover(ApproverRequestBody approverReqBody) {
		ApproverEntity newApprover = new ApproverEntity();
		newApprover.setEmployeeId(approverReqBody.getEmpId());
		newApprover.setFirstName(approverReqBody.getFirstName());
		newApprover.setLastName(approverReqBody.getLastName());
		newApprover.setDepartment(approverReqBody.getDepartment());
		newApprover.setManagerName(approverReqBody.getManagerName());
		return approverRepository.save(newApprover);		 
	}

	public Optional<ApproverEntity> getApproverById(EmpIdRequest user)
	{
		int employeeId = user.getEmpId();
		return approverRepository.findById(employeeId);
	}
	public Page<ApproverEntity> listAllApprovers(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return approverRepository.listallApproverfromdb(pageable);
	}
 
	public String deleteApprover(EmpIdRequest user) {
		int approverId= user.getEmpId();
		approverRepository.deleteById(approverId);
		return "Record Deleted";
	}

	public String countNumberOfApprovers() {

		return approverRepository.countNumberOfApprovers();
	}

}