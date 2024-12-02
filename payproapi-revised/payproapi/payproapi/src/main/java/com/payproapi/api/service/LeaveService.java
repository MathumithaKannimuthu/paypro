package com.payproapi.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.payproapi.api.entity.LeaveEntity;
import com.payproapi.api.model.LeaveIdRequest;
import com.payproapi.api.model.LeaveRequestBody;
import com.payproapi.api.repositories.LeaveRepository;

@Service
public class LeaveService  {

	@Autowired
	private LeaveRepository leaveRepository;

	

	public LeaveEntity createLeave(LeaveRequestBody leaveReqBody) {

		LeaveEntity newLeave = new LeaveEntity();
		newLeave.setLeaveId(leaveReqBody.getLeaveId());
		newLeave.setType(leaveReqBody.getType());
		newLeave.setDescription(leaveReqBody.getDescription());
		newLeave.setTotalDays(leaveReqBody.getTotalDays());
		newLeave.setLeaveCode(leaveReqBody.getLeaveCode());
		return leaveRepository.save(newLeave);		 
	}

	public LeaveEntity updateLeave(LeaveRequestBody leaveReqBody) {
		LeaveEntity newLeave = new LeaveEntity();
		newLeave.setLeaveId(leaveReqBody.getLeaveId());
		newLeave.setType(leaveReqBody.getType());
		newLeave.setDescription(leaveReqBody.getDescription());
		newLeave.setTotalDays(leaveReqBody.getTotalDays());
		newLeave.setLeaveCode(leaveReqBody.getLeaveCode());
		return leaveRepository.save(newLeave);		 
	}

	public Optional<LeaveEntity> getLeaveById(LeaveIdRequest leave)
	{
		int leaveId = leave.getLeaveId();
		return leaveRepository.findById(leaveId);
	}
	public Page<LeaveEntity> listAllLeaves(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return leaveRepository.listallLeavefromdb(pageable);
	}
 
	public String deleteLeave(LeaveIdRequest user) {
		int leaveId= user.getLeaveId();
		leaveRepository.deleteById(leaveId);
		return "Record Deleted";
	}

	public String countNumberOfLeaves() {

		return leaveRepository.countNumberOfLeaves();
	}

}