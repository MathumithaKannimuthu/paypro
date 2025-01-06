package com.payproapi.api.model;

import java.time.LocalDate;

public class OvertimeRequestBody {
    private Long overtimeId;       // Use Long for ID
    private Integer overtimeHours; // Use Integer for hours
    private Double overtimeRate;   // Use Double for rate
    private String overtimeDate;   // Keep as String for input (ISO-8601 format)

    // Getters and Setters
    public Long getOvertimeId() {
        return overtimeId;
    }

    public void setOvertimeId(Long overtimeId) {
        this.overtimeId = overtimeId;
    }

    public Integer getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(Integer overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public Double getOvertimeRate() {
        return overtimeRate;
    }

    public void setOvertimeRate(Double overtimeRate) {
        this.overtimeRate = overtimeRate;
    }

    public String getOvertimeDate() {
        return overtimeDate;
    }

    public void setOvertimeDate(String overtimeDate) {
        this.overtimeDate = overtimeDate;
    }
}

