package com.payproapi.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "yugan_leave")

public class LeaveEntity {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "LeaveID", nullable = false)
	    private int leaveId;

	    @Column(name = "Type", nullable = false)
	    private String type;

	    @Column(name = "Description", nullable = true, length = 500)
	    private String description;

	    @Column(name = "TotalDays", nullable = false)
	    private int totalDays;

	    @Column(name = "LeaveCode", nullable = false)
	    private String leaveCode;

		public int getLeaveId() {
			return leaveId;
		}

		public void setLeaveId(int leaveId) {
			this.leaveId = leaveId;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getTotalDays() {
			return totalDays;
		}

		public void setTotalDays(int totalDays) {
			this.totalDays = totalDays;
		}

		public String getLeaveCode() {
			return leaveCode;
		}

		public void setLeaveCode(String leaveCode) {
			this.leaveCode = leaveCode;
		}
	    
}