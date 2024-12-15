package com.payproapi.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.payproapi.api.entity.ApplyLeave;
import com.payproapi.api.model.ApplyLeaveRequestBody;
import com.payproapi.api.repositories.ApplyLeaveRepository;

import java.time.LocalDate;

@Service
public class ApplyLeaveService {

    @Autowired
    private ApplyLeaveRepository applyLeaveRepository;

    public ApplyLeave applyLeave(ApplyLeaveRequestBody applyLeaveRequestBody) {
        ApplyLeave applyLeave = new ApplyLeave();
        applyLeave.setEmployeeId(applyLeaveRequestBody.getEmployeeId());
        applyLeave.setLeaveType(applyLeaveRequestBody.getLeaveType());
        applyLeave.setTotalDays(applyLeaveRequestBody.getTotalDays());
        applyLeave.setStartDate(LocalDate.parse(applyLeaveRequestBody.getStartDate()));
        applyLeave.setEndDate(LocalDate.parse(applyLeaveRequestBody.getEndDate()));
        applyLeave.setReason(applyLeaveRequestBody.getReason());
        return applyLeaveRepository.save(applyLeave);
    }

    public ApplyLeave updateApplyLeave(ApplyLeaveRequestBody applyLeaveRequestBody) {
        ApplyLeave applyLeave = applyLeaveRepository.findById(applyLeaveRequestBody.getLeaveId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid leave ID"));
        applyLeave.setEmployeeId(applyLeaveRequestBody.getEmployeeId());
        applyLeave.setLeaveType(applyLeaveRequestBody.getLeaveType());
        applyLeave.setTotalDays(applyLeaveRequestBody.getTotalDays());
        applyLeave.setStartDate(LocalDate.parse(applyLeaveRequestBody.getStartDate()));
        applyLeave.setEndDate(LocalDate.parse(applyLeaveRequestBody.getEndDate()));
        applyLeave.setReason(applyLeaveRequestBody.getReason());
        return applyLeaveRepository.save(applyLeave);
    }

    public Page<ApplyLeave> listAllApplyLeaves(int pageNumber, int size) {
        return applyLeaveRepository.listAllApplyLeaves(PageRequest.of(pageNumber, size));
    }

    public String deleteApplyLeave(Long leaveId) {
        ApplyLeave applyLeave = applyLeaveRepository.findById(leaveId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid leave ID"));
        applyLeaveRepository.delete(applyLeave);
        return "Leave application deleted successfully";
    }

    public String countApplyLeaves() {
        return applyLeaveRepository.countApplyLeaves();
    }
}
